package Advent.Day10;

public class LightPoint {

    private int x;
    private int y;
    private int changeX;
    private int changeY;

    public LightPoint(int x, int y, int changeX, int changeY) {
        this.x = x;
        this.y = y;
        this.changeX = changeX;
        this.changeY = changeY;
    }
    public void tick(){
        x+=changeX;
        y+=changeY;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
