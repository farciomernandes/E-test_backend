package com.example.etest.model;

import javax.persistence.*;

@Entity
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Boolean correta = false;

    @ManyToOne()
    @JoinColumn(name = "ID_QUESTAO")
    private Questao questao;

    public Alternativa(Long id, String descricao, Boolean correta) {
        this.id = id;
        this.descricao = descricao;
        this.correta = correta;
    }

    public Alternativa(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }
}
