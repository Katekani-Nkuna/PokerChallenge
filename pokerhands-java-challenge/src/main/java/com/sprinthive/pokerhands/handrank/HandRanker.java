package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;

import java.util.List;

public interface HandRanker {

    HandRank findBestHandRank(List<Card> orderedCards);
}
