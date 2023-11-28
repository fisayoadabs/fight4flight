package io.group02.fight4flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.group02.fight4flight.domain.Card;
public interface CardRepository extends JpaRepository<Card, Long>{
    Optional<Card> findByCardNumber(int cad);
}
