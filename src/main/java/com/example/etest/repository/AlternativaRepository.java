package com.example.etest.repository;

import com.example.etest.model.Alternativa;
import com.example.etest.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
    Optional<Alternativa> findByDescricao(String descricao);
}
