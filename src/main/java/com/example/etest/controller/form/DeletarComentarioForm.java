package com.example.etest.controller.form;


public class DeletarComentarioForm {

    private Long idComentario;
    private Long idTurma;
    private Long idUsuario;


    public DeletarComentarioForm(Long idComentario, Long idTurma, Long idUsuario) {
        this.idComentario = idComentario;
        this.idTurma = idTurma;
        this.idUsuario = idUsuario;
    }

    public DeletarComentarioForm() {
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
