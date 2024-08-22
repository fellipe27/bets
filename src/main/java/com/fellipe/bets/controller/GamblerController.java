package com.fellipe.bets.controller;

import com.fellipe.bets.model.dto.GamblerIn;
import com.fellipe.bets.service.GamblerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequiredArgsConstructor
public class GamblerController {
    private final GamblerService gamblerService;

    @PostMapping("/gambler")
    public ResponseEntity<Void> createGambler(@Valid @RequestBody GamblerIn gamblerIn) {
        gamblerService.createGambler(gamblerIn);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
