package com.example.etest.controller.form;


import java.util.Date;

public class CriarAvaliacaoForm {

    private String nome;
    private Date dataProva;
    private Long turmaId;

    public CriarAvaliacaoForm(String nome, Date dataProva, Long turmaId) {
        this.nome = nome;
        this.dataProva = dataProva;
        this.turmaId = turmaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}
