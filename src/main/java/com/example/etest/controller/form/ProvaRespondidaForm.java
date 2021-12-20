package com.example.etest.controller.form;


import com.example.etest.model.Avaliacao;
import com.example.etest.model.Resposta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProvaRespondidaForm {

    private Long idAluno;
    private List<Resposta> respostas = new ArrayList<>();
    private Date dataEnvio;
    private Avaliacao avaliacao;

    public ProvaRespondidaForm(Long idAluno, List<Resposta> respostas, Date dataEnvio, Avaliacao avaliacao) {
        this.idAluno = idAluno;
        this.respostas = respostas;
        this.dataEnvio = dataEnvio;
        this.avaliacao = avaliacao;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}
