package com.fellipe.bets.service;

import com.fellipe.bets.model.Gambler;
import com.fellipe.bets.model.dto.GamblerIn;
import com.fellipe.bets.repository.GamblerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamblerService {
    private final GamblerRepository gamblerRepository;
    private final ModelMapper modelMapper;

    public void createGambler(GamblerIn gamblerIn) {
        Gambler gambler = modelMapper.map(gamblerIn, Gambler.class);
        gamblerRepository.save(gambler);
    }
}
