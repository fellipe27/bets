package com.fellipe.bets.repository;

import com.fellipe.bets.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, String> {
    @Query(value = "SELECT * FROM bet WHERE gambler_Id = ?", nativeQuery = true)
    List<Bet> findByGamblerId(@Param("gamblerId") Long gamblerId);
}
