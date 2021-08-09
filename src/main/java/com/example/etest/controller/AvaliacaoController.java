package com.example.etest.controller;

import com.example.etest.controller.dto.TurmaDTO;
import com.example.etest.controller.form.AdicionarAlunoForm;
import com.example.etest.controller.form.CriarAvaliacaoForm;
import com.example.etest.controller.form.CriarTurmaForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Avaliacao;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.AvaliacaoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.TurmaRepository;
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

    @GetMapping
    public ResponseEntity buscarTodos() {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        System.out.println("SACA SO: " + avaliacoes);
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


}