package com.example.etest.controller.dto;

import com.example.etest.model.Professor;
import com.example.etest.model.Turma;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfessorDTO {
    private String matricula;
    private String nome;
    private Long id;
    private Collection<? extends GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
    private List<TurmaRetornoDTO> turmas = new ArrayList<>();

    public ProfessorDTO(Professor professor) {
        this.matricula = professor.getMatricula();
        this.nome = professor.getName();
        this.id = professor.getId();
        this.roles = professor.getAuthorities();
        professor.getTurmas().forEach(index->{
            this.turmas.add(new TurmaRetornoDTO(index));
        });
    }

    public ProfessorDTO() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

    public List<TurmaRetornoDTO> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaRetornoDTO> turmas) {
        this.turmas = turmas;
    }

    public static List<ProfessorDTO> converter(List<Professor> professores) {
        List<ProfessorDTO> convertedList = new ArrayList<>();

        professores.forEach(indice->{
            convertedList.add(new ProfessorDTO(indice));
        });

        return convertedList;
    }
}
