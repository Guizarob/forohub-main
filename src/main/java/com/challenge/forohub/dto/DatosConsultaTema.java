package com.challenge.forohub.dto;

import java.time.LocalDateTime;

public record DatosConsultaTema(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_Creacion,
        boolean status,
        String autor,
        String curso
) {

}
