package Advent.Day14;

import java.util.ArrayList;

public final class Day14 {

    ArrayList<Integer> input = new ArrayList<>();
    int total = 170651;
    int elf1 = 0;
    int elf2 = 1;

    public Day14() {
        int[] rara = new int[]{1, 7, 0, 6, 4, 1};
        for (int i : rara) {
            input.add(i);
        }
        question();
    }

    public void question() {
        while (input.size() < total) {
            int recipe = input.get(elf1) + input.get(elf2);
        }

    }

    public static void main(String[] args) {
        Day14 d = new Day14();
    }
}
