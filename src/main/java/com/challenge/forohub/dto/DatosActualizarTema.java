package com.challenge.forohub.dto;

public record DatosActualizarTema(
        Long id,
        String titulo,
        String mensaje,
//        LocalDateTime fecha_Creacion,
//        Boolean status,
        String autor,
        String curso) {
}
