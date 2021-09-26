package com.example.etest.model;

import javax.persistence.*;


@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @ManyToOne()
    @JoinColumn(name = "ID_TURMA")
    private Turma turma;

    public Comentario(Long id, String texto, Turma turma) {
        this.id = id;
        this.texto = texto;
        this.turma = turma;
    }
    public Comentario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
