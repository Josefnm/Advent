package Advent.Day05;

import Advent.Day;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class Day05 extends Day {

    public char[] chars;
    public TreeSet<Integer> counts;

    public Day05() {
        this.counts = new TreeSet<>();
        chars = input.nextLine().toCharArray();
        countAll();
    }

//    public void test() {
//        LinkedList<Character> list = chars.chars().filter(e-> e!='X'&&e!='x')
//                .collect(LinkedList::new,
//                        (result, element) -> {
//                            if (result.size() > 0 && Math.abs(element - result.peek()) == 32) {
//                                result.pop();
//                            } else {
//                                result.push((char)element);
//                            }
//                        }, (r1, r2) -> r1.addAll(r2));
//        System.out.println(list.size());
//
//    }
    private void countAll() {
        for (int i = 'A' - 1; i < 'Z'; i++) {
            Stack<Character> result = new Stack();
            for (int j = 0; j < chars.length; j++) {
                if (!result.empty() && Math.abs(chars[j] - result.peek()) == 32) {
                    result.pop();
                } else if (chars[j] != i && chars[j] != i + 32) {
                    result.push(chars[j]);
                }
            }
            counts.add(result.size());
        }
        System.out.println(counts.last());
        System.out.println(counts.first());
    }

    public static void main(String[] args) {
        Day05 d = new Day05();

    }
}
