package com.example.etest.controller.dto.IntegratedDTO;

import com.example.etest.model.Turma;

public class ProfessorTurmaDTO {


    private String turma;
    private Long id;

    public ProfessorTurmaDTO(String turma, Long id) {
        this.turma = turma;
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static ProfessorTurmaDTO converter(Turma turma){
        System.out.println("CHEGOU AQUI");
        return new ProfessorTurmaDTO(turma.getNome(), turma.getId());
    }

}