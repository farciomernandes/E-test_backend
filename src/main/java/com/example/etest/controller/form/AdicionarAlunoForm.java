package com.example.etest.controller.form;

import com.example.etest.model.Aluno;

public class AdicionarAlunoForm {

        private String nome;
        private String matricula;

    public AdicionarAlunoForm(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
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
