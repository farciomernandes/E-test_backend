package com.example.etest.controller.dto;

import com.example.etest.model.Usuario;

public class TokenProfessorDTO {

    private String token;
    private String tipo;
    private ProfessorDTO usuario;

    public TokenProfessorDTO(ProfessorDTO usuario, String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public ProfessorDTO getUsuario() {
        return usuario;
    }
}