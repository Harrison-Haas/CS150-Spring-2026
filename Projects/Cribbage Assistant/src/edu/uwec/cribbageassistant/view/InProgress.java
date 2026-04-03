package edu.uwec.cribbageassistant.view;

import javax.swing.*;
import java.awt.*;

/**
 * Opens a frame with a title passed in the constructor and a message sayint the
 * frame is in progress
 * 
 * @author Harrison Haas
 */
public class InProgress extends JFrame {

    public InProgress(String message) {
        super(message);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 150);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45, 45, 45));
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(message + " is in Progress", SwingConstants.CENTER);
        label.setForeground(new Color(245, 245, 245));
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14f));

        panel.add(label, BorderLayout.CENTER);
        add(panel);
    }
}
