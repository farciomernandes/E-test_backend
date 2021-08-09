package com.example.etest.controller;

import com.example.etest.controller.dto.ProfessorDTO;
import com.example.etest.controller.form.CriarProfessorForm;
import com.example.etest.controller.form.CriarTurmaForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.ProfessorRepository;
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
        return ResponseEntity.ok(ProfessorDTO.converterAll(professores));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Professor> professor = professorRepository.findById(id);
        return ResponseEntity.ok(ProfessorDTO.converter(professor.get()));
    }

    @PostMapping()//O @Valid avisa ao Spring para fazer as validaçoes anotadas na classe TopicoForm
    public ResponseEntity criarProfessor(@RequestBody CriarProfessorForm form){
        //@RequestBody = Pega os dados do corpo e não da url
        Optional<Professor> emailExiste = professorRepository.findByEmail(form.getEmail());
        Optional<Professor> matriculaExiste = professorRepository.findByMatricula(form.getMatricula());
        if(emailExiste.isPresent()){
            return ResponseEntity.status(404).body("Email ou mátricula já cadastrado!");
        }
        if(matriculaExiste.isPresent()){
            return ResponseEntity.status(404).body("Email ou mátricula já cadastrado!");
        }

        Professor professor = new Professor(form.getNome(), form.getEmail(), form.getSenha() , form.getMatricula());

        professorRepository.save(professor);
        return ResponseEntity.ok(ProfessorDTO.converter(professor));
    }
}
