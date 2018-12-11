package Advent.Day07;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day07 extends Day {

    TreeMap<Character, TreeSet<Character>> letterMap;
    ArrayList<Character> result;
    boolean done;
    HashSet< Helper> helpers;

    public Day07() {
        this.done = false;
        read();
        result = new ArrayList<>();
        question1();
        result.forEach(cha -> System.out.print(cha));
        System.out.println("");
        question2();
    }

    public void read() {
        letterMap = new TreeMap<>();
        IntStream.range(65, 91).forEach(i -> letterMap.put((char) i, new TreeSet<>()));
        String s;
        while (input.hasNextLine()) {
            s = input.nextLine();
            letterMap.get(s.charAt(5)).add(s.charAt(36));
        }
    }

    public void question1() {
        //        letterMap.entrySet().stream().filter((t) -> !result.contains(t.getKey())).forEach((t) -> {
        //        });

        //                .entrySet().stream().noneMatch(set -> set.getValue().contains(entry.getKey()));
        //            if (letterMap.entrySet().stream().filter((t) -> !result.contains(t.getKey())).noneMatch(set -> set.getValue().contains(entry.getKey()))) {
        //                result.add(entry.getKey());
        //
        //                question1();
        //
        //            }
        //        });
        letterMap.entrySet()
                .stream()
                .filter((t) -> !result.contains(t.getKey()))
                .forEach(entry -> {
                    if (letterMap.entrySet().stream()
                            .filter((t) -> !result.contains(t.getKey()))
                            .noneMatch(set -> set.getValue().contains(entry.getKey()))) {
                        result.add(entry.getKey());

                        question1();

                    }
                });
//Map<Character, TreeSet<Character>> collect = letterMap.entrySet().stream().filter((t) -> !result.contains(t.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        for (Character entry : collect.keySet()) {
//            if (collect.values().stream().noneMatch(set -> set.contains(entry))) {
//                result.add(entry);
//               // letterMap.remove(entry);
//                question1();
//                return;
//            }
//        }

    }

//    public boolean checkOrder(int a, int b) {
//        return letterMap.get(result.get(a)).contains(result.get(b));
//    }
//
//    public void replace(int i, int j) {
//        result.add(i, result.get(j));
//        result.remove(j + 1);
//    }
//    public void question1() {
//        result = new ArrayList<>(letterMap.keySet());
//        while (!done) {
//            done = true;
//            for (int i = 0; i < 26; i++) {
//                a:
//                for (int j = i + 1; j < 26; j++) {
//                    if (checkOrder(j, i)) {
//                        replace(i, j);
//                        done = false;
//                    } else if (result.get(i) > result.get(j)) {
//                        for (int k = i; k < j; k++) {
//                            if (checkOrder(k, j)) {
//                                continue a;
//                            }
//                        }
//                        replace(i, j);
//                        done = false;
//                    }
//                }
//            }
//        }
//        result.forEach(cha -> System.out.print(cha));
//        System.out.println("");
//    }
    public class Helper {

        Character letter = 0;
        int time = 0;

        public boolean isBusy() {
            return time != 0;
        }

        public void tick() {
            if (time != 0) {
                time--;
            } else {
                letter = 0;
            }
        }

        private void newWork(Character character) {
            this.letter = character;
            this.time = character - 4;
        }
    }

    public Helper getFreeHelper() {
        for (Helper helper : helpers) {
            if (!helper.isBusy()) {
                return helper;
            }
        }
        return null;
    }

    public boolean isValid(Character letter1) {
        return !helpers.stream().allMatch(Helper::isBusy)
                && result.contains(letter1)
                && helpers.stream()
                        .filter(Helper::isBusy)
                        .noneMatch(
                                helper -> letterMap
                                        .get(helper.letter)
                                        .contains(letter1))
                && result.stream()
                        .noneMatch(letter2 -> letterMap.get(letter2).contains(letter1));
    }

    public void question2() {
        helpers = new HashSet<>();
        IntStream.range(0, 5).forEach(i -> helpers.add(new Helper()));
        int counter = 0;
        while (!(result.isEmpty() && helpers.stream().noneMatch(Helper::isBusy))) {
            counter++;
            letterMap.keySet().forEach((letter) -> {
                if (isValid(letter)) {
                    getFreeHelper().newWork(letter);
                    result.remove(letter);
                }
            });
            helpers.forEach(Helper::tick);
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new Day07();
    }
}
//MNOUBYITKXZFHQRJDASGCPEVWL
