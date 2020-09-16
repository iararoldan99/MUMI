package com.mumi.app.mumi.services;

import java.util.List;

import com.mumi.app.mumi.entities.Respuesta;
import com.mumi.app.mumi.repositories.RespuestaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    RespuestaRepository respuestaRepo;

    @Autowired
    PreguntaService preguntaService;

    public void crearRespuesta(Respuesta respuesta) {
        respuestaRepo.save(respuesta);
    }

    public List<Respuesta> listarRespuestas() {
        return (respuestaRepo.findAll());

    }
}
