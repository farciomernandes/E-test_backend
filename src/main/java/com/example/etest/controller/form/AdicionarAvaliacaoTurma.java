package com.example.etest.controller.form;

public class AdicionarAvaliacaoTurma {

    private Long idTurma;
    private Long idAvaliacao;

    public AdicionarAvaliacaoTurma(Long idTurma, Long idAvaliacao) {
        this.idTurma = idTurma;
        this.idAvaliacao = idAvaliacao;
    }

    public AdicionarAvaliacaoTurma() {
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }
}
