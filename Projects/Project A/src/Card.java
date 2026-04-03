
import java.util.HashMap;

/**
 * Represents a traditional playing card, used for cribbage calculations so a
 * second rank value containing only values [1,10] is stored as well
 * 
 * @author Harrison Haas
 */
public class Card {

    // Fields

    private int rank;
    private int suit;
    private int rankFifteen;
    private boolean topCard;

    private static HashMap<Integer, String> rankName = new HashMap<>();
    private static HashMap<Integer, String> suitName = new HashMap<>();

    // Constructor

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        this.rankFifteen = convertRank(rank);
        this.topCard = false;
        setRankName();
        setSuitName();
    }

    // Getters and Setters

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRankFifteen() {
        return rankFifteen;
    }

    public void setRankFifteen(int rankFifteen) {
        this.rankFifteen = rankFifteen;
    }

    public boolean isTopCard() {
        return topCard;
    }

    public void setTopCard(boolean topCard) {
        this.topCard = topCard;
    }

    public static String getRankName(int rank) {
        return rankName.get(rank);
    }

    public static String getSuitName(int suit) {
        return suitName.get(suit);
    }

    // Other Methods

    /**
     * If an inputted integer is under 11, the integer is returned, if it is in the
     * range [11,13], 10 is returned, if it is outside of those ranges, -1 is
     * returned. This method is for the purposes of calculating sums in a cribbage
     * hand
     * 
     * @param rank the integer to be considered
     * 
     * @return The conversion ready for summation
     */
    private int convertRank(int rank) {
        if (rank > 0 && rank < 11) {
            return rank;
        } else if (rank < 14) {
            return 10;
        }
        return -1;
    }

    /**
     * Checks if a card is a valid playing card, ie the rank is in the range [1,13]
     * and the suit is in the range [1,4]
     * 
     * @return True if the card is valid, false if not
     */
    public boolean isValid() {
        if ((rank < 1 || rank > 13) || (suit < 1 || suit > 4))
            return false;
        return true;
    }

    /**
     * Sets the values inside of rankName
     */
    private void setRankName() {
        rankName.put(1, "Ace");
        rankName.put(2, "Two");
        rankName.put(3, "Three");
        rankName.put(4, "Four");
        rankName.put(5, "Five");
        rankName.put(6, "Six");
        rankName.put(7, "Seven");
        rankName.put(8, "Eight");
        rankName.put(9, "Nine");
        rankName.put(10, "Ten");
        rankName.put(11, "Jack");
        rankName.put(12, "Queen");
        rankName.put(13, "King");
    }

    /**
     * Sets the values inside of suitName
     */
    private void setSuitName() {
        suitName.put(1, "Hearts");
        suitName.put(2, "Diamonds");
        suitName.put(3, "Clubs");
        suitName.put(4, "Spades");
    }

    /**
     * Compares the rank and Suit of two cards, if they are equal true is
     * returned
     * 
     * @param c The card to be compared to
     * @return True if the cards are equal, false if they are not
     */
    public boolean equals(Card c) {
        if (this.getRank() == c.getRank() && this.getSuit() == c.getSuit()) {
            return true;
        }
        return false;
    }
}