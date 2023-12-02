package io.group02.fight4flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepo;

    @Override
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }
    
}