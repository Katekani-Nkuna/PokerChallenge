package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.CardRank;

public class FourOfAKindHandRank extends HandRank<FourOfAKindHandRank> {
    private final CardRank cardRank;

    public FourOfAKindHandRank(CardRank cardRank) {
        super(HandStrength.FOUR_OF_AS_KIND);
        if (cardRank == null) {
            throw new IllegalArgumentException("cardRank may not be null for a four of a kind.");
        }
        this.cardRank = cardRank;
    }

    protected int compareSameRank(FourOfAKindHandRank otherHandRank) {
        return cardRank.compareTo(otherHandRank.cardRank);
    }

    public String describeHand() {
        return "4 of a kind of " + cardRank + "s";
    }
}
