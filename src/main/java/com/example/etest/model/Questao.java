package com.example.etest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Questao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String disciplina;
    private String unidade;
    private String assunto;
    private Integer nivel;

    public Questao() {
    }

    public Questao( String descricao, String disciplina, String unidade, String assunto, Integer nivel) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.assunto = assunto;
        this.nivel = nivel;
        this.disciplina = disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public String getDisciplina(){
        return this.disciplina;
    }


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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questao questao = (Questao) o;
        return id.equals(questao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
