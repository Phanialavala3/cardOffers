package com.card.cardRegister.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
    private String cardProvider;
    private String cardType;
    private String offerMonth;
    private String location;
    private String cardOffer;
    private String status;

}
