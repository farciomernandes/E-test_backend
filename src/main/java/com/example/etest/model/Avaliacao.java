package com.example.etest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataProva;

    @ManyToOne()
    private Turma turma;

    @ManyToOne()
    private Professor autor;

    @ManyToMany()
    @JoinTable(name = "aluno_avaliacao",
            joinColumns = @JoinColumn(name = "avaliacao_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos  = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "avaliacoes")
    private List<Questao> questoes = new ArrayList<>();

    public Avaliacao(){
    }

    public Avaliacao(Long id, String nome, Date dataProva, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.dataProva = dataProva;
        this.turma = turma;
        this.autor = turma.getProfessor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getAutor() {
        return autor;
    }

    public void setAutor(Professor autor) {
        this.autor = autor;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
