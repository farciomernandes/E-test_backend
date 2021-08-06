package com.example.etest.controller;

import com.example.etest.controller.dto.AlunoDTO;
import com.example.etest.controller.dto.TurmaDTO;
import com.example.etest.controller.form.AdicionarAlunoForm;
import com.example.etest.controller.form.CriarAlunoForm;
import com.example.etest.controller.form.CriarTurmaForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
        List<TurmaDTO> turmasConvertidas = TurmaDTO.converterAll(turmas);
        return ResponseEntity.ok(turmasConvertidas);
    }

    @GetMapping("/{id}")
    public TurmaDTO buscarUm(@PathVariable Long id){
        Optional<Turma> turma = turmaRepository.findById(id);
        Turma convertedTurma = turma.get();

        return TurmaDTO.converter(convertedTurma);
    }

    @Transactional
    @PostMapping("/{turmaId}")
    public TurmaDTO adicionar(@RequestBody AdicionarAlunoForm alunoForm, @PathVariable Long turmaId){
        //@RequestBody = Pega os dados do corpo e não da url
        Aluno novoAluno = alunoRepository.findByNome(alunoForm.getNome());

        Optional<Turma> turma = turmaRepository.findById(turmaId);
        List<Aluno> alunos = turma.get().getAlunos();
        alunos.add(novoAluno);

        List<Turma> turmas = novoAluno.getTurmas();
        turmas.add(turma.get());
        novoAluno.getTurmas().addAll(turmas);

        Turma covertedTurma = turma.get();
        turmaRepository.save(covertedTurma);
        return TurmaDTO.converter(covertedTurma);
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
