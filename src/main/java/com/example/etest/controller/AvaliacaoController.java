package com.example.etest.controller;

import com.example.etest.controller.form.AdicionarAlunoForm;
import com.example.etest.controller.form.AdicionarQuestaoForm;
import com.example.etest.controller.form.CriarAvaliacaoForm;
import com.example.etest.model.*;
import com.example.etest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);

        return ResponseEntity.ok(avaliacao.get());
    }

    @PostMapping()
    public ResponseEntity criarAvaliacao(@RequestBody CriarAvaliacaoForm form) {
        Optional<Turma> turmaExist = turmaRepository.findByNome(form.getNomeTurma());
        if(turmaExist.isPresent()){
            Avaliacao avaliacao = new Avaliacao(null, form.getNome(), form.getDataProva(),
                    turmaExist.get());
            System.out.println("CRIOU ISSO: " + avaliacao);
            avaliacaoRepository.save(avaliacao);
            turmaExist.get().getAvaliacao().add(avaliacao);
            turmaRepository.save(turmaExist.get());
            return ResponseEntity.ok(avaliacao);
        }
        return ResponseEntity.status(404).body("Turma não encotrada!");
    }


    @Transactional
    @PostMapping("/adicionar/aluno")
    public ResponseEntity adicionarAluno(@RequestBody AdicionarAlunoForm form ) {
        Optional<Aluno> alunoExist = alunoRepository.findByMatricula(form.getMatricula());

        if(alunoExist.isPresent()){
            Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(form.getIdTurma());
            avaliacao.get().getAlunos().add(alunoExist.get());

            alunoExist.get().getAvaliacoes().add(avaliacao.get());
            return ResponseEntity.ok(alunoExist.get());
        }
        return ResponseEntity.status(404).body("Aluno nao encontrado!");
    }


    @Transactional
    @PostMapping("/adicionar/questao")
    public ResponseEntity adicionarQuestao(@RequestBody AdicionarQuestaoForm form ) {
        Optional<Questao> questaoExist = questaoRepository.findById(form.getIdQuestao());
        if(questaoExist.isPresent()){
            Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(form.getIdAvaliacao());

            avaliacao.get().getQuestoes().add(questaoExist.get());
            questaoExist.get().getAvaliacoes().add(avaliacao.get());

            avaliacaoRepository.save(avaliacao.get());
            questaoRepository.save(questaoExist.get());
            return ResponseEntity.ok(questaoExist.get());
        }
        return ResponseEntity.status(404).body("Questao nao encontrada!");
    }


}