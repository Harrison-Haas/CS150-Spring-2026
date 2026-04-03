package lab2;

import java.awt.*;

public class Shape {
    
    private int x;
    private int y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g){
        // Default Behavior
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

}


