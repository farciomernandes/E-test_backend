package com.example.etest.controller.dto;

import com.example.etest.model.Avaliacao;
import com.example.etest.model.Questao;
import com.example.etest.model.Turma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AvaliacaoDTO {

    private Long id;
    private String nome;
    private Date dataProva;
    private Double nota;

    private TurmaDTO turma;

    private List<String> alunos = new ArrayList<>();
    private List<QuestaoDTO> questoes = new ArrayList<>();


    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.nome = avaliacao.getNome();
        this.dataProva = avaliacao.getDataProva();
        this.nota = avaliacao.getNota();
        this.turma = TurmaDTO.converter(avaliacao.getTurma());
        avaliacao.getAlunos().forEach(aluno ->{
            this.alunos.add(aluno.getNome());
        });
        avaliacao.getQuestoes().forEach(questao ->{
            QuestaoDTO addThis = QuestaoDTO.converter(questao);
            this.questoes.add(addThis);
        });
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public TurmaDTO getTurma() {
        return turma;
    }

    public void setTurma(TurmaDTO turma) {
        this.turma = turma;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    public static AvaliacaoDTO converter(Avaliacao avaliacao) {
        Avaliacao convertedAvaliacao = avaliacao;
        return new AvaliacaoDTO(convertedAvaliacao);
    }

    public static List<AvaliacaoDTO> converterAll(List<Avaliacao> avaliacao){
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();;
        avaliacao.forEach(indice->{
            avaliacoes.add(AvaliacaoDTO.converter(indice));
        });

        return avaliacoes;
    }

    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoDTO> questoes) {
        this.questoes = questoes;
    }
}