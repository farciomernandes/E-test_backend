package com.example.etest.controller;

import com.example.etest.controller.form.CriarAlunoForm;
import com.example.etest.controller.form.CriarTurmaForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity buscarTodos(){
        List<Turma> turmas = turmaRepository.findAll();

        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return ResponseEntity.ok(turma);
    }

    @PostMapping("/{turmaId}")//O @Valid avisa ao Spring para fazer as validaçoes anotadas na classe TopicoForm
    public ResponseEntity adicionar(@RequestBody CriarAlunoForm aluno, @PathVariable Long turmaId){
        //@RequestBody = Pega os dados do corpo e não da url

        Aluno novoAluno = alunoRepository.findByNome(aluno.getNome());

        Optional<Turma> turma = turmaRepository.findById(turmaId);
        List<Aluno> alunos = turma.get().getAlunos();
        alunos.add(novoAluno);

        List<Turma> turmas = novoAluno.getTurmas();
        turmas.add(turma.get());
        novoAluno.getTurmas().addAll(turmas);

        turmaRepository.save(turma.orElseThrow());

        return ResponseEntity.ok(turma);
    }

    @PostMapping("create")//O @Valid avisa ao Spring para fazer as validaçoes anotadas na classe TopicoForm
    public ResponseEntity criarTurma(@RequestBody CriarTurmaForm turma){
        //@RequestBody = Pega os dados do corpo e não da url

        Professor professor = professorRepository.findByNome(turma.getProfessor());
        Turma newTurma = new Turma(null, turma.getNome(), turma.getAvisos());
        newTurma.setProfessor(professor);

        professor.getTurmas().add(newTurma);
        turmaRepository.save(newTurma);

        return ResponseEntity.ok(turma);
    }

}
