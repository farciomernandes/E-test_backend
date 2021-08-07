package com.example.etest.repository;

import com.example.etest.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    Optional<Questao> findByDescricao(String descricao);
    List<Questao> findAllByUnidade(String unidade);
    List<Questao> findAllByDisciplina(String disciplina);
    List<Questao> findAllByAssunto(String assunto);
}
