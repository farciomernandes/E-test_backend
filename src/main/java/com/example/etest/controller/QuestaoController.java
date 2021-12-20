package com.example.etest.controller;

import com.example.etest.controller.form.CriarQuestaoForm;
import com.example.etest.model.Alternativa;
import com.example.etest.model.Questao;
import com.example.etest.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
    @Autowired
    QuestaoRepository questaoRepository;

    @GetMapping
    public ResponseEntity lista(){
        List<Questao> questoes =  questaoRepository.findAll();
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Questao> questao = questaoRepository.findById(id);
        return ResponseEntity.ok(questao);
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

        Questao questao = new Questao(null, form.getDescricao(), form.getAlternativas(), form.getDisciplina(), form.getUnidade(),
                form.getAssunto(), form.getNivel());

        questaoRepository.save(questao);

        return ResponseEntity.ok(questao);
    }

}
