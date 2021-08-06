package com.example.etest.controller.form;

import com.example.etest.model.Aluno;

public class CriarAlunoForm {

        private String nome;
        private String email;
        private String senha;
        private String matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Aluno converter() {
        Aluno aluno = new Aluno(getNome(), getEmail(), getSenha(), getMatricula());
        return aluno;
    }
}
