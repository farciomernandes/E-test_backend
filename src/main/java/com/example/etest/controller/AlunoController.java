package com.example.etest.controller;

import com.example.etest.controller.dto.AlunoDTO;
import com.example.etest.controller.dto.TurmaDTO;
import com.example.etest.controller.form.CriarAlunoForm;
import com.example.etest.model.Aluno;
import org.springframework.data.domain.Page;
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
    public ResponseEntity lista(){
        List<Aluno> alunos =  alunoRepository.findAll();
        List<AlunoDTO> alunosConvertidos = AlunoDTO.converterAll(alunos);
        return ResponseEntity.ok(alunosConvertidos);
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarUm(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return AlunoDTO.converter(aluno);
    }

    @PostMapping()
    public ResponseEntity adicionar(@RequestBody CriarAlunoForm form){
        Optional<Aluno> emailExiste = alunoRepository.findByEmail(form.getEmail());
        Optional<Aluno> matriculaExiste = alunoRepository.findByMatricula(form.getMatricula());

        if(emailExiste.isPresent()){
            return ResponseEntity.status(404).body("Email ou mátricula já cadastrado!");
        }else if(matriculaExiste.isPresent()){
            return ResponseEntity.status(404).body("Email ou mátricula já cadastrado!");
        }

        Aluno novoAluno = new Aluno(form.getNome(), form.getEmail(), form.getSenha(), form.getMatricula());
        alunoRepository.save(novoAluno);

        return ResponseEntity.ok(novoAluno);
    }

}
