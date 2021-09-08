package com.example.etest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String avisos;

    @ManyToOne()
    private Usuario professor;

    @ManyToMany()
    @JoinTable(name="TURMA_ALUNO",
            joinColumns = @JoinColumn(name = "turma_aluno_pk"),
            inverseJoinColumns = @JoinColumn(name = "aluno_turma_pk")
    )
    private List<Usuario> alunos = new ArrayList<>();

    @JsonBackReference
    @OneToMany()
    private List<Avaliacao> avaliacao = new ArrayList<>();

    public Turma() {
    }

    public Turma(Long id, String nome, String avisos) {
        this.nome = nome;
        this.avisos = avisos;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return id.equals(turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public List<Usuario> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Usuario> alunos) {
        this.alunos = alunos;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", avisos='" + avisos + '\'' +
                ", professor=" + professor +
                ", alunos=" + alunos +
                ", avaliacao=" + avaliacao +
                '}';
    }

}
