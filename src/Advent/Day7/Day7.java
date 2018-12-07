package Advent.Day7;

import Advent.Day;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Day7 extends Day {

    TreeMap<Character, TreeSet<Character>> letterMap;
    ArrayList<Character> result;
    boolean done;

    public Day7() {
        this.done = false;
        this.letterMap = new TreeMap<>();
        read();
        result = new ArrayList<>(letterMap.keySet());
        question1();
    }

    public void read() {
        String s;
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            letterMap.putIfAbsent(s.charAt(5), new TreeSet<>());
            letterMap.putIfAbsent(s.charAt(36), new TreeSet<>());
            letterMap.get(s.charAt(5)).add(s.charAt(36));
        }
    }

    public boolean checkOrder(int a, int b) {
        return letterMap.get(result.get(a)).contains(result.get(b));
    }

    public void replace(int i, int j) {
        result.add(i, result.get(j));
        result.remove(j + 1);
        done = false;
    }

    public void question1() {

        while (!done) {
            done = true;
            for (int i = 0; i < 26; i++) {
                a:
                for (int j = i + 1; j < 26; j++) {
                    if (checkOrder(j, i)) {
                        replace(i, j);
                    } else if (result.get(i) > result.get(j)) {
                        for (int k = i; k < j; k++) {
                            if (checkOrder(k, j)) {
                                continue a;
                            }
                        }
                        replace(i, j);
                    }
                }
            }
        }
        result.forEach((cha) -> System.out.print(cha));
        System.out.println("");
    }

    public static void main(String[] args) {
        Day7 d = new Day7();
    }
}
//MNOUBYITKXZFHQRJDASGCPEVWL
