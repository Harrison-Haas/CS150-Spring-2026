package edu.uwec.cribbageassistant.view;
import javax.swing.*;

import edu.uwec.cribbageassistant.controller.ScoreFrame;
import edu.uwec.cribbageassistant.model.Card;
import edu.uwec.cribbageassistant.model.Hand;

import java.awt.*;


/**
 * A Frame that contains ten dropdowns for a user to input a four card cribbage
 * hand with a top card and opens a new Frame that calculates the score of the
 * cribbage hand
 * 
 * @author Harrison Haas
 */

public class CalculationFrame extends JFrame {

    // Fields

    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel main;
    private GridBagConstraints gbc;
    private JPanel rankSuitLabelPanel;
    private JLabel rankTitle;
    private JLabel suitTitle;
    private JLabel rankNameLabel;
    private JLabel suitNameLabel;

    private JComboBox<String> topCardRank;
    private JComboBox<String> topCardSuit;
    private JComboBox<String> card1Rank;
    private JComboBox<String> card1Suit;
    private JComboBox<String> card2Rank;
    private JComboBox<String> card2Suit;
    private JComboBox<String> card3Rank;
    private JComboBox<String> card3Suit;
    private JComboBox<String> card4Rank;
    private JComboBox<String> card4Suit;
    private JButton calcButton;

    // Constructor

    public CalculationFrame(boolean crib) {
        setTitle("Cribbage Assistant");
        setLayout(new BorderLayout());
        initializeElements(crib);
        setBackgrounds();
        addElements();
        AddActionListener(crib);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    // Other Methods
    private void initializeElements(boolean crib) {
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

        this.topCardRank = new JComboBox<String>(rankInputs());
        this.topCardSuit = new JComboBox<String>(suitInputs());
        this.card1Rank = new JComboBox<String>(rankInputs());
        this.card1Suit = new JComboBox<String>(suitInputs());
        this.card2Rank = new JComboBox<String>(rankInputs());
        this.card2Suit = new JComboBox<String>(suitInputs());
        this.card3Rank = new JComboBox<String>(rankInputs());
        this.card3Suit = new JComboBox<String>(suitInputs());
        this.card4Rank = new JComboBox<String>(rankInputs());
        this.card4Suit = new JComboBox<String>(suitInputs());
        this.calcButton = new JButton("Calculate");
    }

    /**
     * Adds all elements to the frame
     */
    private void addElements() {
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        add(mainPanelConfiguration(), BorderLayout.CENTER);
        pack();
    }

    /**
     * Sets the backgrounds of some elements in the frame
     */
    private void setBackgrounds() {
        this.titlePanel.setBackground(new Color(0, 0, 0, 75));
        this.main.setBackground(new Color(110, 110, 110));
        this.rankSuitLabelPanel.setBackground(new Color(235, 235, 235));
    }

    /**
     * Creates an array of strings containing the thirteen ranks of playing cards
     * 
     * @return An array of strings containing the thirteen ranks of playing cards
     */
    private String[] rankInputs() {
        String[] output = new String[13];
        output[0] = "Ace";
        output[1] = "Two";
        output[2] = "Three";
        output[3] = "Four";
        output[4] = "Five";
        output[5] = "Six";
        output[6] = "Seven";
        output[7] = "Eight";
        output[8] = "Nine";
        output[9] = "Ten";
        output[10] = "Jack";
        output[11] = "Queen";
        output[12] = "King";

        return output;
    }

    /**
     * Creates an array of strings containing the four suits of playing cards
     * 
     * @return An array of strings containing the four suits of playing cards
     */
    private String[] suitInputs() {
        String[] output = new String[4];

        output[0] = "Hearts";
        output[1] = "Diamonds";
        output[2] = "Clubs";
        output[3] = "Spades";

        return output;
    }

    /**
     * Creates the main panel containing an information panel, a score panel, and
     * places to input five cards: a top card and four hand cards
     * 
     * @return A formatted JPanel containing multiple elements
     */
    private JComponent mainPanelConfiguration() {
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 0;
        main.add(makeInfoPanel(), gbc);

        gbc.gridy = 1;
        main.add(rankSuitLabel(), gbc);

        gbc.gridx = 1;
        main.add(makeCardInputPanel("Top Card:", this.topCardRank, this.topCardSuit, 140, 90), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        main.add(makeScorePanel(), gbc);
        gbc.gridheight = 1;

        gbc.gridy = 2;
        gbc.gridx = 0;
        main.add(makeCardInputPanel("Card 1", this.card1Rank, this.card1Suit, 150, 110), gbc);
        gbc.gridx = 1;
        main.add(makeCardInputPanel("Card 2", this.card2Rank, this.card2Suit, 150, 110), gbc);
        gbc.gridx = 2;
        main.add(makeCardInputPanel("Card 3", this.card3Rank, this.card3Suit, 150, 110), gbc);
        gbc.gridx = 3;
        main.add(makeCardInputPanel("Card 4", this.card4Rank, this.card4Suit, 150, 110), gbc);
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
     * Creates a panel for the user to input their card
     * 
     * @param prefW The preffered width of the panel
     * @param prefH The preffered height of the panel
     * @return A card formatted with the inputted Strings and dimensions
     */
    private JComponent makeCardInputPanel(String title, JComboBox<String> rankDropDown, JComboBox<String> suitDropDown,
            int prefW, int prefH) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(235, 235, 235));
        JLabel lTitle = new JLabel(title);
        lTitle.setFont(lTitle.getFont().deriveFont(Font.BOLD, 13f));
        p.add(lTitle);
        p.add(Box.createVerticalStrut(4));
        p.add(rankDropDown);
        p.add(Box.createVerticalStrut(2));
        p.add(suitDropDown);

        Dimension pref = new Dimension(prefW, prefH);
        p.setPreferredSize(pref);
        p.setMinimumSize(pref);
        return p;
    }

    /**
     * Creates the scoring panel with the button to calculate
     * 
     * @return The formatted scoring panel with center button
     */
    private JComponent makeScorePanel() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setOpaque(true);
        outer.setBackground(new Color(45, 45, 45));
        outer.setPreferredSize(new Dimension(220, 170));

        JLabel scoreTitle = new JLabel("Score");
        scoreTitle.setFont(scoreTitle.getFont().deriveFont(Font.BOLD, 16f));
        scoreTitle.setOpaque(true);
        scoreTitle.setBackground(new Color(245, 245, 245));
        outer.add(scoreTitle, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        center.add(calcButton);
        outer.add(center, BorderLayout.CENTER);

        return outer;
    }

    /**
     * Creates an information panel providing instructions to the user
     * 
     * @return A JPanel containing instructions for the user
     */
    private JPanel makeInfoPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Instructions:");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 13f));
        JLabel l1 = makeInfoLine("Enter the rank of the card into the top text area.");
        JLabel l2 = makeInfoLine("Enter the suit of the card into the bottom text area.");
        JLabel l3 = makeInfoLine("Accepted rank inputs:");
        JLabel l4 = makeInfoLine("(1-13), (One, Two, ..., Thirteen), (Ace, Jack, Queen, King).");
        JLabel l5 = makeInfoLine("Accepted suit inputs:");
        JLabel l6 = makeInfoLine("(1-4), (H,D,C,S), (Hearts, Diamonds, Clubs, Spades).");
        p.add(title);
        p.add(Box.createVerticalStrut(4));
        p.add(l1);
        p.add(Box.createVerticalStrut(2));
        p.add(l2);
        p.add(Box.createVerticalStrut(2));
        p.add(l3);
        p.add(Box.createVerticalStrut(2));
        p.add(l4);
        p.add(Box.createVerticalStrut(2));
        p.add(l5);
        p.add(Box.createVerticalStrut(2));
        p.add(l6);
        return p;
    }

