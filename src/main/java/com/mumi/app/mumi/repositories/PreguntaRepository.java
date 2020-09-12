package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.Pregunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

}
