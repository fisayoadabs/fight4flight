package io.group02.fight4flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.repository.CardRepository;

@Service
public class CardService{
    @Autowired
    private CardRepository cardRepo;

    public Card addCard(Card cad) {
        return cardRepo.save(cad);
    }

    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    public Optional<Card> getCardByEmail(String email) {
        return null;
    }

    public void deductSeatCost(Long cardId, double seatCost) {
        Card card = cardRepo.findById(cardId).orElseThrow(
                () -> new RuntimeException("Card not found"));
            card.setBalance(card.getBalance() - seatCost);
            cardRepo.save(card);
    }
    
}