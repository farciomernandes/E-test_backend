package com.example.etest.controller.form;


public class CriarTurmaForm {

    private String nome;
    private String avisos;
    private String professor;

    public CriarTurmaForm() {

    }

    public CriarTurmaForm(String nome, String avisos, String professor) {
        this.nome = nome;
        this.avisos = avisos;
        this.professor = professor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }
}
