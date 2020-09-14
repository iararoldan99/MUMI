package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Opcion;
import com.mumi.app.mumi.models.request.OpcionModifRequest;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.models.response.OpcionResponse;
import com.mumi.app.mumi.services.OpcionService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpcionController {
    @Autowired
    OpcionService opcionService;

    @PostMapping("/api/opciones")
    public ResponseEntity<GenericResponse> crearOpcion(@RequestBody Opcion opcion) {

        opcionService.crearOpcion(opcion);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Opcion Creada con exito";
        r.id = opcion.getId();

        return ResponseEntity.ok(r);

    }

    @GetMapping("/api/opciones")
    public ResponseEntity<List<Opcion>> obtenerTodasLasOpciones() {
        return ResponseEntity.ok(opcionService.obtenerOpciones());
    }

    @GetMapping("/api/opciones/{id}")
    public ResponseEntity<OpcionResponse> obtenerOpcionPorId(@PathVariable Integer id){
        Opcion opcion = opcionService.buscarPorId(id);
        OpcionResponse oR = new OpcionResponse();
        oR.opcion = opcion.getOpcion();
        return ResponseEntity.ok(oR);
        
    }

    @PutMapping("/api/opciones/{id}")
  ResponseEntity<GenericResponse> actualizarOpcionPorId(@PathVariable Integer id,
      @RequestBody OpcionModifRequest omR) {
    Opcion opcion = opcionService.buscarPorId(id);
    if (opcion == null) {
      return ResponseEntity.notFound().build();
    }
    opcion.setOpcion(omR.opcion);
    Opcion opcionActualizada = opcionService.actualizarOpcion(opcion);

    GenericResponse r = new GenericResponse();
    r.isOk = true;
    r.message = "Opcion actualizada con éxito";
    r.id = opcionActualizada.getId();

    return ResponseEntity.ok(r);
  }
}
