package com.mumi.app.mumi.controllers;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.entities.Pregunta.TipoPreguntaEnum;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.PreguntaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api/preguntas/{id}")
    public ResponseEntity<TipoPreguntaEnum> obtenerTodasLasPreguntas(@PathVariable Integer id) {
        return ResponseEntity.ok(preguntaService.obtenerPreguntaSegunTipoDeViolencia(id));

    }

    
}
