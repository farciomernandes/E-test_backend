package com.example.etest.controller.dto.IntegratedDTO;

import com.example.etest.model.Professor;

public class TurmaProfessorDTO {


    private String professor;
    private Long id;

    public TurmaProfessorDTO(String professor, Long id) {
        this.professor = professor;
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static TurmaProfessorDTO converter(Professor turma){
        return new TurmaProfessorDTO(turma.getNome(), turma.getId());
    }

}