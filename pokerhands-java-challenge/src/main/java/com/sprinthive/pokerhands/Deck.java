package com.sprinthive.pokerhands;

import com.sprinthive.pokerhands.exception.NotEnoughCardsInDeckException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> cards = new ArrayList<Card>(52);

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public synchronized int getNumberOfCards() {
        return cards.size();
    }

    public synchronized Card[] pick(int numberOfCards) throws NotEnoughCardsInDeckException {
        if(numberOfCards > 52){
            throw new IllegalArgumentException("Number of cards to pick from a deck must be 52 or less.");
        }
        else if(numberOfCards < 0){
            throw new IllegalArgumentException("Number of cards to pick from a deck must be 0 or more.");
        }
        //Todo: This method still needs to be implemented

        Card [] hand = new Card[numberOfCards];

        //Shuffling the deck
        Random random = new Random();

        //Draw card
        for (int i = 0; i < numberOfCards; i++){
            int drawCard = random.nextInt(cards.size());
            hand[i] = cards.remove(drawCard);
        }

        return hand;
    }
}
