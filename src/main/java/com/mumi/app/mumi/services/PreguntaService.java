package com.mumi.app.mumi.services;

import java.util.List;
import java.util.Optional;

import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository preguntaRepo;

    @Autowired
    CategoriaService categoriaService;

    public boolean crearPregunta(Pregunta pregunta) {
        if (preguntaRepo.existsById(pregunta.getId()))
            return false;
        preguntaRepo.save(pregunta);
        return true;
    }

    public Pregunta crearPregunta(String pregunta, Integer categoriaId) {
        Pregunta question = new Pregunta();
        question.setPregunta(pregunta);
        question.agregarCategoria(categoriaService.buscarPorId(categoriaId));

        boolean preguntaCreada = crearPregunta(question);
        if (preguntaCreada)
            return question;
        else
            return null;

    }

    public List<Pregunta> listarPreguntas() {
        return preguntaRepo.findAll();
    }

    public Pregunta obtenerPreguntaPorId(Integer id) {
        Optional<Pregunta> p = preguntaRepo.findById(id);

        if (p.isPresent())
            return p.get();
        return null;
    }

    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepo.save(pregunta);
    }

   

}
