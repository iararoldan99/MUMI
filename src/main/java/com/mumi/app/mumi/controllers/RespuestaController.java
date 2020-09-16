package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Respuesta;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.RespuestaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RespuestaController {
    
    @Autowired
    RespuestaService respuestaService;

    @PostMapping("/api/respuestas") // crear una respuesta a una pregunta por su id
    public ResponseEntity<GenericResponse> crearRespuesta(@RequestBody Respuesta respuesta) {
  
      respuestaService.crearRespuesta(respuesta);
  
      GenericResponse r = new GenericResponse();
      r.isOk = true;
      r.message = "Respuesta Creada con exito";
      r.id = respuesta.getId();
  
      return ResponseEntity.ok(r);
  
    }

    @GetMapping("/api/respuestas")
    public ResponseEntity<List<Respuesta>> listarRespuestas() {
        return ResponseEntity.ok(respuestaService.listarRespuestas());
    }

    

}
