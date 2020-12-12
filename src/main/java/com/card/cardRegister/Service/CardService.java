package com.card.cardRegister.Service;

import com.card.cardRegister.Entity.Card;
import com.card.cardRegister.Repository.CardRepo;
import com.card.cardRegister.Type.CardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepo repo;
    private CardDAO dao;


    //Add an offer for a card
    public String addOffer(Card card){
        System.out.println(card);
        repo.save(card);
       // dao.setResponse("Successfully Added an offer");
        return "Successfully Added an offer";
    }

    //Get an offer for a card depends on card and location
    public String getOffer(String cardProvider, String cardType, String offerMonth, String location){
        Card response = repo.findOfferByParams(cardProvider, cardType, offerMonth, location);
        System.out.println(response);
        return  response.getCardOffer();
    }

    public List<Card> findAllCards()
    {
        return repo.findAll();
    }
}
