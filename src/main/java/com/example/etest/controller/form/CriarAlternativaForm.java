package com.example.etest.controller.form;

public class CriarAlternativaForm {

    private String descricao;
    private Boolean correta = false;

    public CriarAlternativaForm(String descricao, Boolean correta) {
        this.descricao = descricao;
        this.correta = correta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }
}
