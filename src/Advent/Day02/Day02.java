package Advent.Day02;

import Advent.Day;
import java.util.HashMap;
import java.util.Map;

public class Day02 extends Day {

    public Map<Integer, String> read() {
        Map<Integer, String> ids = new HashMap<>();
        int count = 0;
        while (input.hasNext()) {
            ids.put(count++, input.next());
        }
        return ids;
    }

    public int question1(Map<Integer, String> ids) {
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

    public String question2(Map<Integer, String> ids) {
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

    public static void main(String[] args) {
        Day02 d = new Day02();
        Map<Integer, String> ids = d.read();
        System.out.println(d.question1(ids));
        System.out.println(d.question2(ids));

    }
}
