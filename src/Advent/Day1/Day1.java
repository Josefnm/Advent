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
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        return list;
    }

    static void question1(ArrayList<Integer> list) {
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }

    static void question2(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, count = -1;
        while(set.size()==++count) {
            set.add(sum+=list.get(count%list.size()));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = read();
        question1(list);
        question2(list);

    }

}
