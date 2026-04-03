
import javax.swing.*;
import java.util.ArrayList;

/**
 * Contains all the ways a cribbage hand can score and calculates the score of
 * an inputted hand
 * 
 * @author Harrison Haas
 */

public class ScoreBreakdown extends JPanel {

    // Fields

    private Hand hand;
    private int topCardRank;
    private int card0Rank;
    private int card1Rank;
    private int card2Rank;
    private int card3Rank;

    private ArrayList<String> output;
    private int finalScore;

    private ScoringEvents se;

    // Constructor

    public ScoreBreakdown(Hand hand) {
        this.hand = hand;
        hand.sort();
        this.topCardRank = hand.getTopCard().getRank();
        this.card0Rank = hand.getCard(0).getRank();
        this.card1Rank = hand.getCard(1).getRank();
        this.card2Rank = hand.getCard(2).getRank();
        this.card3Rank = hand.getCard(3).getRank();
        this.se = new ScoringEvents();
        this.output = new ArrayList<String>();
        fifteens();
        runsAndPairs();
        flush();
        knobs();
        this.finalScore = se.finalScore();
    };

    // Getters

    public ArrayList<String> getOutput() {
        return output;
    }

    public int getFinalScore() {
        return finalScore;
    }

    // Other methods

    /**
     * Checks an hand for up to five sequential values, pairs within
     * sequential values, and pairs
     */
    public void runsAndPairs() {
        if (runOfFive()) {
            output.add(se.runOfFive());
        } else if (runOfFour()) {
            if (pair()) {
                output.add(se.doubleRunOfFour());
            } else {
                output.add(se.runOfFour());
            }
        } else if (runOfThree()) {
            if (threeOfAKind()) {
                output.add(se.tripleRun());
            } else if (twoPair()) {
                output.add(se.doubleDoubleRun());
            } else if (pair()) {
                if (doubleRun()) {
                    output.add(se.doubleRun());
                } else {
                    output.add(se.runOfThree());
                    output.add(se.pair());
                }
            } else {
                output.add(se.runOfThree());
            }
        } else {
            pairs();
        }
    }

