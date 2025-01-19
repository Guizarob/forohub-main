package com.challenge.forohub.controller;

import com.challenge.forohub.domain.tema.Tema;
import com.challenge.forohub.domain.tema.TemaRepository;
import com.challenge.forohub.dto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/temas")
public class TemasController {

    @Autowired
    private TemaRepository temaRepository;

    @PostMapping
    public ResponseEntity<DatosConsultaTema> registrarTemas(@RequestBody @Valid DatosRegistroTemas datosRegistroTemas,
                                                            UriComponentsBuilder uriComponentsBuilder) {
        Tema tema = temaRepository.save(new Tema(datosRegistroTemas));
        DatosConsultaTema datosConsultaTema = new DatosConsultaTema(
                tema.getId(),
                tema.getTitulo(),
                tema.getMensaje(),
                tema.getFecha_Creacion(),
                tema.getStatus(),
                tema.getAutor(),
                tema.getCurso().toString());
        URI url = uriComponentsBuilder.path("/temas/{id}").buildAndExpand(tema.getId()).toUri();
        return ResponseEntity.created(url).body(datosConsultaTema);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTemas>> ListadoTemas(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(temaRepository.findAll(paginacion).map(DatosListadoTemas::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizarTema(@PathVariable Long id,
                                            @RequestBody @Valid DatosActualizarTema datosActualizarTema) {
        Optional<Tema> optionalTema = temaRepository.findById(id);

        if (optionalTema.isPresent()) {
            Tema tema = optionalTema.get();
            tema.actualizarDatos(datosActualizarTema);
            temaRepository.save(tema);

            var datosTema = new DatosRespuestaTema(
                    tema.getTitulo(),
                    tema.getMensaje(),
                    tema.getAutor(),
                    tema.getCurso().toString()
            );
            return ResponseEntity.ok(datosTema);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El tema con el ID " + id + " no fue ubicado.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTemaPorId(@PathVariable Long id) {
        Optional<Tema> optionalTema = temaRepository.findById(id);

        if (optionalTema.isPresent()) {
            Tema tema = optionalTema.get();
            var datosTema = new DatosConsultaTema(
                    tema.getId(),
                    tema.getTitulo(),
                    tema.getMensaje(),
                    tema.getFecha_Creacion(),
                    tema.getStatus(),
                    tema.getAutor(),
                    tema.getCurso().toString()
            );
            return ResponseEntity.ok(datosTema);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El tema con el ID " + id + " no fue ubicado.");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTema(@PathVariable Long id) {
        Optional<Tema> optionalTema = temaRepository.findById(id);

        if (optionalTema.isPresent()) {
            Tema tema = optionalTema.get();
            tema.desactivarTema();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El tema con ID " + id + " no fue ubicado.");
        }
    }
}
