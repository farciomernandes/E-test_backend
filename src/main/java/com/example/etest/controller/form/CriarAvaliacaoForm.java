package com.example.etest.controller.form;


import java.util.Date;

public class CriarAvaliacaoForm {

    private String nome;
    private Date dataProva;
    private String nomeTurma;

    public CriarAvaliacaoForm(String nome, Date dataProva, String nomeTurma) {
        this.nome = nome;
        this.dataProva = dataProva;
        this.nomeTurma = nomeTurma;
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

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
