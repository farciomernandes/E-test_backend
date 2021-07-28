package com.example.etest.controller;

import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity buscarTodos(){
        List<Professor> professores = professorRepository.findAll();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Professor> professor = professorRepository.findById(id);
        return ResponseEntity.ok(professor);
    }
}
