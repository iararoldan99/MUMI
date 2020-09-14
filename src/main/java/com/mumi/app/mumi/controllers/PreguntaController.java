package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.PreguntaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @PostMapping("/api/preguntas")
    public ResponseEntity<GenericResponse> crearPregunta(@RequestBody Pregunta pregunta) {
        preguntaService.crearPregunta(pregunta);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Pregunta Creada con exito";
        r.id = pregunta.getId();
        return ResponseEntity.ok(r);

    }

    @GetMapping("/api/preguntas")
    public ResponseEntity<List<Pregunta>> listarPreguntas() {
        return ResponseEntity.ok(preguntaService.listarPreguntas());
    }

}
