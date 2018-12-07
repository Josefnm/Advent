package Advent.Day6;

public class Point {

    private final int x;
    private final int y;
    private boolean done;
    private Point owner;

    public Point(int thisX, int thisY) {
        this.done = false;
        this.x = thisX;
        this.y = thisY;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isEqualDistance(Point newOwner) {
        return Day6.distance(this, newOwner) == Day6.distance(this, owner);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean setOwner(Point newOwner) {
        if (done&&owner!=null && isEqualDistance(newOwner)) {
            this.owner=null;
            return true;
        } else if (done) {
            return true;
        } else {
            this.owner=newOwner;
            this.done = true;
            return false;
        }
    }

    public Point getOwner() {
        return owner;
    }


}
