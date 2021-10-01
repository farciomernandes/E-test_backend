package com.example.etest.controller.form;


public class CriarTurmaForm {

    private String nome;
    private String matricula;


    public CriarTurmaForm(String nome, String matricula ) {
        this.nome = nome;
        this.matricula = matricula;
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

}
