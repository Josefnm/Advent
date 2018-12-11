package Advent.Day09;

import java.util.Arrays;

public final class Day09 {
//418 players; last marble is worth 70769 points

    private final int players = 418;
    private final int rounds = 70769;

    public Day09() {
        System.out.println(questionX(rounds, new long[players]));
        System.out.println(questionX(rounds * 100, new long[players]));
    }

    public long questionX(int rounds, long[] scores) {
        Marble currentMarble = new Marble(0, null, null);
        for (int i = 1; i <= rounds; i++) {
            if (i % 23 != 0) {
                currentMarble = Marble.twoAhead(currentMarble, i);
            } else {
                currentMarble = currentMarble.getBehind(7);
                scores[i % scores.length] += i + currentMarble.getValue();
                currentMarble = Marble.removeMarble(currentMarble);
            }
        }
        return Arrays.stream(scores).max().getAsLong();
    }

    public static void main(String[] args) {
        new Day09();
    }
}
