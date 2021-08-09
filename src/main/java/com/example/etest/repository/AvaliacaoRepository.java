package com.example.etest.repository;

import com.example.etest.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    Avaliacao findByNome(String nome);
    Optional<Avaliacao> findAllByTurma(String turma);
}
