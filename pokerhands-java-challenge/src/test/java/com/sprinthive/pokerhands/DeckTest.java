package com.sprinthive.pokerhands;

import com.sprinthive.pokerhands.exception.NotEnoughCardsInDeckException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckSize() {
        // Create a Deck of cards
        Deck deck = new Deck();
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "A deck must start with 52 cards");
    }

    @Test
    public void testDeckPick() {
        // Create a Deck of cards
        Deck deck = new Deck();
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "A deck must start with 52 cards");
        Card[] cards = deck.pick(1);
        //Ensure we get a card
        assertNotNull(cards, "A deck must return cards on first pick");
        assertEquals(1, cards.length, "Deck did not return only one card for pick(1)");
        assertNotNull(cards[0], "Deck did not return a valid card for pick(1)");
        //Ensure the deck contains 51 cards
        assertEquals(51, deck.getNumberOfCards(), "Was expecting 51 card in the deck after 1 pick");
    }

    @Test
    public void testDeckPickHand() {
        // Create a Deck of cards
        Deck deck = new Deck();
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "A deck must start with 52 cards");
        Card[] cards = deck.pick(5);
        //Ensure we get 5 cards
        assertNotNull(cards, "A deck must return cards on first pick");
        assertEquals(5, cards.length, "Deck did not return 5 cards for pick(5)");
        //Ensure the deck contains 47 cards
        assertEquals(47, deck.getNumberOfCards(), "Was expecting 47 card in the deck after a pick of 5");
    }

    @Test
    public void testDeckPickZero() {
        // Create a Deck of cards
        Deck deck = new Deck();
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "A deck must start with 52 cards");
        Card[] cards = deck.pick(0);
        //Ensure we get an empty array.
        assertNotNull(cards, "A deck must return cards on first pick");
        assertEquals(0, cards.length, "Deck did not return 0 cards for pick(0)");
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "Was expecting 52 card in the deck after a pick of 0");
    }

    @Test
    public void testDeckPick52() {
        // Create a Deck of cards
        Deck deck = new Deck();
        //Ensure the deck contains 52 cards
        assertEquals(52, deck.getNumberOfCards(), "A deck must start with 52 cards");
        Card[] cards = deck.pick(52);
        //Ensure we get an empty array.
        assertNotNull(cards, "A deck must return cards on first pick");
        assertEquals(52, cards.length, "Deck did not return 52 cards for pick(52)");
        //Ensure the deck contains 52 cards
        assertEquals(0, deck.getNumberOfCards(), "Was expecting 0 card in the deck after a pick of 52");
    }

    @Test
    public void testDeckPickLargeNumber() {
        // Create a Deck of cards
        Deck deck = new Deck();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> deck.pick(100),
                "Can not pick more than 52 cards from a deck");
    }
}
