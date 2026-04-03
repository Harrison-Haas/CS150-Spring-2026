package lab2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeDrawingPanel extends JPanel {
    
    private ArrayList<Shape> shapes;

    public ShapeDrawingPanel(){
        this(new ArrayList<Shape>());
        this.setPreferredSize(new Dimension(400,400));
    }

    public ShapeDrawingPanel(ArrayList<Shape> shapes){
        this.shapes = shapes;
        this.setPreferredSize(new Dimension(400,400));
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        for(Shape s : this.shapes){
            s.draw(g);
        }
    }

    /**
     * Adds a new specified shape to the ArrayList
     * @param s A specifies Shape object
     */
    public void addShape(Shape s){
        this.shapes.add(s);
        repaint();
    }

    /**
     * Clears the ArrayList of any shapes by creating a new ArrayList
     */
    public void clearShape(){
        this.shapes = new ArrayList<Shape>();
        repaint();
    }

    
}
