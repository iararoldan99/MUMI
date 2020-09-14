package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Opcion;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.OpcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
