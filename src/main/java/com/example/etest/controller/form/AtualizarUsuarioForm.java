package com.example.etest.controller.form;


public class AtualizarUsuarioForm {

 private String nome;
 private String senha;

    public AtualizarUsuarioForm(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public AtualizarUsuarioForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
