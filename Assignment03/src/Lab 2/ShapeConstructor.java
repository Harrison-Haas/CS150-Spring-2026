import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ShapeConstructor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Frame");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShapeDrawingPanel panel = new ShapeDrawingPanel();

        for (int i = 0; i < 10; i++) {
            panel.addShape(randomShape());
        }

        JButton clearAll = new JButton("Clear All");
        JButton addShape = new JButton("Add Shape");

        clearAll.addActionListener(e -> {
            panel.clearShape();
        });

        addShape.addActionListener(e ->{
            panel.addShape(randomShape());
        });

        frame.add(panel);
        frame.add(clearAll);
        frame.add(addShape);
        frame.pack();
        frame.setVisible(true);
        
        Timer timer = new Timer(500, (ActionEvent e) -> animation(panel));
        timer.setRepeats(true);
        timer.start();
    }

    /**
     * Generates a random shape of a random size at a random point
     * 
     * @return A shape class
     */
    public static Shape randomShape() {
        double shapeDecider = Math.random();

        double xRan = Math.random();
        double yRan = Math.random();
        double dimRan = (Math.random());
        int xMax = 250;
        int yMax = 250;
        int dimMin = 10;
        int dimMax = 75;

        int xVal = (int) (xRan * xMax);
        int yVal = (int) (yRan * yMax);
        int dimVal = (int) ((dimRan * dimMax) + dimMin);

        Shape shape = new Shape(0, 0);
        if (shapeDecider < .33) {
            shape = new Circle(xVal, yVal, dimVal);
        } else if (shapeDecider < .66) {
            shape = new Rectangle(xVal, yVal, dimVal, dimVal);
        } else {
            shape = new Triangle(xVal, yVal, dimVal, dimVal);
        }
        return shape;
    }

    /**
     * Moves all the shapes in a panel by a random number -10 to 10
     * @param panel The panel containing the shapes to be animated
     */
    public static void animation(ShapeDrawingPanel panel) {
        Random r = new Random();
        for (Shape s : panel.getShapes()) {
            int dx = r.nextInt(21) - 10;
            int dy = r.nextInt(21) - 10; 
            s.move(dx, dy);
        }
        panel.repaint();
    }

}
