package com.sprinthive.pokerhands;

import com.sprinthive.pokerhands.handrank.BadPokerHandRanker;
import com.sprinthive.pokerhands.handrank.GoodPokerHandRanker;
import com.sprinthive.pokerhands.handrank.HandRank;
import com.sprinthive.pokerhands.handrank.HandRanker;

import java.util.List;

public class Hand implements Comparable<Hand> {

    // This should be injected with an IOC container, but let's keep it simple.
    // Just replace BadPokerHandRanker with your own implementation
    private static HandRanker handRanker = new GoodPokerHandRanker();
    private HandRank handRank;

    public Hand(List<Card> cards) {
        handRank = handRanker.findBestHandRank(cards);
    }

    public String describeHandRank() {
        return handRank.describeHand();
    }

    public int compareTo(Hand other) {
        return handRank.compareTo(other.handRank);
    }
}

