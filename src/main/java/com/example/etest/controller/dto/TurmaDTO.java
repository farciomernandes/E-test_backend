package com.example.etest.controller.dto;

import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDTO {

    private Long id;
    private String nome;
    private String avisos;
    private Professor professor;
    private List<String> alunos = new ArrayList<>();

    public TurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.avisos = turma.getAvisos();
        this.professor = turma.getProfessor();
        turma.getAlunos().forEach(aluno ->{
            this.alunos.add(aluno.getNome());
        });
    }

    public static Page<TurmaDTO> converteAll(Page<Turma> turmas) {
        return turmas.map(TurmaDTO::new);
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    public static TurmaDTO converter(Turma turma){
        return new TurmaDTO(turma);
    }

    public static List<TurmaDTO> converterAll(List<Turma> turma){
        List<TurmaDTO> turmas = new ArrayList<>();;
        turma.forEach(indice->{
            turmas.add(TurmaDTO.converter(indice));
        });

        return turmas;
    }
}