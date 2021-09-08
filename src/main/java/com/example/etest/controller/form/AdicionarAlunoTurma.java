package com.example.etest.controller.form;

public class AdicionarAlunoTurma {

    private String macricula;
    private Long turmaId;

    public AdicionarAlunoTurma(String macricula, Long turmaId) {
        this.macricula = macricula;
        this.turmaId = turmaId;
    }

    public AdicionarAlunoTurma() {
    }

    public String getMacricula() {
        return macricula;
    }

    public void setMacricula(String macricula) {
        this.macricula = macricula;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}
