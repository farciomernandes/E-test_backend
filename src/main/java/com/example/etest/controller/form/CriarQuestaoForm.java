package com.example.etest.controller.form;

import java.util.ArrayList;
import java.util.List;

public class CriarQuestaoForm {

    private String descricao;

    private List<CriarAlternativaForm> alternativas = new ArrayList<>();

    private String disciplina;
    private String unidade;
    private String assunto;
    private Integer nivel;

    public CriarQuestaoForm(String descricao, List<CriarAlternativaForm> alternativas, String disciplina, String unidade, String assunto, Integer nivel) {

        this.descricao = descricao;
        alternativas.forEach(index->{
            this.alternativas.add(index);
        });
        this.disciplina = disciplina;
        this.unidade = unidade;
        this.assunto = assunto;
        this.nivel = nivel;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<CriarAlternativaForm> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<CriarAlternativaForm> alternativas) {
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
}
