package com.example.etest.controller.dto;

import com.example.etest.model.Usuario;

public class TokenAlunoDTO {

    private String token;
    private String tipo;
    private AlunoDTO usuario;

    public TokenAlunoDTO(AlunoDTO usuario, String token, String tipo) {
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

    public AlunoDTO getUsuario() {
        return usuario;
    }
}