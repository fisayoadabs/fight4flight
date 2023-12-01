package io.group02.fight4flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group02.fight4flight.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{
    // List<Card> findByCardNumber(int cad); Why does this not work ask proffessor
}