    /**
     * Checks a hand for five sequential values
     * 
     * @return True if a run of five is found, false if not
     */
    public boolean runOfFive() {
        // The top card is the first card in the run
        if (this.topCardRank + 1 == this.card0Rank && this.topCardRank + 2 == this.card1Rank
                && this.topCardRank + 3 == this.card2Rank && this.topCardRank + 4 == this.card3Rank)
            return true;
        // The top card is the second card in the run
        if (this.card0Rank + 1 == this.topCardRank && this.card0Rank + 2 == this.card1Rank
                && this.card0Rank + 3 == this.card2Rank && this.card0Rank + 4 == this.card3Rank)
            return true;
        // The top card is the third card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.topCardRank
                && this.card0Rank + 3 == this.card2Rank && this.card0Rank + 4 == this.card3Rank)
            return true;
        // The top card is the fourth card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank
                && this.card0Rank + 3 == this.topCardRank && this.card0Rank + 4 == this.card3Rank)
            return true;
        // The top card is the fifth card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank
                && this.card0Rank + 3 == this.card3Rank && this.card0Rank + 4 == this.topCardRank)
            return true;
        return false;
    }

    /**
     * Checks a hand that doesn't contain a run of five for a four cards of
     * successive ranks
     * 
     * @return True if a run of four is found, false if not
     */
    public boolean runOfFour() {
        // Only runs if a run of five isn't detected
        // Run is just in the hand
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank
                && this.card0Rank + 3 == this.card3Rank)
            return true;
        // The top card is the first card in the run
        if (this.topCardRank + 1 == this.card0Rank && this.topCardRank + 2 == this.card1Rank
                && this.topCardRank + 3 == this.card2Rank)
            return true;
        if (this.topCardRank + 1 == this.card1Rank && this.topCardRank + 2 == this.card2Rank
                && this.topCardRank + 3 == this.card3Rank)
            return true;
        // The top card is the second card in the run
        if (this.card0Rank + 1 == this.topCardRank && this.card0Rank + 2 == this.card1Rank
                && this.card0Rank + 3 == this.card2Rank)
            return true;
        if (this.card1Rank + 1 == this.topCardRank && this.card1Rank + 2 == this.card2Rank
                && this.card1Rank + 3 == this.card3Rank)
            return true;
        // The top card is the third card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.topCardRank
                && this.card0Rank + 3 == this.card2Rank)
            return true;
        if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.topCardRank
                && this.card1Rank + 3 == this.card3Rank)
            return true;
        // The top card is the fourth card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank
                && this.card0Rank + 3 == this.topCardRank)
            return true;
        if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.card3Rank
                && this.card1Rank + 3 == this.topCardRank)
            return true;
        return false;
    }

    /**
     * Checks a hand that doesn't contain a run of four or five for three cards of
     * successive ranks
     * 
     * @return True if a run of three is detected, false if not
     */
    public boolean runOfThree() {
        // Only runs if a higher run isn't detected
        // Run of three happens only in the hand
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank)
            return true;
        if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.card3Rank)
            return true;
        // Run of three contains the topCard
        // The top card is the first card in the run
        if (this.topCardRank + 1 == this.card0Rank && this.topCardRank + 2 == this.card1Rank)
            return true;
        if (this.topCardRank + 1 == this.card1Rank && this.topCardRank + 2 == this.card2Rank)
            return true;
        if (this.topCardRank + 1 == this.card2Rank && this.topCardRank + 2 == this.card3Rank)
            return true;
        // The top card is the second card in the run
        if (this.card0Rank + 1 == this.topCardRank && this.card0Rank + 2 == this.card1Rank)
            return true;
        if (this.card1Rank + 1 == this.topCardRank && this.card1Rank + 2 == this.card2Rank)
            return true;
        if (this.card2Rank + 1 == this.topCardRank && this.card2Rank + 2 == this.card3Rank)
            return true;
        // The top card is the third card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.topCardRank)
            return true;
        if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.topCardRank)
            return true;
        if (this.card2Rank + 1 == this.card3Rank && this.card2Rank + 2 == this.topCardRank)
            return true;
        return false;
    }

    /**
     * Checks an array of Cards for a pair within a run in the values
     * 
     * @param a The array of Cards to be considered
     * @return True if a double run appears, false if not
     */
    public boolean doubleRun() {
        // Only runs if the hand has a three of a kind and a pair
        // Run of three happens only in the hand
        // Pair is with top card or pair is with other card in hand
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.card2Rank) {
            if (this.card0Rank == this.topCardRank || this.card1Rank == this.topCardRank
                    || this.card2Rank == this.topCardRank)
                return true;
            if (this.card0Rank == this.card3Rank || this.card1Rank == this.card3Rank
                    || this.card2Rank == this.card3Rank)
                return true;
        } else if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.card3Rank) {
            if (this.card1Rank == this.topCardRank || this.card2Rank == this.topCardRank
                    || this.card3Rank == this.topCardRank)
                return true;
            if (this.card1Rank == this.card0Rank || this.card2Rank == this.card0Rank
                    || this.card3Rank == this.card0Rank)
                return true;
        }

        // Run of three contains the topCard
        // The top card is the first card in the run
        if (this.topCardRank + 1 == this.card0Rank && this.topCardRank + 2 == this.card1Rank) {
            if (this.topCardRank == this.card2Rank || this.card0Rank == this.card2Rank
                    || this.card1Rank == this.card2Rank)
                return true;
            if (this.topCardRank == this.card3Rank || this.card0Rank == this.card3Rank
                    || this.card1Rank == this.card3Rank)
                return true;
        } else if (this.topCardRank + 1 == this.card1Rank && this.topCardRank + 2 == this.card2Rank) {
            if (this.topCardRank == this.card0Rank || this.card1Rank == this.card0Rank
                    || this.card2Rank == this.card0Rank)
                return true;
            if (this.topCardRank == this.card3Rank || this.card1Rank == this.card3Rank
                    || this.card2Rank == this.card3Rank)
                return true;
        } else if (this.topCardRank + 1 == this.card2Rank && this.topCardRank + 2 == this.card3Rank) {
            if (this.topCardRank == this.card0Rank || this.card2Rank == this.card0Rank
                    || this.card3Rank == this.card0Rank)
                return true;
            if (this.topCardRank == this.card1Rank || this.card2Rank == this.card1Rank
                    || this.card3Rank == this.card1Rank)
                return true;
        }

        // The top card is the second card in the run
        if (this.card0Rank + 1 == this.topCardRank && this.card0Rank + 2 == this.card1Rank) {
            if (this.card0Rank == this.card2Rank || this.topCardRank == this.card2Rank
                    || this.card1Rank == this.card2Rank)
                return true;
            if (this.card0Rank == this.card3Rank || this.topCardRank == this.card3Rank
                    || this.card1Rank == this.card3Rank)
                return true;
        } else if (this.card1Rank + 1 == this.topCardRank && this.card1Rank + 2 == this.card2Rank) {
            if (this.card1Rank == this.card0Rank || this.topCardRank == this.card0Rank
                    || this.card2Rank == this.card0Rank)
                return true;
            if (this.card1Rank == this.card3Rank || this.topCardRank == this.card3Rank
                    || this.card2Rank == this.card3Rank)
                return true;
        } else if (this.card2Rank + 1 == this.topCardRank && this.card2Rank + 2 == this.card3Rank) {
            if (this.card2Rank == this.card0Rank || this.topCardRank == this.card0Rank
                    || this.card3Rank == this.card0Rank)
                return true;
            if (this.card2Rank == this.card1Rank || this.topCardRank == this.card1Rank
                    || this.card3Rank == this.card1Rank)
                return true;
        }

        // The top card is the third card in the run
        if (this.card0Rank + 1 == this.card1Rank && this.card0Rank + 2 == this.topCardRank) {
            if (this.card0Rank == this.card2Rank || this.card1Rank == this.card2Rank
                    || this.topCardRank == this.card2Rank)
                return true;
            if (this.card0Rank == this.card3Rank || this.card1Rank == this.card3Rank
                    || this.topCardRank == this.card3Rank)
                return true;
        } else if (this.card1Rank + 1 == this.card2Rank && this.card1Rank + 2 == this.topCardRank) {
            if (this.card1Rank == this.card0Rank || this.card2Rank == this.card0Rank
                    || this.topCardRank == this.card0Rank)
                return true;
            if (this.card1Rank == this.card3Rank || this.card2Rank == this.card3Rank
                    || this.topCardRank == this.card3Rank)
                return true;
        } else if (this.card2Rank + 1 == this.card3Rank && this.card2Rank + 2 == this.topCardRank) {
            if (this.card2Rank == this.card0Rank || this.card3Rank == this.card0Rank
                    || this.topCardRank == this.card0Rank)
                return true;
            if (this.card2Rank == this.card1Rank || this.card3Rank == this.card1Rank
                    || this.topCardRank == this.card1Rank)
                return true;
        }

        return false;
    }

    /**
     * Checks if a hand contains four of a kind, three of a kind, three of a kind
     * with a pair, two pairs, or a single pair
     * 
     */
    public void pairs() {
        if (fourOfAKind()) {
            output.add(se.fourOfAKind());
        } else if (threeOfAKind()) {
            if (threeOfAKindAndPair()) {
                output.add(se.pair());
                output.add(se.threeOfAKind());
            } else {
                output.add(se.threeOfAKind());
            }
        } else if (twoPair()) {
            output.add(se.pair());
            output.add(se.pair());
        } else if (pair()) {
            output.add(se.pair());
        }
    }

    /**
     * Checks if a hand contains a pair of only hand cards
     * 
     * @return True if a pair is found, false if not
     */
    private boolean pairHandCards() {
        int cases = 3;
        for (int i = 0; i < cases; i++) {
            if (hand.getCard(i).getRank() == hand.getCard(i + 1).getRank()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a hand contains a pair of one hand card, one top card
     * 
     * @return True if a pair is found, false if not
     */
    private boolean pairTopCard() {
        for (int i = 0; i < hand.length(); i++) {
            if (hand.getCard(i).getRank() == this.topCardRank) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks a hand for two sets of cards that have the same rank
     * 
     */
    public boolean twoPair() {
        // Two pairs in the hand top card not included
        if (this.card0Rank == this.card1Rank && this.card2Rank == this.card3Rank) {
            return true;
        }

        // One pair with the top card one pair of just hand cards
        if (this.card0Rank == this.topCardRank) {
            if (this.card1Rank == this.card2Rank || this.card2Rank == this.card3Rank) {
                return true;
            }
        } else if (this.card1Rank == this.topCardRank) {
            if (this.card0Rank == this.card2Rank || this.card0Rank == this.card3Rank) {
                return true;
            }
        } else if (this.card2Rank == this.topCardRank) {
            if (this.card0Rank == this.card1Rank || this.card0Rank == this.card3Rank) {
                return true;
            }
        } else if (this.card3Rank == this.topCardRank) {
            if (this.card0Rank == this.card1Rank || this.card0Rank == this.card2Rank) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks a hand that has already been confirmed to not have a four of a kind, a
     * three of a kind, or a two pair for any two cards of the same rank
     * 
     */
    public boolean pair() {
        // This will only run if there is no four of a kind, three of a kinds, or two
        // pair

        // Two cards in the hand are the same rank
        if (pairHandCards()) {
            return true;
        }

        // One card in the hand is the same rank as the topCard
        if (pairTopCard()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if any three values in a sorted hand are the same rank, not including
     * the topCard
     * 
     * @return True if a three of a kind without the top card is found, false if not
     */
    private boolean threeOfAKindNoTopCard() {
        int cases = 2;
        for (int i = 0; i < cases; i++) {
            if ((hand.getCard(i).getRank() == hand.getCard(i + 1).getRank())
                    && (hand.getCard(i).getRank() == hand.getCard(i + 2).getRank()))
                return true;
        }
        return false;
    }

    /**
     * Checks if any pair of cards in a hand are the same rank as the top card
     * 
     * @return True if a three of a kind containing the top card is found, false if
     *         not
     */
    private boolean threeOfAKindWithTopCard() {
        int cases = 3;
        for (int i = 0; i < cases; i++) {
            if ((hand.getCard(i).getRank() == this.topCardRank)
                    && (hand.getCard(i).getRank() == hand.getCard(i + 1).getRank()))
                return true;
        }
        return false;
    }

    /**
     * Checks a hand that has already been confirmed to have a three of a kind if
     * the remaining two cards are of the same rank
     * 
     * @return True if there is a pair outside of the three of a kind, false if not
     */
    public boolean threeOfAKindAndPair() {
        // This will only run if there is already a three of a kind

        // The first three cards are the same and the last card is the same as the top
        // card
        // The last three cards are the same and the first card is the same as the top
        // card
        if (threeOfAKindNoTopCard()) {
            if (this.card0Rank == this.topCardRank) {
                return true;
            } else if (this.card1Rank == this.topCardRank) {
                return true;
            }
        }

        // The top card is the same as the first two cards and the last two cards are
        // the same
        // The top card is the same as the middle two carda and the first and last cards
        // are the same
        // The top card is the same as the last two card and the first two cards are the
        // same
        if (threeOfAKindWithTopCard()) {
            if (this.card0Rank == this.card1Rank || this.card0Rank == this.card3Rank) {
                return true;
            } else if (this.card1Rank == this.card2Rank) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if any three three values in a sorted hand are the same
     * 
     */
    public boolean threeOfAKind() {
        // This will only run if there are no four of a kinds

        // The first three cards are the same or the last three cards are the same
        if (threeOfAKindNoTopCard()) {
            return true;
        }
        // The top card is the same as the first two cards, the middle two cards, or the
        // last two cards
        return threeOfAKindWithTopCard();
    }

    /**
     * Checks if four values in a sorted hand are the same
     * 
     */
    public boolean fourOfAKind() {

        // All four hand card match
        if (this.card0Rank == this.card1Rank) {
            if (this.card1Rank == this.card2Rank
                    && this.card2Rank == this.card3Rank)
                return true;
        }
        // The top card matches either the first three hand cards or the last three hand
        // cards
        int cases = 2;
        for (int i = 0; i < cases; i++) {
            if (hand.getCard(i).getRank() == this.topCardRank) {
                if (hand.getCard(i).getRank() == hand.getCard(i + 1).getRank()
                        && hand.getCard(i).getRank() == hand.getCard(i + 2).getRank())
                    return true;
            }
        }
        return false;
    }

    /**
     * Checks if the suits in a hand all match, if all but the top card
     * match, or otherwise and runs the corresponding method within the
     * ScoringEvents class
     * 
     */
    public void flush() {
        int difftopCard = 0;
        int topCardSuit = 0;
        topCardSuit = hand.getTopCard().getSuit();
        for (int i = 0; i < hand.length(); i++) {
            Card c = hand.getCard(i);
            if (c.getSuit() != topCardSuit) {
                difftopCard++;
            }
        }
        if (difftopCard == 0) {
            output.add(se.flushFive());
        } else if (difftopCard == 4) {
            boolean flushFour = true;
            int handSuit = hand.getCard(0).getSuit();
            for (int i = 1; i < hand.length(); i++) {
                if (hand.getCard(i).getSuit() != handSuit) {
                    flushFour = false;
                    break;
                }
            }
            if (flushFour && !hand.isCrib()) {
                output.add(se.flushFour());
            }
        }
    }

    /**
     * Checks if a hand card with the value of a jack in a hand has the
     * same suit as the top card
     * 
     */
    public void knobs() {
        int jackValue = 11;
        int topCardSuit = hand.getTopCard().getSuit();
        for (int i = 0; i < hand.length(); i++) {
            if (hand.getCard(i).getRank() == jackValue && hand.getCard(i).getSuit() == topCardSuit) {
                output.add(se.knobs());
            }
        }
    }

    /**
     * Calcuates every possible sum using the values of a cribbage hand
     * 
     */
    public void fifteens() {
        twoCardFifteen();// Two card combo
        threeCardFifteen();// Three card combo
        fourCardFifteen();// Four card Combo
        fiveCardFifteen();// Five card Combo

    }

    /**
     * Calculates all possible sums using two values from a hand
     * and runs the fifteen scoring method if fifteen is found
     */
    public void twoCardFifteen() {
        for (int i = 0; i < hand.length(); i++) {
            int sumTopCard = hand.getTopCard().getRankFifteen() + hand.getCard(i).getRankFifteen();
            if (sumTopCard == 15) {
                output.add(se.fifteen());
            }
            for (int n = i + 1; n < hand.length(); n++) {
                int sum = hand.getCard(i).getRankFifteen() + hand.getCard(n).getRankFifteen();
                if (sum == 15) {
                    output.add(se.fifteen());
                }
            }
        }
    }

    /**
     * Calculates all possible sums using three values from a hand and runs the
     * fifteen scoring method if fifteen is found
     */
    public void threeCardFifteen() {
        for (int i = 0; i < hand.length(); i++) {
            for (int j = i + 1; j < hand.length(); j++) {
                int sumTopCard = hand.getTopCard().getRankFifteen() + hand.getCard(i).getRankFifteen()
                        + hand.getCard(j).getRankFifteen();
                if (sumTopCard == 15) {
                    output.add(se.fifteen());
                }
                for (int k = j + 1; k < hand.length(); k++) {
                    int sum = hand.getCard(i).getRankFifteen() + hand.getCard(j).getRankFifteen()
                            + hand.getCard(k).getRankFifteen();
                    if (sum == 15) {
                        output.add(se.fifteen());
                    }
                }
            }
        }
    }

    /**
     * Calculates all possible sums using four values from a hand and runs the
     * fifteen scoring method if fifteen is found
     */
    public void fourCardFifteen() {
        // The top card is not included
        if (hand.getCard(0).getRankFifteen() + hand.getCard(1).getRankFifteen()
                + hand.getCard(2).getRankFifteen()
                + hand.getCard(3).getRankFifteen() == 15) {
            output.add(se.fifteen());
        }

        // The top card is included
        for (int i = 0; i < hand.length(); i++) {
            for (int j = i + 1; j < hand.length(); j++) {
                for (int k = j + 1; k < hand.length(); k++) {
                    int sum = hand.getCard(i).getRankFifteen() + hand.getCard(j).getRankFifteen()
                            + hand.getCard(k).getRankFifteen() + hand.getTopCard().getRankFifteen();
                    if (sum == 15) {
                        output.add(se.fifteen());
                    }
                }
            }
        }
    }

    /**
     * Calculates all possible sums using four values from a hand and runs the
     * fifteen scoring method if fifteen is found
     */
    public void fiveCardFifteen() {
        int total = hand.getTopCard().getRankFifteen();
        for (int i = 0; i < hand.length(); i++) {
            total += hand.getCard(i).getRankFifteen();
        }

        if (total == 15) {
            output.add(se.fifteen());
        }
    }

}
