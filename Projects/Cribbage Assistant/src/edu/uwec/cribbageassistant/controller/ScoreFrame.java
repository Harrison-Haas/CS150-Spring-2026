package edu.uwec.cribbageassistant.controller;

import javax.swing.*;

import edu.uwec.cribbageassistant.model.Card;
import edu.uwec.cribbageassistant.model.Hand;
import edu.uwec.cribbageassistant.model.ScoreBreakdown;

import java.awt.*;

/**
 * A Frame that contains five labels containing the five cards the user inputs
 * and displays the score of the cribbage hand if the hand inputted is valid, if
 * the hand is invalid it will just display a message saying so
 * 
 * @author Harrison Haas
 */

public class ScoreFrame extends JFrame {

    // Fields

    private Hand hand;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel main;
    private GridBagConstraints gbc;
    private JPanel rankSuitLabelPanel;
    private JLabel rankTitle;
    private JLabel suitTitle;
    private JLabel rankNameLabel;
    private JLabel suitNameLabel;

    private int topCardRank;
    private int topCardSuit;
    private int card1Rank;
    private int card1Suit;
    private int card2Rank;
    private int card2Suit;
    private int card3Rank;
    private int card3Suit;
    private int card4Rank;
    private int card4Suit;

    private ScoreBreakdown scoreBreakdown;

    // Constructor

    public ScoreFrame(boolean crib, Hand hand) {
        setTitle("Cribbage Assistant");
        setLayout(new BorderLayout());
        initializeElements(crib, hand);
        setBackgrounds();
        addElements();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    // Other Methods

    /**
     * Initializes all the elements in the frame
     * 
     * @param crib A boolean that is true if the frame is opened by crib socrer,
     *             false if the frame is opened by hand scorer
     * @param hand The hand inputted by the user in the hand/crib scorer frame
     */
    private void initializeElements(boolean crib, Hand hand) {
        this.hand = hand;
        this.titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String titleString = crib ? "Crib Calculator:" : "Hand Calculator:";
        this.titleLabel = new JLabel(titleString);
        this.main = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        this.rankSuitLabelPanel = new JPanel();
        this.rankTitle = new JLabel("Rank:");
        this.suitTitle = new JLabel("Suit:");
        this.rankNameLabel = new JLabel("(1-13)");
        this.suitNameLabel = new JLabel("(H,D,C,S)");

        this.topCardRank = hand.getTopCard().getRank();
        this.topCardSuit = hand.getTopCard().getSuit();
        this.card1Rank = hand.getCard(0).getRank();
        this.card1Suit = hand.getCard(0).getSuit();
        this.card2Rank = hand.getCard(1).getRank();
        this.card2Suit = hand.getCard(1).getSuit();
        this.card3Rank = hand.getCard(2).getRank();
        this.card3Suit = hand.getCard(2).getSuit();
        this.card4Rank = hand.getCard(3).getRank();
        this.card4Suit = hand.getCard(3).getSuit();

        this.scoreBreakdown = new ScoreBreakdown(hand);
    }

    /**
     * Adds all the elements to the frame
     */
    private void addElements() {
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        add(mainPanelConfiguration(), BorderLayout.CENTER);
        pack();
    }

    /**
     * Sets the backgrounds of the frame
     */
    private void setBackgrounds() {
        this.titlePanel.setBackground(new Color(0, 0, 0, 75));
        this.main.setBackground(new Color(110, 110, 110));
        this.rankSuitLabelPanel.setBackground(new Color(235, 235, 235));
    }

    /**
     * Creates the main panel containing an information panel, a score panel, and
     * the five cards inputted: a top card and four hand cards
     * 
     * @return A formatted JPanel containing multiple elements
     */
    private JComponent mainPanelConfiguration() {
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 1;
        main.add(rankSuitLabel(), gbc);

        gbc.gridx = 1;
        main.add(makeCardPanel("Top Card:", topCardRank, topCardSuit, 140, 90), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        main.add(makeScorePanel(), gbc);
        gbc.gridheight = 1;

        gbc.gridy = 2;
        gbc.gridx = 0;
        main.add(makeCardPanel("Card 1:", card1Rank, card1Suit, 150, 110), gbc);
        gbc.gridx = 1;
        main.add(makeCardPanel("Card 2:", card2Rank, card2Suit, 150, 110), gbc);
        gbc.gridx = 2;
        main.add(makeCardPanel("Card 3:", card3Rank, card3Suit, 150, 110), gbc);
        gbc.gridx = 3;
        main.add(makeCardPanel("Card 4:", card4Rank, card4Suit, 150, 110), gbc);
        return main;
    }

    /**
     * Formats the rankSuitLabel properly
     * 
     * @return the properly formatted rankSuitLabel JPanel
     */
    private JComponent rankSuitLabel() {
        rankSuitLabelPanel.setLayout(new BoxLayout(rankSuitLabelPanel, BoxLayout.Y_AXIS));
        rankTitle.setFont(rankTitle.getFont().deriveFont(Font.BOLD, 13f));
        suitTitle.setFont(suitTitle.getFont().deriveFont(Font.BOLD, 13f));
        rankSuitLabelPanel.add(rankTitle);
        rankSuitLabelPanel.add(rankNameLabel);
        rankSuitLabelPanel.add(Box.createVerticalStrut(8));
        rankSuitLabelPanel.add(suitTitle);
        rankSuitLabelPanel.add(suitNameLabel);
        rankSuitLabelPanel.setPreferredSize(new Dimension(140, 80));
        return rankSuitLabelPanel;
    }

    /**
     * Creates a JPanel containint a title, rank and suit formatted nicely
     * 
     * @param title The title of the card
     * @param rank  The rank of the card
     * @param suit  The suit of the card
     * @param prefW The preffered width of the panel
     * @param prefH The preffered height of the panel
     * @return A formatted JPanel containing the inputted information
     */
    private JComponent makeCardPanel(String title, int rank, int suit, int prefW,
            int prefH) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(235, 235, 235));
        JLabel lTitle = new JLabel(title);
        lTitle.setFont(lTitle.getFont().deriveFont(Font.BOLD, 13f));
        p.add(lTitle);
        Card c = new Card(rank, suit);
        if (c.isValid()) {
            p.add(Box.createVerticalStrut(4));
            p.add(new JLabel("" + Card.getRankName(rank)));
            p.add(Box.createVerticalStrut(2));
            p.add(new JLabel("of"));
            p.add(Box.createVerticalStrut(2));
            p.add(new JLabel("" + Card.getSuitName(suit)));
        }
        Dimension pref = new Dimension(prefW, prefH);
        p.setPreferredSize(pref);
        p.setMinimumSize(pref);
        return p;
    }

