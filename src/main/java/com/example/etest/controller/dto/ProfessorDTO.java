package com.example.etest.controller.dto;

import com.example.etest.model.Professor;

public class ProfessorDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String matricula;


    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.senha = professor.getSenha();
        this.matricula = professor.getMatricula();
    }

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

    public ProfessorDTO converter(Professor professor){
        return new ProfessorDTO(professor);
    }
}