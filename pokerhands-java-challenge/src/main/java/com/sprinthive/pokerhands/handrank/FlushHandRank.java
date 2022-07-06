package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlushHandRank extends HandRank<FlushHandRank> {
    private final List<Card> cards;

    public FlushHandRank(List<Card> cards) {
        super(HandStrength.FLUSH);
        if (cards == null || cards.size() != 5) {
            throw new IllegalArgumentException("HighCardHandRank needs exactly 5 cards to make a high card ranked hand.");
        }
        this.cards = new ArrayList<Card>(cards);
        Collections.sort(this.cards);
        Collections.reverse(this.cards);
    }

    protected int compareSameRank(FlushHandRank other) {
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
        return "Flush, " + cards.get(0).getRank() + " high";
    }
}
