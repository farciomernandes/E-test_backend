package com.example.etest.controller;

import com.example.etest.controller.form.CriarQuestaoForm;
import com.example.etest.model.Alternativa;
import com.example.etest.model.Questao;
import com.example.etest.repository.AlternativaRepository;
import com.example.etest.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    AlternativaRepository alternativaRepository;
    @GetMapping
    public ResponseEntity lista(){
        List<Questao> questoes =  questaoRepository.findAll();
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Questao> questao = questaoRepository.findById(id);
        return ResponseEntity.ok(questao.get().getAlternativas());
    }

    @GetMapping("/unidade/{unidade}")
    public ResponseEntity buscarPorUnidade(@PathVariable String unidade){
        List<Questao> questoes = questaoRepository.findAllByUnidade(unidade);
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/disciplina/{disciplina}")
    public ResponseEntity buscarPorDisciplina(@PathVariable String disciplina){
        List<Questao> questoes = questaoRepository.findAllByDisciplina(disciplina);
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/assunto/{assunto}")
    public ResponseEntity buscarPorAssunto(@PathVariable String assunto){
        List<Questao> questoes = questaoRepository.findAllByAssunto(assunto);
        return ResponseEntity.ok(questoes);
    }

    @PostMapping()
    @Transactional()
    public ResponseEntity adicionar(@RequestBody CriarQuestaoForm form){
        Optional<Questao> descricaoQuestao = questaoRepository.findByDescricao(form.getDescricao());

        if(descricaoQuestao.isPresent()){
            return ResponseEntity.status(404).body("Já existe uma questao com esse enunciado");
        }

        Questao questao = new Questao(null, form.getDescricao(),  form.getDisciplina(), form.getUnidade(),
                form.getAssunto(), form.getNivel());

        questaoRepository.save(questao);

        List<Alternativa> alternativas = new ArrayList<>();

        //Monta as alternativas
        form.getAlternativas().forEach(elem->{

            Optional<Alternativa> alternativaExist = alternativaRepository.findByDescricao(elem.getDescricao());

            if(alternativaExist.isPresent()){
                alternativas.add(alternativaExist.get());
            }else{
                Alternativa novaAlternativa = new Alternativa(null, elem.getDescricao(), elem.getCorreta());
                novaAlternativa.setQuestao(questao);
                alternativaRepository.save(novaAlternativa);
                alternativas.add(novaAlternativa);
            }

        });

        questao.setAlternativas(alternativas);
        return ResponseEntity.ok(questao);
    }

}
