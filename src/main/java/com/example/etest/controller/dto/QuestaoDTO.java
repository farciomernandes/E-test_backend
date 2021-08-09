package com.example.etest.controller.dto;

import com.example.etest.model.Questao;
public class QuestaoDTO {

    private Long id;
    private String descricao;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    private String correta;
    private String disciplina;
    private String unidade;
    private String assunto;
    private Integer nivel;

    public QuestaoDTO(Questao questao) {
        this.id = questao.getId();
        this.descricao = questao.getDescricao();
        this.alternativa1 = questao.getAlternativa1();
        this.alternativa2 = questao.getAlternativa2();
        this.alternativa3 = questao.getAlternativa3();
        this.alternativa4 = questao.getAlternativa4();
        this.correta = questao.getCorreta();
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

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
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