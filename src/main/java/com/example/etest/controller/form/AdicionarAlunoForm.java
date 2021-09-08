package com.example.etest.controller.form;


public class AdicionarAlunoForm {

    private String matricula;
    private Long idTurma;

    public AdicionarAlunoForm(String matricula, Long idTurma) {
        this.matricula = matricula;
        this.idTurma = idTurma;
    }

    public AdicionarAlunoForm() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
