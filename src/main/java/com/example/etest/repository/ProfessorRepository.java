package com.example.etest.repository;

import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByNome(String nome);
    Optional<Professor> findByEmail(String email);
    Optional<Professor> findByMatricula(String matricula);
}
