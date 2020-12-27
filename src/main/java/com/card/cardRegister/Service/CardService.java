package com.card.cardRegister.Service;

import com.card.cardRegister.Entity.Card;
import com.card.cardRegister.Repository.CardRepo;
import com.card.cardRegister.Type.CardDAO;
import com.card.cardRegister.Type.CardDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {


    private CardRepo repo;
    private ModelMapper modelMapper;
    private CardDAO dao;
    private CardDTO dto;

    @Autowired
    public CardService(CardRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.dao = new CardDAO();
        this.dto = new CardDTO();
    }

    //Add an offer for a card
    public CardDAO addOffer(CardDTO dto){
        Card card = modelMapper.map(dto, Card.class);
        repo.save(card);

        Optional<Card> getCard = repo.findById(card.getCardId());
        Card newOffer = getCard.get();
        if (getCard.isPresent())
        {
            dao.setId(newOffer.getCardId());
            dao.setStatus("Card offer Successfully added");
        }
        return  dao;
    }

    //Get an offer for a card depends on card and location
    public Card getOffer(String cardProvider, String cardType, String offerMonth, String location){
        Card response = repo.findOfferByParams(cardProvider, cardType, offerMonth, location);
        System.out.println(response);
        return  response;
    }

    public List<Card> findAllCards()
    {
        return repo.findAll();
    }

    public Optional<Card> findCardByID(Long Id)
    {
        return repo.findById(Id);
    }
}
