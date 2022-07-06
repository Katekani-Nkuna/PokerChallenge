package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Suit;

public class RoyalFlushHandRank extends HandRank {

    private final Suit suit;

    public RoyalFlushHandRank(Suit suit) {
        super(HandStrength.ROYAL_FLUSH);
        if (suit == null) {
            throw new IllegalArgumentException("Suit may not be null for a royal flush");
        }
        this.suit = suit;
    }

    public String describeHand() {
        return "Royal flush of " + suit;
    }

    protected int compareSameRank(HandRank other) {
        return 0;
    }
}
