package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.Respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

}
