package Advent.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    private final List<int[]> cuts;
    private final HashMap<Integer, Boolean> cloth;

    public Day3() throws FileNotFoundException {
        this.cuts = new ArrayList<>();
        this.cloth = new HashMap<>();
        read();
        findOverlap();
    }

    private void read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day3/day3.txt"));
        sc.useDelimiter("\\D+");
        int[] cut;
        while (sc.hasNext()) {
            cut = new int[5];
            for (int i = 0; i < 5; i++) {
                cut[i] = sc.nextInt();
            }
            cuts.add(cut);
        }
    }

    private void findOverlap() {
        cuts.forEach((cut) -> {
            for (int i = cut[1]; i < cut[1] + cut[3]; i++) {
                for (int j = i * 1000 + cut[2]; j < i * 1000 + cut[2] + cut[4]; j++) {
                    cloth.put(j, (cloth.get(j) != null));
                }
            }
        });
    }

    public long question1() {
        return cloth.entrySet()
                .stream()
                .filter(i -> i.getValue())
                .count();
    }

    public int question2() {
        a:
        for (int[] cut : cuts) {
            for (int i = cut[1]; i < cut[1] + cut[3]; i++) {
                for (int j = i * 1000 + cut[2]; j < i * 1000 + cut[2] + cut[4]; j++) {
                    if (cloth.get(j)) {
                        continue a;
                    }
                }
            }
            return cut[0];
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Day3 d = new Day3();
        System.out.println(d.question1());
        System.out.println(d.question2());
    }
}
