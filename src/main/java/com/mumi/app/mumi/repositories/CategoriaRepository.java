package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {
    
}
