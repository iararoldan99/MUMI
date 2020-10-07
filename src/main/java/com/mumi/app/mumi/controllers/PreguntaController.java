package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.models.request.PreguntaModifRequest;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.models.response.PreguntaResponse;
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

  @GetMapping("/api/preguntas/{id}")
  ResponseEntity<PreguntaResponse> buscarPreguntaPorId(@PathVariable Integer id) {
    Pregunta pregunta = preguntaService.obtenerPreguntaPorId(id);
    PreguntaResponse r = new PreguntaResponse();
    r.pregunta = pregunta.getPregunta();
    return ResponseEntity.ok(r);
  }

  @PutMapping("/api/preguntas/{id}")
  ResponseEntity<GenericResponse> actualizarPreguntaPorId(@PathVariable Integer id,
      @RequestBody PreguntaModifRequest pmR) {
    Pregunta pregunta = preguntaService.obtenerPreguntaPorId(id);
    if (pregunta == null) {
      return ResponseEntity.notFound().build();
    }
    pregunta.setPregunta(pmR.pregunta);
    Pregunta preguntaModificada = preguntaService.actualizarPregunta(pregunta);

    GenericResponse r = new GenericResponse();
    r.isOk = true;
    r.message = "Pregunta actualizada con éxito";
    r.id = preguntaModificada.getId();

    return ResponseEntity.ok(r);
  }

}