    /**
     * Makes a JLabel of size 10, plain font out of a specified string and returns
     * the label
     * 
     * @param text The string to be added to the JLabel
     * @return A JLabel of size 10, plain font from the specified string
     */
    private JLabel makeInfoLine(String text) {
        JLabel l = new JLabel(text);
        l.setFont(l.getFont().deriveFont(Font.PLAIN, 10f));
        return l;
    }

    /**
     * Opens a specified JFrame by setting it visible
     * 
     * @param frame The frame to be opened
     */
    private void openFrame(JFrame frame) {
        frame.setVisible(true);
    }

    /**
     * Adds the actionListener to all the buttons in the Class
     * 
     * @param crib A boolean representing whether the hand is a crib or not
     */
    private void AddActionListener(boolean crib) {
        calcButton.addActionListener(e -> {
            Hand h = new Hand(crib);
            h.setTopCard(new Card(topCardRank.getSelectedIndex() + 1, topCardSuit.getSelectedIndex() + 1));
            h.addToHand(new Card(card1Rank.getSelectedIndex() + 1, card1Suit.getSelectedIndex() + 1));
            h.addToHand(new Card(card2Rank.getSelectedIndex() + 1, card2Suit.getSelectedIndex() + 1));
            h.addToHand(new Card(card3Rank.getSelectedIndex() + 1, card3Suit.getSelectedIndex() + 1));
            h.addToHand(new Card(card4Rank.getSelectedIndex() + 1, card4Suit.getSelectedIndex() + 1));
            openFrame(new ScoreFrame(crib, h));
        });
    }

}
