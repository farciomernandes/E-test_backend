package com.example.etest.controller.dto;

import java.util.Date;

public class AvaliacaoTurmaDTO {
    private String nome;
    private Long id;
    private Date dataProva;

    public AvaliacaoTurmaDTO(String nome, Long id, Date dataProva) {
        this.nome = nome;
        this.id = id;
        this.dataProva = dataProva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }
}
