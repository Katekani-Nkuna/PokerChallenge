package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.CardRank;

public class FullHouseHandRank extends HandRank<FullHouseHandRank> {
    private final CardRank trips;
    private final CardRank pair;

    public FullHouseHandRank(CardRank trips, CardRank pair) {
        super(HandStrength.FULL_HOUSE);
        if (trips == null) {
            throw new IllegalArgumentException("trips may not be null for a full house.");
        }
        if (pair == null) {
            throw new IllegalArgumentException("pair may not be null for a full house.");
        }
        this.trips = trips;
        this.pair = pair;
    }

    protected int compareSameRank(FullHouseHandRank otherHandRank) {
        int result = trips.compareTo(otherHandRank.trips);
        if (result != 0) {
            return result;
        }
        return pair.compareTo(otherHandRank.pair);
    }

    public String describeHand() {
        return "Full house, " + trips + "s over " + pair + "s";
    }
}
