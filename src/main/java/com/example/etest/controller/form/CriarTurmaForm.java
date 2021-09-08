package com.example.etest.controller.form;


public class CriarTurmaForm {

    private String nome;
    private String matricula;
    private String avisos;

    public CriarTurmaForm(String nome, String matricula, String avisos) {
        this.nome = nome;
        this.matricula = matricula;
        this.avisos = avisos;
    }

    public CriarTurmaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }
}
