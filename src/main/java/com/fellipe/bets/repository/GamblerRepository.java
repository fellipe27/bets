package com.fellipe.bets.repository;

import com.fellipe.bets.model.Gambler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamblerRepository extends JpaRepository<Gambler, Long> {}
