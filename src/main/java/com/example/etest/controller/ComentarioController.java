package com.example.etest.controller;

import com.example.etest.controller.dto.AvaliacaoRetornoDTO;
import com.example.etest.controller.dto.TurmaRetornoDTO;
import com.example.etest.controller.form.*;
import com.example.etest.model.*;
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
    @DeleteMapping()
    @Transactional //Essa tag avisa que as alterações feitas na classe local devem ser feitas no banco de dados também
    public ResponseEntity remover(@RequestBody DeletarComentarioForm form){
        Optional<Comentario> optional = comentarioRepository.findById(form.getIdComentario());
        if(optional.isPresent()){
            Turma turma = optional.get().getTurma();
            if(turma.getId() == form.getIdTurma() && turma.getProfessor().getId() == form.getIdUsuario()){
                comentarioRepository.deleteById(form.getIdComentario());
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(404).body("Você não tem permissão para excluir este comentário!");
        }
        return ResponseEntity.status(404).body("Comentário não encontrado!");
    }

}