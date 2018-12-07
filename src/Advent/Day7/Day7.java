package Advent.Day7;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Day7 extends Day {

    TreeMap<Character, TreeSet<Character>> letterMap;

    public Day7() {
        this.letterMap = new TreeMap<>();
        read();
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

    public void question1() {
        ArrayList<Character> arr = new ArrayList<>(letterMap.keySet());
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < 26; i++) {
                for (int j = i + 1; j < 26; j++) {
                    boolean replace = false;
                    if (letterMap.get(arr.get(j)).contains(arr.get(i))) {
                        replace = true;
                    } else if (i != 25 && arr.get(i) > arr.get(j)) {
                        replace = true;
                        for (int k = i; k < j + 1; k++) {
                            if (letterMap.get(arr.get(k)).contains(arr.get(j))) {
                                replace = false;
                            }
                        }
                    }
                    if (replace) {
                        arr.add(i, arr.get(j));
                        arr.remove(j + 1);
                        done = false;
                    }
                }
            }
        }
        System.out.println(arr.toString().replace(", ", ""));
    }

    public static void main(String[] args) {
        Day7 d = new Day7();

    }

}
//MOUBZFRYTXJNDIKQAHSGCPEVWL
//MOUBZFRYTXJNDIKQAHSGCPEVWL
//MNOUBYITKXZFHQRJDASGCPEVWL
//MNOUBYITKXZFHQRJDASGCPEVWL
