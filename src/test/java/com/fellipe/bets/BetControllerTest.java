package com.fellipe.bets;

import com.fellipe.bets.controller.BetController;
import com.fellipe.bets.model.dto.BetIn;
import com.fellipe.bets.model.dto.BetOut;
import com.fellipe.bets.service.BetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BetControllerTest {
    @InjectMocks
    private BetController betController;
    @Mock
    private BetService betService;
    private BetIn betIn;
    private BetOut betOut;

    @BeforeEach
    void setup() {
        betIn = new BetIn(1L);
        betOut = new BetOut("12345", "Paulo Felipe", "felipe27pffl@icloud.com");
    }

    @Test
    void shouldCreateBet() {
        when(betService.createBet(betIn)).thenReturn(betOut);

        var response = assertDoesNotThrow(() -> betController.createBet(betIn));

        assertNotNull(response);
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(betOut), response);
    }
}
