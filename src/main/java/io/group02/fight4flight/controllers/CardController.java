package io.group02.fight4flight.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.service.CardService;

@RestController
@RequestMapping("/card")
@CrossOrigin
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/getAll")
    public List<Card> list() {
        return cardService.getAllCards();
    }
}
