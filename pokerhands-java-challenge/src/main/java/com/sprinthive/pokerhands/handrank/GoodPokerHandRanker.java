package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;
import com.sprinthive.pokerhands.CardRank;
import com.sprinthive.pokerhands.Suit;

import java.util.*;

public class GoodPokerHandRanker implements HandRanker{
    @Override
    public HandRank findBestHandRank(List<Card> cards) {

        if (cards.size() != 5) {
            return new NotRankableHandRanker(cards);
        }

        Collections.sort(cards);
        Collections.reverse(cards);

        CardRank cardRank = cards.get(0).getRank();
        Suit suit = cards.get(0).getSuit();

        //check for royal flush or straight flush
        if (isRoyalFlush(cards)) {

            //Check royal flush
            if (cards.get(0).getRank().equals(CardRank.ACE))
                return new RoyalFlushHandRank(suit);
            else //check straight flush
                return new StraightFlushHandRank(cardRank);
        }

        Map<CardRank, Integer> rankCount = getRankCount(cards);
        //now checking for four-of-a-kind
        if (isFourOfAKind(rankCount)){
            cardRank = cards.get(2).getRank(); //to cater for first four match or the last four match
            return new FourOfAKindHandRank(cardRank);
        }

        //Check for full house
        Map<String, CardRank> tripsAndPair = getFullHouse(rankCount);
        if (tripsAndPair != null){
            return new FullHouseHandRank(tripsAndPair.get("trips"), tripsAndPair.get("pair"));
        }

        //Check for flush
        if (isFlush(cards)){
            return new FlushHandRank(cards);
        }

        //check for straight
        if (isStraight(cards)){
            return new StraightHandRank(cardRank);
        }

        //check for ThreeOfAKind
        CardRank trips = getThreeOfAKind(rankCount);
        if (trips != null){
            return new ThreeOfAKindHandRank(trips);
        }

        //Check TwoPair
        Map<String, CardRank> pairs = getPairs(rankCount);
        if (pairs.size() == 3){
            return new TwoPairHandRank(pairs.get("pair1"), pairs.get("pair2"), pairs.get("kick1"));
        }
        else if (pairs.size() == 4){ //Check Single pair

            //place all three kickers on rest list
            List<CardRank> rest = new LinkedList<>();
            for (int i = 1; i <= 3; i++){
                rest.add(pairs.get("kick"+i));
            }

            return new OnePairHandRank(pairs.get("pair1"),rest);
        }

        //All above conditions failed, then we have a HighCard Hand Rank
        return new HighCardHandRank(cards);
    }

    boolean isRoyalFlush( List<Card> cards){
        for (int i = 0 ; i < 4; i++){

            //check if cards form a sequence (CardRank difference must equal 1)
            if (cards.get(i).getRank().compareTo(cards.get(i+1).getRank()) != 1) {
               return false;
            }

            //Check if suits are all the same
            if (cards.get(i).getSuit().compareTo(cards.get(i+1).getSuit()) != 0){
                return false;
            }
        }

        return true;
    }

    boolean isFourOfAKind(Map<CardRank, Integer> rankCount){

        for (CardRank rank : rankCount.keySet()){
            if (rankCount.get(rank).equals(4)){
                return true;
            }
        }
        return false;
    }

    //getFullHouse assumes preceding ranks have failed
    Map<String, CardRank> getFullHouse (Map<CardRank, Integer> rankCount){

        Map<String, CardRank> tripsAndPair = new LinkedHashMap<>();
        if (rankCount == null)
            return null;

        if (rankCount.size() == 2){

            for (CardRank rank : rankCount.keySet()){
                if (rankCount.get(rank).equals(3)){
                    tripsAndPair.put("trips",rank);
                }
                else {
                    tripsAndPair.put("pair",rank);
                }
            }
            return tripsAndPair;
        }

        return null;


    }

    boolean isFlush (List <Card> cards){
        for (int i = 0 ; i < 4; i++){

            //check if cards do not form a sequence
            if (cards.get(i).getRank().compareTo(cards.get(i+1).getRank()) == 0) {
                return false;
            }

            //Check if suits are all the same
            if (cards.get(i).getSuit().compareTo(cards.get(i+1).getSuit()) != 0){
                return false;
            }
        }

        return true;
    }

    boolean isStraight( List<Card> cards){
        for (int i = 0 ; i < 4; i++){

            //check if cards form a sequence
            if (cards.get(i).getRank().compareTo(cards.get(i+1).getRank()) != 1) {
                return false;
            }
        }

        return true;
    }

    CardRank getThreeOfAKind(Map<CardRank, Integer> rankCount){

        for (CardRank rank : rankCount.keySet()){
            if (rankCount.get(rank).equals(3)){
                return rank;
            }
        }
        return null;
    }

    Map<String, CardRank> getPairs(Map<CardRank, Integer> rankCount){

        List<CardRank> twoPair = new LinkedList<>();

        Map<String, CardRank> pairs = new LinkedHashMap<>();
        int i = 1, j = 1;

        for (CardRank rank : rankCount.keySet()){
            if (rankCount.get(rank).equals(2)){
                twoPair.add(rank);
                pairs.put("pair"+ i++, rank);
            }
            else {
                twoPair.add(0, rank);
                pairs.put("kick" + j++, rank);
            }
        }

        return pairs;
    }

    //Count number of occurrences of a rank on the list of cards
    Map<CardRank, Integer> getRankCount(List<Card> cards){

        //linked hash map preserves order of key insertion
        Map<CardRank, Integer> rankCount = new LinkedHashMap<>();

        for (Card card : cards){
            if (rankCount.containsKey(card.getRank())){
                rankCount.put(card.getRank(), rankCount.get(card.getRank()) +1);
            }
            else {
                rankCount.put(card.getRank(), 1);
            }
        }

        return rankCount;
    }
}
