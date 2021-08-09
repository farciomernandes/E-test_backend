package com.example.etest.controller.dto;

import com.example.etest.controller.dto.IntegratedDTO.ProfessorTurmaDTO;
import com.example.etest.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String matricula;
    private List<ProfessorTurmaDTO> turmas = new ArrayList<>();;


    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.senha = professor.getSenha();
        this.matricula = professor.getMatricula();
        professor.getTurmas().forEach(index ->{
            this.turmas.add(ProfessorTurmaDTO.converter(index));
        });
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static ProfessorDTO converter(Professor professor){
        return new ProfessorDTO(professor);
    }

    public static List<ProfessorDTO> converterAll(List<Professor> professores){
        List<ProfessorDTO> professoresConvertidos = new ArrayList<>();;
        professores.forEach(professor->{
            professoresConvertidos.add(ProfessorDTO.converter(professor));
        });

        return professoresConvertidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProfessorTurmaDTO> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<ProfessorTurmaDTO> turmas) {
        this.turmas = turmas;
    }
}