package com.example.etest.controller;

import com.example.etest.controller.dto.AvaliacaoRetornoDTO;
import com.example.etest.controller.form.*;
import com.example.etest.model.*;
import com.example.etest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity buscarTodos() {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        return ResponseEntity.ok(AvaliacaoRetornoDTO.converter(avaliacoes));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);

        return ResponseEntity.ok(new AvaliacaoRetornoDTO(avaliacao.get()));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity criarAvaliacao(@RequestBody CriarAvaliacaoForm form) {
        Optional<Turma> turmaExist = turmaRepository.findById(form.getTurmaId());

        if(turmaExist.isPresent()){
            Avaliacao avaliacao = new Avaliacao(null, form.getNome(), form.getDataProva(),
                    turmaExist.get());

            avaliacaoRepository.save(avaliacao);
            turmaExist.get().getAvaliacao().add(avaliacao);
            turmaRepository.save(turmaExist.get());
            return ResponseEntity.ok(new AvaliacaoRetornoDTO(avaliacao));
        }
        return ResponseEntity.status(404).body("Turma não encotrada!");
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity adicionarQuestao(@RequestBody AdicionarQuestaoForm form ) {
        Optional<Questao> questaoExist = questaoRepository.findById(form.getIdQuestao());
        if(questaoExist.isPresent()){
            Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(form.getIdAvaliacao());

            if(avaliacao.get().getQuestoes().contains(questaoExist.get())){
                return ResponseEntity.status(404).body("Questao já incluida na avaliacao!");
            }

            avaliacao.get().getQuestoes().add(questaoExist.get());
            questaoExist.get().getAvaliacoes().add(avaliacao.get());

            avaliacaoRepository.save(avaliacao.get());
            questaoRepository.save(questaoExist.get());
            return ResponseEntity.ok(questaoExist.get());
        }
        return ResponseEntity.status(404).body("Questao nao encontrada!");
    }

    @Transactional
    @DeleteMapping("/remover/questao")
    public ResponseEntity removerQuestao(@RequestBody RemoverQuestaoAvaliacaoForm form ) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(form.getIdAvaliacao());

        if(avaliacao.isPresent()){
            List<Questao> questoes  = avaliacao.get().getQuestoes();

            Optional<Questao> questaoExist = questaoRepository.findById(form.getIdQuestao());

            if(questaoExist.isPresent() && questoes.contains(questaoExist.get())){
                List<Questao> newQuestoes = new ArrayList<>();

                for(int i = 0; i < questoes.size(); i++){
                    if(questoes.get(i).getId() != form.getIdQuestao()){
                        newQuestoes.add(questoes.get(i));
                    }
                }

                avaliacao.get().getQuestoes().remove(questaoExist.get());

                avaliacaoRepository.deleteById(avaliacao.get().getId());

                return ResponseEntity.ok(new AvaliacaoRetornoDTO(avaliacao.get()));
            }else{
                return ResponseEntity.status(404).body("Questao nao encontrada!");
            }
        }
        return ResponseEntity.status(404).body("Avaliacao nao encontrada!");
    }

    @Transactional
    @PostMapping("/responder/{id}")
    public ResponseEntity responderProva(@RequestBody ProvaRespondidaForm form, @PathVariable Long id){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        Optional<Aluno> aluno = alunoRepository.findById(form.getIdAluno());

        if(avaliacao.isEmpty() || aluno.isEmpty()){
            return ResponseEntity.status(404).body("Erro ao identificar prova ou aluno!");
        }

        ProvaRealizada provaRealizada = new ProvaRealizada(null, form.getDataEnvio(), aluno.get(), avaliacao.get(), form.getRespostas());
        return ResponseEntity.ok(provaRealizada);
    }



}