package com.example.etest.repository;

import com.example.etest.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByNome(String nome);
}
