package com.arepin.dao;

import com.arepin.entity.Card;

public class CardRepositoryInMemory implements CardRepository {
    private static final int DEFAULT_CARD_AMOUNT = 2;
    @Override
    public Card[] findAll() {
        int amount = 10;

        Card[] array = new Card[amount];
        for (int i = 0; i < array.length; i++) {
            Card card = new Card();
            card.setName("name " + i);
            card.setPrice(i);
            card.setAmount(DEFAULT_CARD_AMOUNT);
            array[i] = card;

        }
        return array;
    }
}
