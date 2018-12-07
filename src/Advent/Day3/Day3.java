package Advent.Day3;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day3 extends Day {

    private final List<int[]> claims;
    private final HashMap<Integer, Boolean> cloth;

    public Day3() {
        this.claims = new ArrayList<>();
        this.cloth = new HashMap<>();
        readClaims();
        findOverlap();
    }

    private void readClaims() {
        scanner.useDelimiter("\\D+");
        int[] cut;
        while (scanner.hasNext()) {
            cut = new int[5];
            for (int i = 0; i < 5; i++) {
                cut[i] = scanner.nextInt();
            }
            claims.add(cut);
            
        }
    }

    private void findOverlap() {
        claims.forEach((claim) -> {
            for (int i = claim[1]; i < claim[1] + claim[3]; i++) {
                for (int j = i * 1000 + claim[2]; j < i * 1000 + claim[2] + claim[4]; j++) {
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
        for (int[] claim : claims) {
            for (int i = claim[1]; i < claim[1] + claim[3]; i++) {
                for (int j = i * 1000 + claim[2]; j < i * 1000 + claim[2] + claim[4]; j++) {
                    if (cloth.get(j)) {
                        continue a;
                    }
                }
            }
            return claim[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        Day3 d = new Day3();
        System.out.println(d.question1());
        System.out.println(d.question2());
        System.out.println(234%10);   
    }
}
