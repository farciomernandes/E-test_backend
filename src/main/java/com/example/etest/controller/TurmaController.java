package com.example.etest.controller;

import com.example.etest.controller.dto.TurmaDTO;
import com.example.etest.controller.form.AdicionarAlunoForm;
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
    public ResponseEntity buscarTodos() {
        List<Turma> turmas = turmaRepository.findAll();
        List<TurmaDTO> turmasConvertidas = TurmaDTO.converterAll(turmas);
        return ResponseEntity.ok(turmasConvertidas);
    }

    @GetMapping("/{id}")
    public TurmaDTO buscarUm(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        Turma convertedTurma = turma.get();
        return TurmaDTO.converter(convertedTurma);
    }

    @PostMapping("/{turmaId}")
    @Transactional
    public ResponseEntity adicionarAluno(@RequestBody AdicionarAlunoForm form,
                                         @PathVariable Long turmaId) {
        System.out.println("ELE ENTROU AQUI");
        Optional<Aluno> alunoMatricula = alunoRepository.findByMatricula(form.getMatricula());
        if(alunoMatricula.isPresent()){
            Optional<Turma> turma = turmaRepository.findById(turmaId);
            List<Aluno> alunos = turma.get().getAlunos();
            alunos.add(alunoMatricula.get());

            System.out.println("ENCONTROU O ALUNO");

            List<Turma> turmas = alunoMatricula.get().getTurmas();
            turmas.add(turma.get());
            alunoMatricula.get().getTurmas().addAll(turmas);

            Turma covertedTurma = turma.get();
            turmaRepository.save(covertedTurma);
            return ResponseEntity.ok(TurmaDTO.converter(covertedTurma));
        }
        return ResponseEntity.status(404).body("O numero da matricula não corresponde a nenhum aluno cadastrado!");
    }

    @PostMapping()//O @Valid avisa ao Spring para fazer as validaçoes anotadas na classe TopicoForm
    @Transactional
    public ResponseEntity criarTurma(@RequestBody CriarTurmaForm form) {
        //@RequestBody = Pega os dados do corpo e não da url
        Optional<Turma> nomeTurmaExiste = turmaRepository.findByNome(form.getNome());
        if(nomeTurmaExiste.isPresent()){
            return ResponseEntity.status(404).body("Já existe uma turma com esse nome, tente novamente com outro nome!");
        }
        Optional<Professor> searchedProfessor = professorRepository.findById(form.getIdProfessor());

        if (searchedProfessor.isPresent()) {
            Professor professor = searchedProfessor.get();
            Turma newTurma = new Turma(null, form.getNome(), form.getAvisos());
            newTurma.setProfessor(professor);

            professor.getTurmas().add(newTurma);
            turmaRepository.save(newTurma);

            return ResponseEntity.ok(form);
        }

        return ResponseEntity.ok("Erro ao buscar professor");
    }
}