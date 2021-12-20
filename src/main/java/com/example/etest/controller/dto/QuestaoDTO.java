package com.example.etest.controller.dto;

import com.example.etest.model.Alternativa;
import com.example.etest.model.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestaoDTO {

    private Long id;
    private String descricao;
    private List<Alternativa> alternativas = new ArrayList<>();
    private String disciplina;
    private String unidade;
    private String assunto;
    private Integer nivel;

    public QuestaoDTO(Questao questao) {
        this.id = questao.getId();
        this.descricao = questao.getDescricao();
        questao.getAlternativas().forEach(index->{
            this.alternativas.add(index);
        });
        this.disciplina = questao.getDisciplina();
        this.unidade = questao.getUnidade();
        this.assunto = questao.getAssunto();
        this.nivel = questao.getNivel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public static QuestaoDTO converter(Questao questao) {
        return new QuestaoDTO(questao);
    }

}