package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.domain.Card;

public interface CardService {
    public Card addCard(Card cad);

    public List<Card> getAllCards();
}
