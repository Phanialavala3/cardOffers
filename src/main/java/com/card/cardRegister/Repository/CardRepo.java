package com.card.cardRegister.Repository;

import com.card.cardRegister.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card,Long> {
    @Query("SELECT c FROM Card c WHERE c.cardProvider = :cardProvider and c.cardType = :cardType and c.offerMonth = :offerMonth and c.location = :location")
    Card findOfferByParams(String cardProvider, String cardType, String offerMonth, String location);
}
