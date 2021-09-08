package com.example.etest.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class Aluno extends Usuario {

    @ManyToMany(mappedBy = "alunos", cascade = CascadeType.MERGE)
    private List<Avaliacao> avaliacoes;

    @ManyToMany()
    @JoinTable(name="TURMA_ALUNO",
            joinColumns = @JoinColumn(name = "turma_aluno_pk"),
            inverseJoinColumns = @JoinColumn(name = "aluno_turma_pk")
    )
    private List<Turma> turmas;

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
}
