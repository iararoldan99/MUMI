package com.mumi.app.mumi.services;

import java.util.List;

import com.mumi.app.mumi.entities.Opcion;
import com.mumi.app.mumi.entities.Opcion.OpcionEnum;
import com.mumi.app.mumi.repositories.OpcionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService {

    @Autowired
    OpcionRepository opcionRepo;

    public boolean crearOpcion(Opcion opcion) {
        if (opcionRepo.existsById(opcion.getId()))
            return false;
        opcionRepo.save(opcion);
        return true;
    }

    public Opcion crearOpcion(OpcionEnum opcionEnum, String opcion) {
        Opcion o = new Opcion();
        o.setId(opcionEnum.getValue());
        o.setOpcion(opcion);
        
        boolean opcionCreada = crearOpcion(o);
        if (opcionCreada)
            return o;
        else
            return null;

    }

    
    public List<Opcion> obtenerOpciones() {
        return (opcionRepo.findAll());

    }

}
