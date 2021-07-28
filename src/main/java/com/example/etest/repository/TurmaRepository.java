package com.example.etest.repository;

import com.example.etest.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Turma findByNome(String nome);
}
