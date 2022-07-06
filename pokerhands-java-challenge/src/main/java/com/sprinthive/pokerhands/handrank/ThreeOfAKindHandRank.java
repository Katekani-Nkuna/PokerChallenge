package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.CardRank;

public class ThreeOfAKindHandRank extends HandRank<ThreeOfAKindHandRank> {
    private final CardRank cardRank;

    public ThreeOfAKindHandRank(CardRank cardRank) {
        super(HandStrength.THREE_OF_AS_KIND);
        if (cardRank == null) {
            throw new IllegalArgumentException("cardRank may not be null for a three of a kind hand");
        }
        this.cardRank = cardRank;
    }

    protected int compareSameRank(ThreeOfAKindHandRank otherHandRank) {
        return cardRank.compareTo(otherHandRank.cardRank);
    }

    public String describeHand() {
        return "3 of a kind of " + cardRank + "s";
    }
}
