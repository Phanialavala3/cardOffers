package com.card.cardRegister.Controller;

import com.card.cardRegister.Entity.Card;
import com.card.cardRegister.Service.CardService;
import com.card.cardRegister.Type.CardDAO;
import com.card.cardRegister.Type.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping("/")
    public CardDAO postOffer(@RequestBody CardDTO dto)
    {
        return service.addOffer(dto);
    }

    @GetMapping("/{cardProvider}/{cardType}/{offerMonth}/{location}")
    public Card getOffer(@PathVariable String cardProvider, @PathVariable String cardType, @PathVariable String offerMonth, @PathVariable String location)
    {
        return service.getOffer(cardProvider, cardType, offerMonth, location);
    }

    @GetMapping("/")
    public List<Card> findAllOffers()
    {
        return service.findAllCards();
    }

    @GetMapping("/{Id}")
    public Optional<Card> findOfferByID(@PathVariable Long Id)
    {
        return service.findCardByID(Id);
    }
}
