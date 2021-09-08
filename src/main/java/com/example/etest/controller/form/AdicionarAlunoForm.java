package com.example.etest.controller.form;


public class AdicionarAlunoForm {

    private String matricula;
    private Long id;

    public AdicionarAlunoForm(String matricula, Long id) {
        this.matricula = matricula;
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
