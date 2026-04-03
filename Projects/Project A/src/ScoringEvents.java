/**
 * Contains the methods to run when specific scoring events are found in a
 * cribbage hand. Contains a running tally of the points scored in a hand as
 * well as returns Strings of scoring messages
 * 
 * @author Harrison Haas
 */

public class ScoringEvents {

    // Fields

    private int points;

    // Constructor

    public ScoringEvents() {
        this.points = 0;
    }

    // Getters and setters

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Other methods

    /**
     * Adds 2 to the score and returns the String representing scoring a fifteen
     * 
     * @return A String representing what would be said after scoring a fifteen
     */
    public String fifteen() {
        points += 2;
        return "Fifteen-" + points;
    }

    /**
     * Adds 2 to the score and returns the String representing scoring a pain
     * 
     * @return A String representing what would be said after scoring a pair
     */
    public String pair() {
        points += 2;
        return "Pair for " + points;

    }

    /**
     * Adds 6 to the score and returns the String representing scoring a three of a
     * kind
     * 
     * @return A String representing what would be said after scoring a three of a
     *         kind
     */
    public String threeOfAKind() {
        points += 6;
        return "Three of a Kind makes " + points;

    }

    /**
     * Adds 12 to the score and returns the String representing scoring a four of a
     * kind
     * 
     * @return A String representing what would be said after scoring a four of a
     *         kind
     */
    public String fourOfAKind() {
        points += 12;
        return "Four of a Kind is " + points;

    }

    /**
     * Adds 3 to the score and returns the String representing scoring a run of
     * three
     * 
     * @return A String representing what would be said after scoring a run of three
     */
    public String runOfThree() {
        points += 3;
        return "Run of three for " + points;

    }

    /**
     * Adds 4 to the score and returns the String representing scoring a run of four
     * 
     * @return A String representing what would be said after scoring a run of four
     */
    public String runOfFour() {
        points += 4;
        return "Run of four makes " + points;

    }

    /**
     * Adds 5 to the score and returns the String representing scoring a run of five
     * 
     * @return A String representing what would be said after scoring a run of five
     */
    public String runOfFive() {
        points += 5;
        return "Run of five is " + points;

    }

    /**
     * Adds 4 to the score and returns the String representing scoring a four card
     * flush
     * 
     * @return A String representing what would be said after scoring a four card
     *         flush
     */
    public String flushFour() {
        points += 4;
        return "Flush of four makes " + points;

    }

    /**
     * Adds 5 to the score and returns the String representing scoring a five card
     * flush
     * 
     * @return A String representing what would be said after scoring a five card
     *         flush
     */
    public String flushFive() {
        points += 5;
        return "Flush of five is " + points;

    }

    /**
     * Adds 1 to the score and returns the String representing scoring a knobs
     * 
     * @return A String representing what would be said after scoring a fifteen
     */
    public String knobs() {
        points += 1;
        return "Knobs makes " + points;

    }

    /**
     * Adds 10 to the score and returns the String representing scoring a double run
     * of four
     * 
     * @return A String representing what would be said after scoring a double run
     *         of four
     */
    public String doubleRunOfFour() {
        points += 10;
        return "Double run of four for " + points;

    }

    /**
     * Adds 15 to the score and returns the String representing scoring a triple run
     * 
     * @return A String representing what would be said after scoring a triple run
     */
    public String tripleRun() {
        points += 15;
        return "Triple run is " + points;

    }

    /**
     * Adds 16 to the score and returns the String representing scoring a double
     * double run
     * 
     * @return A String representing what would be said after scoring a double
     *         double run
     */
    public String doubleDoubleRun() {
        points += 16;
        return "Double double run makes " + points;

    }

    /**
     * Adds 8 to the score and returns the String representing scoring a double run
     * 
     * @return A String representing what would be said after scoring a double run
     */
    public String doubleRun() {
        points += 8;
        return "Double run for " + points;
    }

    /**
     * Returns the final score
     * 
     * @return The amount of current points
     */
    public int finalScore() {
        return points;
    }

    /**
     * Returns the final score in a string
     * 
     * @return The amount of current points in a string
     */
    public String finalScoreMessage() {
        return "Final Score: " + points;
    }

}
