package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;

import java.util.List;

public class NotRankableHandRanker extends HandRank<NotRankableHandRanker> {

    int numberOfCards;

    public NotRankableHandRanker(List<Card> cards) {
        super(null);
        numberOfCards = cards == null ? 0 : cards.size();
    }

    @Override
    public int compareTo(HandRank other) {
        return 0;
    }

    public int compareSameRank(NotRankableHandRanker notRankableHandRanker) {
        return 0;
    }

    public String describeHand() {
        return "Can not rank a hand with " + numberOfCards + " card(s).";
    }
}
