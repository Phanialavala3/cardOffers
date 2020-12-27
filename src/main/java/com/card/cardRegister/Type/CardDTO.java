package com.card.cardRegister.Type;

import lombok.Data;

@Data
public class CardDTO {

    private String cardProvider;
    private String cardType;
    private String offerMonth;
    private String location;
    private String cardOffer;

}
