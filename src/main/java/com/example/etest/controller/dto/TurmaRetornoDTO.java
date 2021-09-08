package com.example.etest.controller.dto;

import com.example.etest.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaRetornoDTO {

    private Long id;
    private String nome;
    private String avisos;
    private String nomeProfessor;
    private List<AlunoDTO> alunos = new ArrayList<>();


    public TurmaRetornoDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.avisos = turma.getAvisos();
        this.nomeProfessor = turma.getProfessor().getName();
        turma.getAlunos().forEach(index->{
            this.alunos.add(new AlunoDTO(index));
        });
    }

    public TurmaRetornoDTO() {
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

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }

    public List<TurmaRetornoDTO> converter(List<Turma> turmas) {
        List<TurmaRetornoDTO> convertedList = new ArrayList<>();

        turmas.forEach(indice->{
            convertedList.add(new TurmaRetornoDTO(indice));
        });

        return convertedList;
    }
}
