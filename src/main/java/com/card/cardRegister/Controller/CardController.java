package com.card.cardRegister.Controller;

import com.card.cardRegister.Entity.Card;
import com.card.cardRegister.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping("/")
    public String postOffer(@RequestBody Card card)
    {
        return service.addOffer(card);
    }

    @GetMapping("/{cardProvider}/{cardType}/{offerMonth}/{location}")
    public String getOffer(@PathVariable String cardProvider, @PathVariable String cardType, @PathVariable String offerMonth, @PathVariable String location)
    {
        return service.getOffer(cardProvider, cardType, offerMonth, location);
    }

    @GetMapping("/")
    public List<Card> findAllOffers()
    {
        return service.findAllCards();
    }
}
