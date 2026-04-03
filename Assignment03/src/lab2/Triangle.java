package lab2;

import java.awt.Graphics;

public class Triangle extends Shape {
    
    private int base;
    private int height;

    public Triangle(int x, int y, int base, int height){
        super(x, y);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw (Graphics g){
        int[] xPoints = {this.getX(), this.getX()+base, this.getX()+(base/2)};
        int[] yPoints = {getY(), getY(), getY()-height};
        g.drawPolygon(xPoints, yPoints, 3);
    }
    
}