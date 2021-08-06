package com.example.etest.controller.dto;

import com.example.etest.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private String matricula;

    private List<String> turmas = new ArrayList<>();


    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.matricula = aluno.getMatricula();
        aluno.getTurmas().forEach(turma ->{
            this.turmas.add(turma.getNome());
        });
    }

    public static AlunoDTO converter(Optional<Aluno> aluno) {
        Aluno convertedAluno = aluno.get();
        return new AlunoDTO(convertedAluno);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<String> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<String> turmas) {
        this.turmas = turmas;
    }

    public static List<AlunoDTO> converterAll(List<Aluno> alunos){
        List<AlunoDTO> alunosFormatados = new ArrayList<>();;
        alunos.forEach(aluno->{
            alunosFormatados.add(AlunoDTO.converter(aluno));
        });

        return alunosFormatados;
    }

    private static AlunoDTO converter(Aluno aluno) {
        return new AlunoDTO(aluno);
    }
}