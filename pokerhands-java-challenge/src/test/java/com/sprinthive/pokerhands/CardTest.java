package com.sprinthive.pokerhands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardSuitNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                // Try to create a Card without a suit
                () -> new Card(CardRank.TWO, null),
                "Card should not accept a null Suit");
    }

    @Test
    public void testCardRankNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                // Try to create a Card without a rank
                () -> new Card(null, Suit.CLUBS),
                "Card should not accept a null Rank");
    }

    @Test
    public void testCardTwoOfClubs() {
        // Create a two of clubs
        Card card = new Card(CardRank.TWO, Suit.CLUBS);

        // Ensure that this is an two of clubs
        // Examples of other cards are:
        //   two of diamonds
        //   king of spades
        assertEquals("two of clubs", card.toString());
    }

    @Test
    public void testCardAceOfClubs() {
        // Create a ace of clubs
        Card card = new Card(CardRank.ACE, Suit.CLUBS);

        // Ensure that this is an ace of clubs
        // Examples of other cards are:
        //   two of diamonds
        //   king of spades
        assertEquals("ace of clubs", card.toString());
    }

    @Test
    public void testCardKingOfHearts() {
        // Create a king of hearts
        Card card = new Card(CardRank.KING, Suit.HEARTS);

        // Ensure that this is an king of hearts
        // Examples of other cards are:
        //   two of diamonds
        //   king of spades
        assertEquals("king of hearts", card.toString());
    }

    @Test
    public void testCompareTo() {
        // Create a king of hearts
        Card kingHearts1 = new Card(CardRank.KING, Suit.HEARTS);
        // Create another king of hearts
        Card kingHearts2 = new Card(CardRank.KING, Suit.HEARTS);
        assertEquals(0, kingHearts1.compareTo(kingHearts2));
        // Create a king of clubs
        Card kingClubs = new Card(CardRank.KING, Suit.CLUBS);
        assertEquals(0, kingHearts1.compareTo(kingClubs));
        // Create a queen of hearts
        Card queenHearts = new Card(CardRank.QUEEN, Suit.HEARTS);
        assertEquals(1, kingHearts1.compareTo(queenHearts));
    }

    @Test
    public void testEquals() {
        // Create a king of hearts
        Card kingHearts1 = new Card(CardRank.KING, Suit.HEARTS);
        // Create another king of hearts
        Card kingHearts2 = new Card(CardRank.KING, Suit.HEARTS);
        assertEquals(kingHearts2, kingHearts1);
        // Create a king of clubs
        Card kingClubs = new Card(CardRank.KING, Suit.CLUBS);
        assertNotEquals(kingHearts1, kingClubs);
        // Create a queen of hearts
        Card queenHearts = new Card(CardRank.QUEEN, Suit.HEARTS);
        assertNotEquals(kingHearts1, queenHearts);
    }

    @Test
    public void testHashCode() {
        HashSet<Integer> hashCodes = new HashSet<Integer>(52 * 2);
        for (Suit suit : Suit.values()) {
            for (CardRank rank : CardRank.values()) {
                int hashCode = (new Card(rank, suit)).hashCode();
                if (hashCodes.contains(hashCode)) {
                    fail("We have a hash collision on a 52 card set and need a new hashcode method");
                }
                hashCodes.add(hashCode);
            }
        }
    }
}
