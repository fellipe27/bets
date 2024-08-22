package com.fellipe.bets.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GamblerIn {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
}
