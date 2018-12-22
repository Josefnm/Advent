package Advent.Day13;

public class Cart {

    private int posX;
    private int posY;
    private int directionX;//-1 left, 1 right
    private int directionY;//-1 up, 1 down
    private int turnDirection; //-1 left, 0 forward, 1 right

    public Cart(int x, int y, int direction) {
        this.turnDirection = -1;
        this.posX = x;
        this.posY = y;
        directionX = (direction - 1) * -1 % 2;
        directionY = (direction - 2) % 2;
    }

    public void setDir(int x, int y) {
        directionX = x;
        directionY = y;

    }

    public int getPosX() {
        return posX;
    }

    public int compare() {
        return posY * 1000 + posX;
    }

    public int getPosY() {
        return posY;
    }


    public void setPos(int posX,int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void turn() {
        if (turnDirection != 0) {
            if (directionX != 0) {
                directionY = turnDirection * directionX;
                directionX = 0;
            } else if (directionY != 0) {
                directionX = -turnDirection * directionY;
                directionY = 0;
            }
        }
        setTurnDirection();
    }

    public void setTurnDirection() {
        turnDirection = (turnDirection + 2) % 3 - 1;
    }

    public int getDirX() {
        return directionX;
    }

    public int getDirY() {
        return directionY;
    }
}
