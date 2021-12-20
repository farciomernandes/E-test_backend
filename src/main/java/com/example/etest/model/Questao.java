package com.example.etest.model;

import com.example.etest.controller.form.CriarAlternativaForm;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Questao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;


    @OneToMany(mappedBy = "questao")
    private List<Alternativa> alternativas = new ArrayList<>();


    private String disciplina;
    private String unidade;
    private String assunto;
    private Integer nivel;

    @JsonBackReference
    @ManyToMany()
    @JoinTable(name = "avaliacao_questao",
            joinColumns = @JoinColumn(name = "avaliacao_id"),
            inverseJoinColumns = @JoinColumn(name = "questao_id"))
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Questao(Long id, String descricao, List<CriarAlternativaForm> alternativas, String disciplina,
                   String unidade, String assunto,
                   Integer nivel) {
        this.id = id;
        this.descricao = descricao;
        alternativas.forEach(index->{
            this.alternativas.add(new Alternativa(null, index.getDescricao(), index.getCorreta()));
        });
        this.disciplina = disciplina;
        this.unidade = unidade;
        this.assunto = assunto;
        this.nivel = nivel;
    }

    public Questao(){}


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

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }




}
