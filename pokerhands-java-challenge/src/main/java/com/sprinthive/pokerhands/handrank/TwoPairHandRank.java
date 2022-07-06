package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.CardRank;

public class TwoPairHandRank extends HandRank<TwoPairHandRank> {
    private final CardRank highPair;
    private final CardRank lowPair;
    private final CardRank kicker;

    public TwoPairHandRank(CardRank highPair, CardRank lowPair, CardRank kicker) {
        super(HandStrength.TWO_PAIR);
        if (highPair == null) {
            throw new IllegalArgumentException("highPair may not be null for a two pair");
        }
        if (lowPair == null) {
            throw new IllegalArgumentException("lowPair may not be null for a two pair");
        }
        if (kicker == null) {
            throw new IllegalArgumentException("kicker may not be null for a two pair");
        }
        this.highPair = highPair;
        this.lowPair = lowPair;
        this.kicker = kicker;
    }

    protected int compareSameRank(TwoPairHandRank otherHandRank) {
        int result = highPair.compareTo(otherHandRank.highPair);
        if (result != 0) {
            return result;
        }
        result = lowPair.compareTo(otherHandRank.lowPair);
        if (result != 0) {
            return result;
        }
        return kicker.compareTo(otherHandRank.kicker);
    }

    public String describeHand() {
        return "Two pair, " + highPair + "s and " + lowPair + "s";
    }
}
