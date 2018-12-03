package Advent.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    static List<int[]> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day3/day3.txt"));
        sc.useDelimiter("\\D+");
        List<int[]> cuts = new ArrayList<>();
        int[] cut;
        while (sc.hasNext()) {
            cut = new int[5];
            for (int i = 0; i < 5; i++) {
                cut[i] = sc.nextInt();
            }
            cuts.add(cut);
        }
        return cuts;
    }

    static int[][] findOverlap(List<int[]> cuts) {
        int[][] overlap = new int[1000][1000];
        cuts.forEach(cut -> {
            for (int i = 0; i < cut[3]; i++) {
                for (int j = 0; j < cut[4]; j++) {
                    overlap[i + cut[1]][j + cut[2]]++;
                }
            }
        });
        return overlap;
    }

    static long question1(int[][] overlap) {
        return Arrays.stream(overlap)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i > 1)
                .count();
    }

    static int question2(int[][] overlap, List<int[]> cuts) {
        a:
        for (int[] cut : cuts) {
            for (int i = 0; i < cut[3]; i++) {
                for (int j = 0; j < cut[4]; j++) {
                    if (overlap[i + cut[1]][j + cut[2]] != 1) {
                        continue a;
                    }
                }
            }
            return cut[0];
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        List<int[]> cuts = read();
        int[][] overlap = findOverlap(cuts);
        System.out.println(question1(overlap));
        System.out.println(question2(overlap, cuts));
    }
}
