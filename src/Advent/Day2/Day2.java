package Advent.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2 {

    static Map<Integer, String> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day2/day2.txt"));
        Map<Integer, String> ids = new HashMap<>();
        int count = 0;
        while (sc.hasNext()) {
            ids.put(count++, sc.next());
        }
        return ids;
    }

    static int question1(Map<Integer, String> ids) {
        int twos = 0, threes = 0;
        Map<Character, Integer> occur;
        for (String id : ids.values()) {
            occur = new HashMap<>();
            for (int i = 0; i < id.length(); i++) {
                occur.merge(id.charAt(i), 1, Integer::sum);
            }
            if (occur.containsValue(2)) {
                twos++;
            }
            if (occur.containsValue(3)) {
                threes++;
            }
        }
        return twos * threes;
    }

    static String question2(Map<Integer, String> ids) {
        for (int i = 0; i < ids.size() - 1; i++) {
            a:
            for (int j = i + 1; j < ids.size(); j++) {
                for (int k = 0; k < ids.get(i).length(); k++) {
                    if (ids.get(i).charAt(k) != ids.get(j).charAt(k)) {
                        if (ids.get(i).substring(k + 1)
                                .equals(ids.get(j).substring(k + 1))) {
                            return ids.get(i).substring(0, k) + ids.get(i).substring(k + 1);
                        } else {
                            continue a;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        //long startTime = System.currentTimeMillis();    //Store starting time
        Map<Integer, String> ids = read();
        System.out.println(question1(ids));
        System.out.println(question2(ids));
        //System.out.println(( System.currentTimeMillis() - startTime ));
    }
}
