package com.example.etest.controller;

import com.example.etest.model.Turma;
import com.example.etest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmasController {
    @Autowired
    TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity buscarTodos(){
        List<Turma> turmas = turmaRepository.findAll();

        return ResponseEntity.ok(turmas);
    }
}
