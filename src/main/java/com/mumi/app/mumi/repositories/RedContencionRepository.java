package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.RedContencion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedContencionRepository extends JpaRepository<RedContencion, Integer> {

}
