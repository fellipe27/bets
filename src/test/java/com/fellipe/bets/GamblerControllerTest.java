package com.fellipe.bets;

import com.fellipe.bets.controller.GamblerController;
import com.fellipe.bets.model.dto.GamblerIn;
import com.fellipe.bets.service.GamblerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GamblerControllerTest {
    @InjectMocks
    private GamblerController gamblerController;
    @Mock
    private GamblerService gamblerService;
    private GamblerIn gamblerIn;

    @BeforeEach
    void setup() {
        gamblerIn = new GamblerIn("Paulo Felipe", "felipe27pffl@icloud.com");
    }

    @Test
    void shouldCreateGambler() {
        var response = assertDoesNotThrow(() -> gamblerController.createGambler(gamblerIn));

        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), response);
    }
}
