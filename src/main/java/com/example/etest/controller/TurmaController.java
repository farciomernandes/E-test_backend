package com.example.etest.controller;

import com.example.etest.controller.dto.AvaliacaoRetornoDTO;
import com.example.etest.controller.dto.TurmaRetornoDTO;
import com.example.etest.controller.form.AdicionarAlunoForm;
import com.example.etest.controller.form.CriarTurmaForm;
import com.example.etest.model.*;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.TurmaRepository;
import com.example.etest.repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProfessorRepository professorRepository;


    @GetMapping
    public ResponseEntity buscarTodos() {
        List<Turma> turmas = turmaRepository.findAll();
        List<TurmaRetornoDTO> convertedTurmas = new TurmaRetornoDTO().converter(turmas);

        return ResponseEntity.ok(convertedTurmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        TurmaRetornoDTO convertedTurma = new TurmaRetornoDTO(turma.get());
        return ResponseEntity.ok(convertedTurma);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity adicionarAluno(@RequestBody AdicionarAlunoForm form ) {

        Optional<Aluno> alunoExist = alunoRepository.findByMatricula(form.getMatricula());

        if(alunoExist.isPresent() && alunoExist.get().getPerfis().get(0).getNome().equals("ROLE_ALUNO")){
            Optional<Turma> turma = turmaRepository.findById(form.getIdTurma());
            turma.get().getAlunos().add(alunoExist.get());
            alunoExist.get().getTurmas().add(turma.get());
            return ResponseEntity.ok(new TurmaRetornoDTO(turma.get()));

        }
        return ResponseEntity.status(404).body("Aluno nao encontrado!");
    }

    @PostMapping()//O @Valid avisa ao Spring para fazer as validaçoes anotadas na classe TopicoForm
    public ResponseEntity criarTurma(@RequestBody CriarTurmaForm form) {
        //@RequestBody = Pega os dados do corpo e não da url
        Optional<Turma> nomeTurmaExiste = turmaRepository.findByNome(form.getNome());
        if(nomeTurmaExiste.isPresent()){
            return ResponseEntity.status(404).body("Já existe uma turma com esse nome, tente novamente com outro nome!");
        }

        Optional<Professor> searchedProfessor = professorRepository.findByMatricula(form.getMatricula());

        if (searchedProfessor.isPresent()) {
            Professor professor = searchedProfessor.get();

            Turma newTurma = new Turma(null, form.getNome());
            newTurma.setProfessor(professor);

            professor.getTurmas().add(newTurma);

            turmaRepository.save(newTurma);

            professorRepository.save(professor);

            return ResponseEntity.ok(new TurmaRetornoDTO(newTurma));
        }

        return ResponseEntity.ok("Erro ao buscar professor");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id){
        Optional<Turma> optional = turmaRepository.findById(id);
        if(optional.isPresent()){
            turmaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity buscarPorUsuario(@PathVariable Long id) {
        List<Turma> turmas =  turmaRepository.findAllById(Collections.singleton(id));
        System.out.println("VEIO AQUI ");
        return ResponseEntity.ok(new TurmaRetornoDTO().converter(turmas));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity removerAluno(@RequestBody AdicionarAlunoForm form){
        Optional<Turma> turma = turmaRepository.findById(form.getIdTurma());
            List<Aluno> alunos  = turma.get().getAlunos();
            List<Aluno> newAlunos = new ArrayList<>();
            Optional<Aluno> alunoExist = alunoRepository.findByMatricula(form.getMatricula());

            for(int i = 0; i < alunos.size(); i++){
                if(alunos.get(i).getMatricula() != form.getMatricula()){
                        newAlunos.add(alunos.get(i));
                }
            }
                turma.get().getAlunos().remove(alunoExist.get());

                turma.get().setAlunos(newAlunos);
                return ResponseEntity.ok(new TurmaRetornoDTO(turma.get()));

    }

}