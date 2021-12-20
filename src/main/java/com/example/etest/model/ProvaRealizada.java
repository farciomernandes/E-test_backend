package com.example.etest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProvaRealizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nota;
    private Date dataEntrega;

    @OneToOne()
    private Aluno aluno;

    @OneToOne()
    private Avaliacao avaliacao;

    private List<Long> respostas = new ArrayList<>();

    public ProvaRealizada(Long id, Date dataEntrega, Aluno aluno, Avaliacao avaliacao, List<Long> respostas) {
        this.id = id;
        this.nota = 0;
        this.dataEntrega = dataEntrega;
        this.aluno = aluno;
        this.avaliacao = avaliacao;
        this.respostas = respostas;
    }

    public ProvaRealizada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public List<Long> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Long> respostas) {
        this.respostas = respostas;
    }

    public int somarNota(){
        int nota = 0;
        for(int k = 0; k <= this.avaliacao.getQuestoes().size();){
            if (this.avaliacao.getQuestoes().get(k).getAlternativas().get(Math.toIntExact(this.respostas.get(k))).getCorreta()){
                System.out.println("ACHOU UMA QUESTAO CERTA");
                switch (this.avaliacao.getQuestoes().get(k).getNivel()){
                    case 1:
                        nota = nota + 1;
                    case 2:
                        nota = nota + 2;
                    case 3:
                        nota = nota + 3;
                }
            }
        }
        setNota(nota);
        return nota;
    }
}
