package com.example.etest.controller.dto;

import com.example.etest.model.*;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvaliacaoRetornoDTO {

    private Long id;
    private String nome;
    private Date dataProva;

    private String turma;

    private String autor;

    private List<String> alunos = new ArrayList<>();

    private List<Questao> questoes = new ArrayList<>();

    public AvaliacaoRetornoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.nome = avaliacao.getNome();
        this.dataProva = avaliacao.getDataProva();
        this.turma = avaliacao.getTurma().getNome();
        this.autor = avaliacao.getAutor().getUsername();
        avaliacao.getTurma().getAlunos().forEach(index->{
            this.alunos.add(index.getName());
        });
        this.questoes = avaliacao.getQuestoes();
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public static List<AvaliacaoRetornoDTO> converter(List<Avaliacao> avaliacoes) {
        List<AvaliacaoRetornoDTO> convertedList = new ArrayList<>();

        avaliacoes.forEach(indice->{
            convertedList.add(new AvaliacaoRetornoDTO(indice));
        });

        return convertedList;
    }
}
