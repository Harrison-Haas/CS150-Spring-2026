
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents a standard cribbage hand, either a six-card hand or a 4-card hand
 * with a top card
 * 
 * @author Harrison Haas
 */

public class Hand {

    // Fields

    private ArrayList<Card> hand;
    private Card topCard;
    private boolean crib;

    // Constructor

    public Hand(boolean crib) {
        this.crib = crib;
        this.hand = new ArrayList<Card>();
    }

    // Getters and Setters

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public boolean isCrib() {
        return crib;
    }

    // Other Methods

    /**
     * Returns the card stored in the inputted hand at a specified index
     * 
     * @param index The index of the Card to return
     * @return The card at that index
     */
    public Card getCard(int index) {
        return hand.get(index);
    }

    /**
     * Adds a card to the hand
     * 
     * @param card The Card class to be added
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * Checks if the hand is a valid four card hand with a top card
     * 
     * @return True if the hand is valid, false if not
     */
    public boolean isValidFourCardHand() {
        if (!(hand.size() == 4 && topCard != null)) {
            return false;
        }

        for (Card c : hand) {
            if (!c.isValid())
                return false;
        }

        if (topCard != null && !topCard.isValid())
            return false;

        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).equals(hand.get(j)))
                    return false;
            }
        }

        if (topCard != null) {
            for (Card c : hand) {
                if (c.equals(topCard))
                    return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand is a valid six card hand
     * 
     * @return True if the hand is valid, false if not
     */
    public boolean isValidSixCardHand() {
        if (!(hand.size() == 6)) {
            return false;
        }

        for (Card c : hand) {
            if (!c.isValid())
                return false;
        }

        if (topCard != null) {
            return false;
        }

        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).equals(hand.get(j)))
                    return false;
            }
        }
        return true;
    }

    /**
     * Formats a hand into a nice string
     */
    public String toString() {
        String output = "";
        for (Card c : hand) {
            output += c + "\n";
        }
        if (topCard != null) {
            output += topCard + " (TopCard)";
        }
        return output;
    }

    /**
     * Sorts a hand by rank, then suit if there are two cards of the same rank
     */
    public void sort() {
        Collections.sort(hand, Comparator.comparingInt(Card::getRank).thenComparingInt(Card::getSuit));
    }

    /**
     * Gets the length of the hand
     * 
     * @return The length of the hand
     */
    public int length() {
        return hand.size();
    }
}
