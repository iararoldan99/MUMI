package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.PreguntaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @PostMapping("/api/preguntas")
    public ResponseEntity<GenericResponse> crearPregunta(@RequestBody Pregunta pregunta){
        preguntaService.crearPregunta(pregunta);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Pregunta Creada con exito";
        r.id = pregunta.getId();

        // Aca vamos a usar Ok
        // Cuando se crea, generalmetnte para los puristas, se usa el
        // CreatedAtAction(201)
        return ResponseEntity.ok(r);

    }

    @GetMapping
    public ResponseEntity<List<Pregunta>> obtenerTodasLasPreguntas(){
        return ResponseEntity.ok(preguntaService.listarPreguntas());

    }
    
}
