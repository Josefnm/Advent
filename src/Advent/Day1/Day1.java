package Advent.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day1 {

    static ArrayList<Integer> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day1/day1.txt"));
        ArrayList<Integer> freqList = new ArrayList<>();
        while (sc.hasNext()) {
            freqList.add(sc.nextInt());
        }
        return freqList;
    }

    static void question1(ArrayList<Integer> freqList) {
        System.out.println(freqList.stream().mapToInt(Integer::intValue).sum());
    }

    static void question2(ArrayList<Integer> freqList) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, count = -1;
        while(set.size()==++count) {
            set.add(sum+=freqList.get(count%freqList.size()));
        }
        System.out.println(count/freqList.size());
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> freqList = read();
        question1(freqList);
        question2(freqList);

    }

}
