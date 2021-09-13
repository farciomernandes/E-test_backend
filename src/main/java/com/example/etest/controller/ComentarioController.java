package com.example.etest.controller;

import com.example.etest.controller.dto.AvaliacaoRetornoDTO;
import com.example.etest.controller.dto.TurmaRetornoDTO;
import com.example.etest.controller.form.AdicionarQuestaoForm;
import com.example.etest.controller.form.CriarAvaliacaoForm;
import com.example.etest.controller.form.CriarComentario;
import com.example.etest.controller.form.RemoverQuestaoAvaliacaoForm;
import com.example.etest.model.Avaliacao;
import com.example.etest.model.Comentario;
import com.example.etest.model.Questao;
import com.example.etest.model.Turma;
import com.example.etest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping
    public ResponseEntity buscarTodos() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return ResponseEntity.ok(comentarios);
    }


    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Comentario> comentarios = comentarioRepository.findById(id);

        return ResponseEntity.ok(comentarios.get());
    }


    @PostMapping()
    @Transactional
    public ResponseEntity criarComentario(@RequestBody CriarComentario form) {
        Optional<Turma> turmaExist = turmaRepository.findById(form.getIdTurma());

            if(turmaExist.isPresent()){
                Comentario comentario = new Comentario(null, form.getTexto(), turmaExist.get());

                comentarioRepository.save(comentario);
                turmaExist.get().getComentario().add(comentario);
                turmaRepository.save(turmaExist.get());
                return ResponseEntity.ok(new TurmaRetornoDTO(turmaExist.get()));
            }

        return ResponseEntity.status(404).body("Turma não encotrada!");
    }


}