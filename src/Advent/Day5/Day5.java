package Advent.Day5;

import Advent.Day;
import java.util.LinkedList;
import java.util.TreeSet;

public class Day5 extends Day {

    public char[] chars;
    TreeSet<Integer> counts;

    public Day5() {
        this.counts = new TreeSet<>();
        chars = sc.nextLine().toCharArray();
        countAll();
    }

    public void countAll() {
        for (int i = 'A' - 1; i < 'Z'; i++) {
            LinkedList<Character> result = new LinkedList<>();
            for (int j = 1; j < chars.length; j++) {
                if (result.size() > 0 && Math.abs(chars[j] - result.getLast()) == 32) {
                    result.removeLast();
                } else if (chars[j] != i && chars[j] != i + 32) {
                    result.add(chars[j]);
                }
            }
            counts.add(result.size());
        }
    }

    public static void main(String[] args) {
        Day5 d = new Day5();
        System.out.println(d.counts.last());
        System.out.println(d.counts.first());
    }
}
