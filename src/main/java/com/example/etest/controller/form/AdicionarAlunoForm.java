package com.example.etest.controller.form;

import com.example.etest.model.Aluno;

public class AdicionarAlunoForm {

        private String matricula;

    public AdicionarAlunoForm(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
