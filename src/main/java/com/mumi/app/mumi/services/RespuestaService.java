package com.mumi.app.mumi.services;

import java.util.List;

import com.mumi.app.mumi.entities.Opcion;
import com.mumi.app.mumi.entities.Pregunta;
import com.mumi.app.mumi.entities.Respuesta;
import com.mumi.app.mumi.entities.Opcion.OpcionEnum;
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

    public Respuesta crearRespuesta(Integer opcionElegidaId, String opcionElegida, Integer point) {
        Respuesta respuesta = new Respuesta();
        respuesta.setOpcionElegidaId(respuesta.getOpcionEnum().getValue());
        respuesta.setOpcionElegida(opcionElegida);
        respuesta.setPoint(point);

        respuestaRepo.save(respuesta);
        return respuesta;

    }

    public List<Respuesta> listarRespuestas() {
        return (respuestaRepo.findAll());

    }
}
