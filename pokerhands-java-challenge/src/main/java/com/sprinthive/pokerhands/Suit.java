package com.sprinthive.pokerhands;

public enum Suit {
    SPADES, HEARTS, CLUBS, DIAMONDS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
