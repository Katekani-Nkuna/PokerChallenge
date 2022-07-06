package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;

import java.util.List;

public class HighCardHandRank extends HandRank<HighCardHandRank> {
    private final List<Card> cards;

    public HighCardHandRank(List<Card> cards) {
        super(HandStrength.HI_CARD);
        if (cards == null || cards.size() != 5) {
            throw new IllegalArgumentException("HighCardHandRank needs exactly 5 cards to make a high card ranked hand.");
        }
        this.cards = cards;
    }

    protected int compareSameRank(HighCardHandRank other) {
        for (int i = 0; i < cards.size(); i++) {
            Card thisCard = cards.get(i);
            Card otherCard = other.cards.get(i);
            int result = thisCard.compareTo(otherCard);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    public String describeHand() {
        return "High card " + cards.get(0);
    }
}
