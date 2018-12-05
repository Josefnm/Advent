package Advent.Day5;

import Advent.Day;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day5 extends Day {

    public List<Character> chars;

    TreeSet<Integer> counts;

    public Day5() {
        this.counts = new TreeSet<>();
        chars = sc.nextLine().chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        
    }

    public void testAll() {
        for (int i = 'a'-1; i < 'z'; i++) {
            List<Character> tempChars = new ArrayList<>(chars);
            int j = 0;
            while (j < tempChars.size() - 1) {
                if (32 == Math.abs(tempChars.get(j) - tempChars.get(j + 1))) {
                    tempChars.remove(j);
                    tempChars.remove(j);
                    j = j - 1 > 0 ? j - 1 : 0;
                } else if (tempChars.get(j) == i || tempChars.get(j) == i + 32) {
                    tempChars.remove(j);
                    j = j - 1 > 0 ? j - 1 : 0;
                } else {
                    j++;
                }
            }
            counts.add(tempChars.size());
        }
    }

    public static void main(String[] args) {
        Day5 d = new Day5();
        d.testAll();
        System.out.println(d.counts.last());
        System.out.println(d.counts.first());
    }
}
