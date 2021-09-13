package com.example.etest.repository;

import com.example.etest.model.Aluno;
import com.example.etest.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
