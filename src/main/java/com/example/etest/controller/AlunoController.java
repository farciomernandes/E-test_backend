package com.example.etest.controller;

import com.example.etest.controller.form.CriarAlunoForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Turma;
import com.example.etest.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

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


}
