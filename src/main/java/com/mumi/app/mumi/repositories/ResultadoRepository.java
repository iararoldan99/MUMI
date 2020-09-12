package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.Resultado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {

}
