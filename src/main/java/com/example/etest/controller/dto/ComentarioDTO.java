package com.example.etest.controller.dto;

import com.example.etest.model.Aluno;
import com.example.etest.model.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioDTO {

    private Long id;
    private String texto;

    public ComentarioDTO(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<ComentarioDTO> converter(List<Comentario> comentarios) {
        List<ComentarioDTO> convertedList = new ArrayList<>();

        comentarios.forEach(indice->{
            convertedList.add(new ComentarioDTO(indice.getId(), indice.getTexto()));
        });

        return convertedList;
    }
}
