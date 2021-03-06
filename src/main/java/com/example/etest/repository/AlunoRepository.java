package com.example.etest.repository;

import com.example.etest.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
}
