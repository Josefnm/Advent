package Advent.Day09;

public class Marble {

    private final int value;
    private Marble behind;
    private Marble ahead;

    public Marble(int value, Marble behind, Marble ahead) {
        this.value = value;
        this.behind = behind == null ? this : behind;
        this.ahead = ahead == null ? this : ahead;
    }

    public int getValue() {
        return value;
    }

    public Marble getBehind(int i) {
        return i == 1 ? behind : behind.getBehind(i - 1);
    }

    private void setBehind(Marble behind) {
        this.behind = behind;
    }

    private Marble getAhead() {
        return ahead;
    }

    private void setAhead(Marble ahead) {
        this.ahead = ahead;
    }

    public static Marble removeMarble(Marble marble) {
        marble.getBehind(1).setAhead(marble.getAhead());
        marble.getAhead().setBehind(marble.getBehind(1));
        return marble.getAhead();
    }

    public static Marble twoAhead(Marble marble, int round) {
        Marble m1 = marble.getAhead();
        Marble m2 = m1.getAhead();
        Marble newMarble = new Marble(round, m1, m2);
        m1.setAhead(newMarble);
        m2.setBehind(newMarble);
        return newMarble;
    }
}
