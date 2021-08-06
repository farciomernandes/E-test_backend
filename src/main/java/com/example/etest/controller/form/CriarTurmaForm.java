package com.example.etest.controller.form;


public class CriarTurmaForm {

    private String nome;
    private String avisos;
    private Long idProfessor;

    public CriarTurmaForm(String nome, String avisos, Long idProfessor) {
        this.nome = nome;
        this.avisos = avisos;
        this.idProfessor = idProfessor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setidProfessor(String professor) {
        this.idProfessor = idProfessor;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }
}
