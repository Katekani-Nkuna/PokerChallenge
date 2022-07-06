package com.sprinthive.pokerhands.handrank;

public abstract class HandRank<T extends HandRank> implements Comparable<HandRank> {

    private final HandStrength handStrength;

    protected HandRank(HandStrength handStrength) {
        this.handStrength = handStrength;
    }

    public int compareTo(HandRank other) {
        int i = handStrength.compareTo(other.handStrength);
        if (i == 0) {
            i = compareSameRank((T) other);
        }
        return i;
    }

    protected abstract int compareSameRank(T t);

    public abstract String describeHand();
}
