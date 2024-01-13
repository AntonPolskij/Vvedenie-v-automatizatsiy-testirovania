package org.max.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.seminar.exception.DeckEmptyException;
import org.max.seminar.type.Ranks;

import java.util.ArrayList;
import java.util.Collections;

import static org.max.seminar.type.Ranks.TWO;
import static org.max.seminar.type.Suits.CLUBS;

public class OurDeckTest {
    Card checkCard;
    Deck deck;
    @BeforeEach
    void getNewDeck() {
        checkCard = new Card(TWO, CLUBS);
        ArrayList<Card> list = new ArrayList<>();
        list.add(checkCard);
        deck = new Deck(list);
    }


    @Test
    public void testGetCardEmptyDeck() throws DeckEmptyException {
        //Given
        deck = new Deck(new ArrayList<Card>());
        //When
        Assertions.assertThrows(DeckEmptyException.class, deck::getCard);
    }
    @Test
    public void testGetCardGiveFirstCard() throws DeckEmptyException {
        //Given
        int size = deck.getCards().size();
        //Then
        Card firstCard = deck.getCards().get(0);
        //When
        Card result = deck.getCard();

        Assertions.assertEquals(firstCard, result);

        Assertions.assertEquals(size-1, deck.getCards().size());
    }

    @Test
    public void testGetCardWithOneCard() throws DeckEmptyException {
        //Given
        //Then
        Card result = deck.getCard();
        //When
        Assertions.assertEquals(checkCard,result);
        Assertions.assertEquals(0, deck.getCards().size());
    }
}
