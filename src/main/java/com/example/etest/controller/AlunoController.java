package com.example.etest.controller;

import com.example.etest.controller.form.CriarAlunoForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity buscarTodos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity buscarTurmas(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);

        List <Turma> turmas = aluno.get().getTurmas();
        System.out.println("SACA SO:  " + turmas.toString());
        return ResponseEntity.ok(turmas);
    }


    @PostMapping()
    public ResponseEntity adicionar(@RequestBody CriarAlunoForm aluno){
        Aluno novoAluno = new Aluno(aluno.getNome(), aluno.getEmail(), aluno.getSenha(), aluno.getMatricula());
        alunoRepository.save(novoAluno);

        return ResponseEntity.ok(novoAluno);
    }


}
