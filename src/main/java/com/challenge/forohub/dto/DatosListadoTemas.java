package com.challenge.forohub.dto;

import com.challenge.forohub.domain.tema.Tema;

import java.time.LocalDateTime;

public record DatosListadoTemas(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_Creacion,
        Boolean status,
        String autor,
        String curso) {

    public DatosListadoTemas(Tema tema){
        this(tema.getId(), tema.getTitulo(), tema.getMensaje(), tema.getFecha_Creacion(), tema.getStatus(), tema.getAutor(), tema.getCurso());
    }
}
