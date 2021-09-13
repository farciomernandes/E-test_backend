package com.example.etest.controller.form;


public class CriarComentario {

    private String texto;
    private Long idTurma;

    public CriarComentario(String texto, Long idTurma) {
        this.texto = texto;
        this.idTurma = idTurma;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
