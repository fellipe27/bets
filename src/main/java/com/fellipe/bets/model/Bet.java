package com.fellipe.bets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bet {
    @Id
    @NotBlank
    private String betNumber;
    @ManyToOne
    @JoinColumn(name = "gamblerId", nullable = false)
    private Gambler gambler;
}
