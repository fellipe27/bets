package com.fellipe.bets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BetOut {
    private String betNumber;
    private String gamblerName;
    private String gamblerEmail;
}
