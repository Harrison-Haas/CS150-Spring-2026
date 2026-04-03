package edu.uwec.cribbageassistant.controller;

import javax.swing.*;

import edu.uwec.cribbageassistant.view.CalculationFrame;
import edu.uwec.cribbageassistant.view.InProgress;

import java.awt.*;

/**
 * A JFrame containing four buttons which open different JFrames with cribbage
 * assisting purposes
 * 
 * @author Harrison Haas
 */
public class ModeSelecter extends JFrame {
    
    // Fields

    JPanel titlePanel;
    JPanel grid;
    JPanel eastPanel;
    JPanel westPanel;
    JPanel southPanel;
    JLabel titleLabel;
    JButton discardCalcButton;
    JButton handCalcButton;
    JButton cribCalcButton;
    JButton handGenButton;

    // Constructor

    public ModeSelecter() {
        setTitle("Cribbage Assistant");
        setLayout(new BorderLayout());
        initializeElements();
        setBackgrounds();
        addElements();
        actionListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
    }

    // Other methods

    /**
     * Initializes all the elements in the frame
     */
    private void initializeElements() {
        this.titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.grid = new JPanel(new GridLayout(2, 2, 8, 8));
        this.eastPanel = new JPanel();
        this.westPanel = new JPanel();
        this.southPanel = new JPanel();

        this.titleLabel = new JLabel("Mode Selection:");
        this.discardCalcButton = new JButton("Discard Calculator");
        this.handCalcButton = new JButton("Hand Calculator");
        this.cribCalcButton = new JButton("Crib Calculator");
        this.handGenButton = new JButton("Hand Generator");
    }

    /**
     * Sets the backgrounds of all the elements in the frame
     */
    private void setBackgrounds() {
        this.titlePanel.setBackground(new Color(0, 0, 0, 75));
        this.grid.setBackground(new Color(0, 0, 0, 75));
        this.eastPanel.setBackground(new Color(0, 0, 0, 75));
        this.westPanel.setBackground(new Color(0, 0, 0, 75));
        this.southPanel.setBackground(new Color(0, 0, 0, 75));
        this.discardCalcButton.setBackground(new Color(255, 255, 255, 255));
        this.handCalcButton.setBackground(new Color(255, 255, 255, 255));
        this.cribCalcButton.setBackground(new Color(255, 255, 255, 255));
        this.handGenButton.setBackground(new Color(255, 255, 255, 255));
    }

    /**
     * Adds all the elements into the frame
     */
    private void addElements() {
        titlePanel.add(titleLabel);
        grid.add(discardCalcButton);
        grid.add(handCalcButton);
        grid.add(cribCalcButton);
        grid.add(handGenButton);
        add(titlePanel, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
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
     * Sets the action listeners for all buttons in the frame
     */
    private void actionListeners() {
        discardCalcButton.addActionListener(e -> {
            openFrame(new InProgress("Discard Calculator"));
        });
        handCalcButton.addActionListener(e -> {
            openFrame(new CalculationFrame(false));
        });
        cribCalcButton.addActionListener(e -> {
            openFrame(new CalculationFrame(true));
        });
        handGenButton.addActionListener(e -> {
            openFrame(new InProgress("Random Hand Generator"));

        });
    }
}
