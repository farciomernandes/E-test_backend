package com.example.etest.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Professor extends Usuario {

    @OneToMany(mappedBy = "autor", cascade = CascadeType.MERGE)
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public Professor(String nome, String email, String senha, String matricula) {
        super(nome, email, senha, matricula);
        this.turmas = turmas;
    }

    public Professor() {
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
