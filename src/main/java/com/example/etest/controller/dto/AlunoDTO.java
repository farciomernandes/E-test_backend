package com.example.etest.controller.dto;

import com.example.etest.model.Aluno;
import com.example.etest.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String matricula;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getName();
        this.matricula = aluno.getMatricula();
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<AlunoDTO> converter(List<Aluno> alunos) {
        List<AlunoDTO> convertedList = new ArrayList<>();

        alunos.forEach(indice->{
            convertedList.add(new AlunoDTO(indice));
        });

        return convertedList;
    }
}
