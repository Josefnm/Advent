package Advent.Day8;

import Advent.Day;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Day8 extends Day {

    ArrayList<Integer> nums;

    public Day8() {
        this.nums = new ArrayList<>();
        while (scanner.hasNext()) {
            nums.add(scanner.nextInt());
        }
        System.out.println(question1(0));
    }

    public int question1(int a) { 
        //fullösning för att få ner det till 1 rad...
        return IntStream.range(0, nums.get(a)).map(x -> question1(a+2)).sum()+nums.subList(a+2,a+2+nums.get(a+1)).stream().mapToInt(Integer::intValue).sum()+IntStream.range(a, a+2+nums.get(a+1)).reduce(0, (d,e)->nums.remove(a)/1000);
    }

    public static void main(String[] args) {
        new Day8();
    }
} 
