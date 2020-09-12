package com.mumi.app.mumi.repositories;

import com.mumi.app.mumi.entities.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
