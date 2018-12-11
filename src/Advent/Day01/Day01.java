package Advent.Day01;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashSet;

public class Day01 extends Day {

    ArrayList<Integer> freqList;

    public void read() {
        freqList = new ArrayList<>();
        while (input.hasNext()) {
            freqList.add(input.nextInt());
        }
    }

    public int question1(ArrayList<Integer> freqList) {
        return freqList.stream().mapToInt(Integer::intValue).sum();
    }

    public int question2(ArrayList<Integer> freqList) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, count = 0;
        while (set.add(sum += freqList.get(count++ % freqList.size())));
        return sum;
        //61126
    }

    public static void main(String[] args) {
        Day01 d = new Day01();
        d.read();
        System.out.println(d.question1(d.freqList));
        System.out.println(d.question2(d.freqList));

    }

}
