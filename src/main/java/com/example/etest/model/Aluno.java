package com.example.etest.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Aluno extends Usuario {

    @ManyToMany(mappedBy = "alunos", cascade = CascadeType.MERGE)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "TURMA_ALUNO",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "turma_id"))
    private List<Turma> turmas;


    private String matricula;

    public Aluno(String nome, String email, String senha, String matricula) {
        super(nome, email, senha, matricula);
        this.matricula = matricula;
    }

    public Aluno() {
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
