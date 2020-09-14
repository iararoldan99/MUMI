package com.mumi.app.mumi.repositories;

import org.springframework.stereotype.Repository;

import com.mumi.app.mumi.entities.Opcion;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Integer> {

}
