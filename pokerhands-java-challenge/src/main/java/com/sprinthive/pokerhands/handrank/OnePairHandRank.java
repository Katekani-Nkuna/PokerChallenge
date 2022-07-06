package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.CardRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnePairHandRank extends HandRank<OnePairHandRank> {
    private final CardRank pair;
    private final List<CardRank> rest;

    public OnePairHandRank(CardRank pair, List<CardRank> rest) {
        super(HandStrength.ONE_PAIR);
        if (pair == null) {
            throw new IllegalArgumentException("Can't create a pair rank without a pair");
        }
        this.pair = pair;
        if (rest == null || rest.size() != 3) {
            throw new IllegalArgumentException("Can't create a pair rank without 3 kickers");
        }
        this.rest = new ArrayList<CardRank>(rest);
        Collections.sort(this.rest);
        Collections.reverse(this.rest);
    }

    protected int compareSameRank(OnePairHandRank otherHandRank) {
        int result = pair.compareTo(otherHandRank.pair);
        if (result != 0) {
            return result;
        }
        for (int i = 0; i < rest.size(); i++) {
            CardRank thisCard = rest.get(i);
            CardRank otherCard = otherHandRank.rest.get(i);
            result = thisCard.compareTo(otherCard);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    public String describeHand() {
        return "One pair of " + pair + "s";
    }
}
