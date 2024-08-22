package com.fellipe.bets.service;

import com.fellipe.bets.model.Bet;
import com.fellipe.bets.model.Gambler;
import com.fellipe.bets.model.dto.BetIn;
import com.fellipe.bets.model.dto.BetOut;
import com.fellipe.bets.model.dto.BetsOut;
import com.fellipe.bets.repository.BetRepository;
import com.fellipe.bets.repository.GamblerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BetService {
    private final GamblerRepository gamblerRepository;
    private final BetRepository betRepository;

    public BetOut createBet(BetIn betIn) {
        BetOut betOut;

        try {
            Optional<Gambler> gambler = gamblerRepository.findById(betIn.getGamblerId());
            String betNumber = UUID.randomUUID().toString();
            Bet bet = new Bet(betNumber, gambler.get());

            betRepository.save(bet);
            betOut = new BetOut(betNumber, gambler.get().getName(), gambler.get().getEmail());
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return betOut;
    }

    public List<BetsOut> getBetsByGamblerId(Long gamblerId) {
        List<Bet> betsList = betRepository.findByGamblerId(gamblerId);
        List<BetsOut> betsOutList = new ArrayList<>();

        betsList.forEach(bet -> {
            BetsOut betsOut = new BetsOut();

            betsOut.setGamblerId(bet.getGambler().getId());
            betsOut.setBetNumber(bet.getBetNumber());

            betsOutList.add(betsOut);
        });

        return betsOutList;
    }
}