    /**
     * Creates the scoring panel with the scoring events listed
     * 
     * @return The formatted scoring panel
     */
    private JComponent makeScorePanel() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setOpaque(true);
        outer.setBackground(new Color(45, 45, 45));
        outer.setPreferredSize(new Dimension(220, 170));

        JLabel scoreTitle = new JLabel("Score:");
        scoreTitle.setFont(scoreTitle.getFont().deriveFont(Font.BOLD, 16f));
        scoreTitle.setOpaque(true);
        scoreTitle.setBackground(new Color(245, 245, 245));

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBackground(new Color(45, 45, 45));

        JPanel scoringEventsPanel = new JPanel();
        scoringEventsPanel.setLayout(new BoxLayout(scoringEventsPanel, BoxLayout.Y_AXIS));
        scoringEventsPanel.setBackground(new Color(45, 45, 45));

        JPanel finalScorePanel = new JPanel();
        finalScorePanel.setLayout(new FlowLayout());
        finalScorePanel.setBackground(new Color(45, 45, 45));

        if (hand.isValidFourCardHand()) {
            for (String s : scoreBreakdown.getOutput()) {
                JLabel l = new JLabel(s);
                l.setFont(center.getFont().deriveFont(Font.PLAIN, 10f));
                l.setForeground(new Color(245, 245, 245));
                scoringEventsPanel.add(l);
            }
            JLabel finalScoreLabel = new JLabel("Final:" + scoreBreakdown.getFinalScore());
            finalScoreLabel.setForeground(new Color(245, 245, 245));
            finalScorePanel.add(finalScoreLabel);
            System.out.println("Final:" + scoreBreakdown.getFinalScore());
            center.add(scoringEventsPanel, BorderLayout.WEST);
            center.add(finalScorePanel, BorderLayout.CENTER);
        } else {
            JLabel l = new JLabel("Hand is Invalid");
            l.setFont(center.getFont().deriveFont(Font.PLAIN, 10f));
            l.setForeground(new Color(245, 245, 245));
            scoringEventsPanel.add(l);
            center.add(scoringEventsPanel);
        }
        outer.add(scoreTitle, BorderLayout.NORTH);
        outer.add(center, BorderLayout.CENTER);
        return outer;
    }
}
