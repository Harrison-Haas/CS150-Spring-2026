import javax.swing.*;
import java.awt.*;

public class CounterApp {

    private static int countTotal = 0;
    private int countA = 0;
    private int countB = 0;
    private int countC = 0;


    public CounterApp() {

        JFrame frame = new JFrame("Counter App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");
        JButton buttonC = new JButton("C");
        JLabel labelA = new JLabel("A: 0");
        JLabel labelB = new JLabel("B: 0");
        JLabel labelC = new JLabel("C: 0");
        JLabel labelTot = new JLabel("Total: 0");
        JLabel labelSep = new JLabel(" | ");

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(labelA);
        frame.add(labelSep);
        frame.add(labelB);
        frame.add(labelSep);
        frame.add(labelC);
        frame.add(labelSep);
        frame.add(labelTot);

        buttonA.addActionListener(e -> {
            countTotal++;
            countA++;
            labelA.setText("A: " + countA);
            labelTot.setText("Total: " + countTotal);
        });

        buttonB.addActionListener(e -> {
            countTotal++;
            countB++;
            labelB.setText("B: " + countB);
            labelTot.setText("Total: " + countTotal);
        });

        buttonC.addActionListener(e -> {
            countTotal++;
            countC++;
            labelC.setText("C: " + countC);
            labelTot.setText("Total: " + countTotal);

        });

        frame.setVisible(true);

    }
}