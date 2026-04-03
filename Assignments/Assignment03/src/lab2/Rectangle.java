package lab2;

import java.awt.Graphics;

public class Rectangle extends Shape {
    
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw (Graphics g){
        g.drawRect(this.getX(), this.getY(), this.width, this.height);
    }
    
}
