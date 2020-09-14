package com.mumi.app.mumi.controllers;

import java.util.List;

import com.mumi.app.mumi.entities.Categoria;
import com.mumi.app.mumi.models.request.AsignarPreguntaACategoriaRequest;
import com.mumi.app.mumi.models.request.CategoriaModifRequest;
import com.mumi.app.mumi.models.response.CategoriaResponse;
import com.mumi.app.mumi.models.response.GenericResponse;
import com.mumi.app.mumi.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
  @Autowired
  CategoriaService categoriaService;

  @PostMapping("/api/categorias")
  public ResponseEntity<GenericResponse> crearCategoria(@RequestBody Categoria categoria) {

    categoriaService.crearCategoria(categoria);

    GenericResponse r = new GenericResponse();
    r.isOk = true;
    r.message = "Categoria Creada con exito";
    r.id = categoria.getCategoriaId();

    return ResponseEntity.ok(r);

  }

  @GetMapping("/api/categorias")
  public ResponseEntity<List<Categoria>> obtenerTodasLasCategorias() {
    return ResponseEntity.ok(categoriaService.obtenerCategorias());
  }

  @PostMapping("/api/categoria/{id}/pregunta")
  public ResponseEntity<GenericResponse> asignarPregunta(@PathVariable Integer id,
      @RequestBody AsignarPreguntaACategoriaRequest a) {
    GenericResponse gR = new GenericResponse();
    if (categoriaService.asignarPregunta(id, a.preguntaId)) {

      gR.isOk = true;
      gR.message = "Pregunta asignada con éxito a la categoria de preguntas";
      return ResponseEntity.ok(gR);
    }
    gR.isOk = false;
    gR.message = "No pudo ser asignada";
    return ResponseEntity.badRequest().body(gR);

  }

  @GetMapping("/api/categorias/{id}")
  ResponseEntity<CategoriaResponse> buscarPorIdCategoria(@PathVariable Integer id) {
    Categoria categoria = categoriaService.buscarPorId(id);
    CategoriaResponse cGR = new CategoriaResponse();
    cGR.nombre = categoria.getNombre();
    return ResponseEntity.ok(cGR);
  }

  @PutMapping("/api/categorias/{id}")
  ResponseEntity<GenericResponse> actualizarCategoriaPorId(@PathVariable Integer id,
      @RequestBody CategoriaModifRequest cMR) {
    Categoria categoria = categoriaService.buscarPorId(id);
    if (categoria == null) {
      return ResponseEntity.notFound().build();
    }
    categoria.setNombre(cMR.nombre);
    Categoria categoriaActualizada = categoriaService.actualizarCategoria(categoria);

    GenericResponse r = new GenericResponse();
    r.isOk = true;
    r.message = "Categoria actualizada con éxito";
    r.id = categoriaActualizada.getCategoriaId();

    return ResponseEntity.ok(r);
  }

}
