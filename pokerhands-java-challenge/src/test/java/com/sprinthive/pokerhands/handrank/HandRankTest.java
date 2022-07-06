package com.sprinthive.pokerhands.handrank;

import com.sprinthive.pokerhands.Card;
import com.sprinthive.pokerhands.CardRank;
import com.sprinthive.pokerhands.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandRankTest {

    @Test
    public void testCompareTo() {
        RoyalFlushHandRank royalFlushClubs = new RoyalFlushHandRank(Suit.CLUBS);
        RoyalFlushHandRank royalFlushSpades = new RoyalFlushHandRank(Suit.SPADES);
        assertEquals(0, royalFlushClubs.compareTo(royalFlushSpades));
        StraightFlushHandRank straightFlushJack = new StraightFlushHandRank(CardRank.JACK);
        assertTrue(royalFlushClubs.compareTo(straightFlushJack) > 0);
        StraightFlushHandRank straightFlushTen = new StraightFlushHandRank(CardRank.TEN);
        assertTrue(straightFlushJack.compareTo(straightFlushTen) > 0);
        assertTrue(straightFlushTen.compareTo(straightFlushJack) < 0);
        StraightFlushHandRank straightFlushTenAgain = new StraightFlushHandRank(CardRank.TEN);
        assertTrue(straightFlushTen.compareTo(straightFlushTenAgain) == 0);
        FourOfAKindHandRank fourOfAKindKing = new FourOfAKindHandRank(CardRank.KING);
        assertTrue(royalFlushClubs.compareTo(fourOfAKindKing) > 0);
        assertTrue(straightFlushTen.compareTo(fourOfAKindKing) > 0);
        FourOfAKindHandRank fourOfAKindQueen = new FourOfAKindHandRank(CardRank.QUEEN);
        assertTrue(fourOfAKindQueen.compareTo(fourOfAKindKing) < 0);
        FullHouseHandRank fullHouseFiveThree = new FullHouseHandRank(CardRank.FIVE, CardRank.THREE);
        assertTrue(royalFlushClubs.compareTo(fullHouseFiveThree) > 0);
        assertTrue(straightFlushTen.compareTo(fullHouseFiveThree) > 0);
        assertTrue(fourOfAKindQueen.compareTo(fullHouseFiveThree) > 0);
        FullHouseHandRank fullHouseThreeTwo = new FullHouseHandRank(CardRank.THREE, CardRank.TWO);
        assertTrue(fullHouseFiveThree.compareTo(fullHouseThreeTwo) > 0);
        FullHouseHandRank fullHouseFiveTwo = new FullHouseHandRank(CardRank.FIVE, CardRank.TWO);
        assertTrue(fullHouseFiveThree.compareTo(fullHouseFiveTwo) > 0);
        assertTrue(fullHouseFiveTwo.compareTo(fullHouseThreeTwo) > 0);
        ArrayList<Card> flushQueenThreeList = new ArrayList<Card>(5);
        flushQueenThreeList.add(new Card(CardRank.NINE, Suit.CLUBS));
        flushQueenThreeList.add(new Card(CardRank.THREE, Suit.CLUBS));
        flushQueenThreeList.add(new Card(CardRank.QUEEN, Suit.CLUBS));
        flushQueenThreeList.add(new Card(CardRank.JACK, Suit.CLUBS));
        flushQueenThreeList.add(new Card(CardRank.TEN, Suit.CLUBS));
        FlushHandRank flushQueenThree = new FlushHandRank(flushQueenThreeList);
        assertTrue(royalFlushClubs.compareTo(flushQueenThree) > 0);
        assertTrue(straightFlushTen.compareTo(flushQueenThree) > 0);
        assertTrue(fourOfAKindQueen.compareTo(flushQueenThree) > 0);
        assertTrue(fullHouseFiveThree.compareTo(flushQueenThree) > 0);
        FlushHandRank flushQueenThreeAgain = new FlushHandRank(flushQueenThreeList);
        assertTrue(flushQueenThree.compareTo(flushQueenThreeAgain) == 0);

        ArrayList<Card> flushQueenTwoList = new ArrayList<Card>(5);
        flushQueenTwoList.add(new Card(CardRank.NINE, Suit.HEARTS));
        flushQueenTwoList.add(new Card(CardRank.TWO, Suit.HEARTS));
        flushQueenTwoList.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        flushQueenTwoList.add(new Card(CardRank.JACK, Suit.HEARTS));
        flushQueenTwoList.add(new Card(CardRank.TEN, Suit.HEARTS));
        FlushHandRank flushQueenTwo = new FlushHandRank(flushQueenTwoList);
        assertTrue(flushQueenThree.compareTo(flushQueenTwo) > 0);
        ArrayList<Card> flushKingTwoList = new ArrayList<Card>(5);
        flushKingTwoList.add(new Card(CardRank.NINE, Suit.CLUBS));
        flushKingTwoList.add(new Card(CardRank.TWO, Suit.CLUBS));
        flushKingTwoList.add(new Card(CardRank.KING, Suit.CLUBS));
        flushKingTwoList.add(new Card(CardRank.JACK, Suit.CLUBS));
        flushKingTwoList.add(new Card(CardRank.TEN, Suit.CLUBS));
        FlushHandRank flushKingTwo = new FlushHandRank(flushKingTwoList);
        assertTrue(flushKingTwo.compareTo(flushQueenThree) > 0);
        assertTrue(flushKingTwo.compareTo(flushQueenTwo) > 0);
        StraightHandRank straightKing = new StraightHandRank(CardRank.KING);
        assertTrue(royalFlushClubs.compareTo(straightKing) > 0);
        assertTrue(straightFlushTen.compareTo(straightKing) > 0);
        assertTrue(fourOfAKindQueen.compareTo(straightKing) > 0);
        assertTrue(fullHouseFiveThree.compareTo(straightKing) > 0);
        assertTrue(flushQueenThree.compareTo(straightKing) > 0);
        StraightHandRank straightNine = new StraightHandRank(CardRank.NINE);
        assertTrue(straightKing.compareTo(straightNine) > 0);
        ThreeOfAKindHandRank threeOfAKindSix = new ThreeOfAKindHandRank(CardRank.SIX);
        assertTrue(royalFlushClubs.compareTo(threeOfAKindSix) > 0);
        assertTrue(straightFlushTen.compareTo(threeOfAKindSix) > 0);
        assertTrue(fourOfAKindQueen.compareTo(threeOfAKindSix) > 0);
        assertTrue(fullHouseFiveThree.compareTo(threeOfAKindSix) > 0);
        assertTrue(flushQueenThree.compareTo(threeOfAKindSix) > 0);
        assertTrue(straightKing.compareTo(threeOfAKindSix) > 0);
        ThreeOfAKindHandRank threeOfAKindFive = new ThreeOfAKindHandRank(CardRank.FIVE);
        assertTrue(threeOfAKindSix.compareTo(threeOfAKindFive) > 0);
        TwoPairHandRank twoPairTenFiveThree = new TwoPairHandRank(CardRank.TEN, CardRank.FIVE, CardRank.THREE);
        assertTrue(royalFlushClubs.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(straightFlushTen.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(fourOfAKindQueen.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(fullHouseFiveThree.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(flushQueenThree.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(straightKing.compareTo(twoPairTenFiveThree) > 0);
        assertTrue(threeOfAKindSix.compareTo(twoPairTenFiveThree) > 0);
        TwoPairHandRank twoPairTenFiveThreeAgain = new TwoPairHandRank(CardRank.TEN, CardRank.FIVE, CardRank.THREE);
        assertTrue(twoPairTenFiveThree.compareTo(twoPairTenFiveThreeAgain) == 0);
        TwoPairHandRank twoPairTenFiveTwo = new TwoPairHandRank(CardRank.TEN, CardRank.FIVE, CardRank.TWO);
        assertTrue(twoPairTenFiveThree.compareTo(twoPairTenFiveTwo) > 0);
        TwoPairHandRank twoPairTenFourTwo = new TwoPairHandRank(CardRank.TEN, CardRank.FOUR, CardRank.TWO);
        assertTrue(twoPairTenFiveThree.compareTo(twoPairTenFourTwo) > 0);
        TwoPairHandRank twoPairNineFiveTwo = new TwoPairHandRank(CardRank.NINE, CardRank.FIVE, CardRank.TWO);
        assertTrue(twoPairTenFiveThree.compareTo(twoPairNineFiveTwo) > 0);
        ArrayList<CardRank> onePairTen765List = new ArrayList<CardRank>(3);
        onePairTen765List.add(CardRank.SEVEN);
        onePairTen765List.add(CardRank.SIX);
        onePairTen765List.add(CardRank.FIVE);
        OnePairHandRank onePairTen765 = new OnePairHandRank(CardRank.TEN, onePairTen765List);
        assertTrue(royalFlushClubs.compareTo(onePairTen765) > 0);
        assertTrue(straightFlushTen.compareTo(onePairTen765) > 0);
        assertTrue(fourOfAKindQueen.compareTo(onePairTen765) > 0);
        assertTrue(fullHouseFiveThree.compareTo(onePairTen765) > 0);
        assertTrue(flushQueenThree.compareTo(onePairTen765) > 0);
        assertTrue(straightKing.compareTo(onePairTen765) > 0);
        assertTrue(threeOfAKindSix.compareTo(onePairTen765) > 0);
        assertTrue(twoPairTenFiveThree.compareTo(onePairTen765) > 0);
        ArrayList<CardRank> onePairTen763List = new ArrayList<CardRank>(3);
        onePairTen763List.add(CardRank.SEVEN);
        onePairTen763List.add(CardRank.SIX);
        onePairTen763List.add(CardRank.THREE);
        OnePairHandRank onePairTen763 = new OnePairHandRank(CardRank.TEN, onePairTen763List);
        assertTrue(onePairTen765.compareTo(onePairTen763) > 0);
        OnePairHandRank onePairTen763Again = new OnePairHandRank(CardRank.TEN, onePairTen763List);
        assertTrue(onePairTen763.compareTo(onePairTen763Again) == 0);
        ArrayList<CardRank> onePairTen743List = new ArrayList<CardRank>(3);
        onePairTen743List.add(CardRank.SEVEN);
        onePairTen743List.add(CardRank.FOUR);
        onePairTen743List.add(CardRank.THREE);
        OnePairHandRank onePairTen743 = new OnePairHandRank(CardRank.TEN, onePairTen743List);
        assertTrue(onePairTen763.compareTo(onePairTen743) > 0);
        OnePairHandRank onePairNine743 = new OnePairHandRank(CardRank.NINE, onePairTen743List);
        assertTrue(onePairTen763.compareTo(onePairNine743) > 0);
        ArrayList<Card> highAQ975 = new ArrayList<Card>(5);
        highAQ975.add(new Card(CardRank.ACE, Suit.CLUBS));
        highAQ975.add(new Card(CardRank.QUEEN, Suit.CLUBS));
        highAQ975.add(new Card(CardRank.NINE, Suit.DIAMONDS));
        highAQ975.add(new Card(CardRank.SEVEN, Suit.CLUBS));
        highAQ975.add(new Card(CardRank.FIVE, Suit.CLUBS));
        HighCardHandRank highCardAQ975 = new HighCardHandRank(highAQ975);
        assertTrue(royalFlushClubs.compareTo(highCardAQ975) > 0);
        assertTrue(straightFlushTen.compareTo(highCardAQ975) > 0);
        assertTrue(fourOfAKindQueen.compareTo(highCardAQ975) > 0);
        assertTrue(fullHouseFiveThree.compareTo(highCardAQ975) > 0);
        assertTrue(flushQueenThree.compareTo(highCardAQ975) > 0);
        assertTrue(straightKing.compareTo(highCardAQ975) > 0);
        assertTrue(threeOfAKindSix.compareTo(highCardAQ975) > 0);
        assertTrue(twoPairTenFiveThree.compareTo(highCardAQ975) > 0);
        assertTrue(onePairTen765.compareTo(highCardAQ975) > 0);
        HighCardHandRank highCardAQ975Again = new HighCardHandRank(highAQ975);
        assertTrue(highCardAQ975.compareTo(highCardAQ975Again) == 0);
        ArrayList<Card> highAQ875 = new ArrayList<Card>(5);
        highAQ875.add(new Card(CardRank.ACE, Suit.CLUBS));
        highAQ875.add(new Card(CardRank.QUEEN, Suit.CLUBS));
        highAQ875.add(new Card(CardRank.EIGHT, Suit.DIAMONDS));
        highAQ875.add(new Card(CardRank.SEVEN, Suit.CLUBS));
        highAQ875.add(new Card(CardRank.FIVE, Suit.CLUBS));
        HighCardHandRank highCardAQ875 = new HighCardHandRank(highAQ875);
        assertTrue(highCardAQ975.compareTo(highCardAQ875) > 0);

        NotRankableHandRanker notRankable1 = new NotRankableHandRanker(null);
        NotRankableHandRanker notRankable2 = new NotRankableHandRanker(Collections.EMPTY_LIST);
        assertEquals(0, notRankable1.compareTo(notRankable2));
        assertEquals(0, notRankable1.compareSameRank(notRankable2));

    }

    @Test
    public void testRoyalFlushHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new RoyalFlushHandRank(null),
                "RoyalFlushHandRank should enforce not null suit");
    }

    @Test
    public void testStraightFlushHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StraightFlushHandRank(null),
                "StraightFlushHandRank should enforce not null rank");
    }

    @Test
    public void testFourOfAKindHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FourOfAKindHandRank(null),
                "FourOfAKindHandRank should enforce not null rank");
    }

    @Test
    public void testFullHouseHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FullHouseHandRank(null, null),
                "FullHouseHandRank should enforce not null trips and pairs");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FullHouseHandRank(null, CardRank.NINE),
                "FullHouseHandRank should enforce not null trips");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FullHouseHandRank(CardRank.EIGHT, null),
                "FullHouseHandRank should enforce not null pairs");
    }

    @Test
    public void testFlushHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FlushHandRank(null),
                "FlushHandRank should enforce not null cards");

        ArrayList<Card> cards = new ArrayList<Card>(5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FlushHandRank(cards),
                "FlushHandRank should enforce 5 cards");

        cards.add(new Card(CardRank.NINE, Suit.CLUBS));
        cards.add(new Card(CardRank.THREE, Suit.CLUBS));
        cards.add(new Card(CardRank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(CardRank.JACK, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TEN, Suit.CLUBS));
        cards.add(new Card(CardRank.TWO, Suit.CLUBS));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FlushHandRank(cards),
                "FlushHandRank should enforce not 5 cards for rest");
    }

    @Test
    public void testStraightHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StraightHandRank(null),
                "StraightHandRank should enforce not null rank");
    }

    @Test
    public void testThreeOfAKindHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ThreeOfAKindHandRank(null),
                "ThreeOfAKindHandRank should enforce not null rank");
    }

    @Test
    public void testTwoPairHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TwoPairHandRank(null, CardRank.FOUR, CardRank.TWO),
                "ThreeOfAKindHandRank should enforce not null high rank");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TwoPairHandRank(CardRank.FOUR, null, CardRank.TWO),
                "ThreeOfAKindHandRank should enforce not null low rank");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TwoPairHandRank(CardRank.FOUR, CardRank.THREE, null),
                "ThreeOfAKindHandRank should enforce not null kicker");
    }

    @Test
    public void testOnePairHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OnePairHandRank(null, null),
                "OnePairHandRank should enforce not null pair and rest");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OnePairHandRank(CardRank.NINE, null),
                "OnePairHandRank should enforce not null rest");

        ArrayList<CardRank> cards = new ArrayList<CardRank>(3);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OnePairHandRank(null, cards),
                "OnePairHandRank should enforce not null pair");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OnePairHandRank(CardRank.NINE, cards),
                "OnePairHandRank should enforce not 3 cards for rest");

        cards.add(CardRank.ACE);
        cards.add(CardRank.QUEEN);
        cards.add(CardRank.EIGHT);
        cards.add(CardRank.SEVEN);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OnePairHandRank(CardRank.NINE, cards),
                "OnePairHandRank should enforce not 3 cards for rest");
    }

    @Test
    public void testHighCardHandRank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new HighCardHandRank(null),
                "HighCardHandRank should enforce 5 cards");

        ArrayList<Card> cards = new ArrayList<Card>(5);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new HighCardHandRank(cards),
                "HighCardHandRank should enforce 5 cards");

        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.QUEEN, Suit.CLUBS));
        cards.add(new Card(CardRank.EIGHT, Suit.DIAMONDS));
        cards.add(new Card(CardRank.SEVEN, Suit.CLUBS));
        cards.add(new Card(CardRank.FIVE, Suit.CLUBS));
        cards.add(new Card(CardRank.TWO, Suit.CLUBS));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new HighCardHandRank(cards),
                "HighCardHandRank should enforce 5 cards");
    }
}
