package com.sprinthive.pokerhands;

public class Card implements Comparable<Card> {

    private final CardRank rank;
    private final Suit suit;

    public Card(CardRank rank, Suit suit) {
        if (rank == null) {
            throw new IllegalArgumentException("Rank of a Card may not be null");
        }
        if (suit == null) {
            throw new IllegalArgumentException("Suit of a Card may not be null");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card other) {
        if (this == other) return 0;
        return this.rank.getValue() - other.rank.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        return suit == card.suit;

    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        // if this method end up being used in more that testing and debugging then we should consider making this more efficiant.
        return rank + " of " + suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
