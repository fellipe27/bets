package com.fellipe.bets.controller;

import com.fellipe.bets.model.dto.BetIn;
import com.fellipe.bets.model.dto.BetOut;
import com.fellipe.bets.model.dto.BetsOut;
import com.fellipe.bets.service.BetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BetController {
    private final BetService betService;

    @PostMapping("/bet")
    public ResponseEntity<BetOut> createBet(@Valid @RequestBody BetIn betIn) {
        BetOut betOut = betService.createBet(betIn);

        return ResponseEntity.status(HttpStatus.CREATED).body(betOut);
    }

    @GetMapping("/bets/{gamblerId}")
    public List<BetsOut> getBetsByGamblerId(@PathVariable Long gamblerId) {
        return betService.getBetsByGamblerId(gamblerId);
    }
}
