package com.example.etest.controller.dto;

import com.example.etest.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String matricula;
    private List<UsuarioTurmaDTO> turmas = new ArrayList<>();

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getName();
        this.matricula = aluno.getMatricula();
        aluno.getTurmas().forEach(index->{
            this.turmas.add(new UsuarioTurmaDTO(index.getId(), index.getNome()));
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<UsuarioTurmaDTO> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<UsuarioTurmaDTO> turmas) {
        this.turmas = turmas;
    }

    public List<AlunoDTO> converter(List<Aluno> alunos) {
        List<AlunoDTO> convertedList = new ArrayList<>();

        alunos.forEach(indice->{
            convertedList.add(new AlunoDTO(indice));
        });

        return convertedList;
    }
}
