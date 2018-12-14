package Advent.Day13;

public class Cart {

    private int x;
    private int y;
    private char direction;
    private int turnDirection; //-1 left, 0 forward, 1 left
    static char [] DIRS=new char[]{'>','^','<','v'};

    public Cart(int x, int y, char direction) {
        this.turnDirection = 0;
        this.x = x;
        this.y = y;
        this.direction = direction; //0 right, 1 up, 2 left, 3 dowm
    }

    public int getX() {
        return x;
    }

    public int order() {
        return y * 1000 + x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public int getTurnDirection() {
        return turnDirection;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setTurnDirection() {
        turnDirection = (turnDirection+1) % 3 ;
    }
}
