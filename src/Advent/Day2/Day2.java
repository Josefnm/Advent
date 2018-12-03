package Advent.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    static List<String> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day2/day2.txt"));
        List<String> ids = new ArrayList<>();
        while (sc.hasNext()) {
            ids.add(sc.next());
        }
        return ids;
    }

    static int question1(List<String> ids) {
        int twos = 0, threes = 0;
        byte[] occur;
        for (String id : ids) {
            occur = new byte[id.length()];
            for (int i = 0; i < id.length(); i++) {
                occur[id.charAt(i) - 97]++;
            }
            boolean two = false, three = false;
            for (byte b : occur) {
                if (b == 2) {
                    two = true;
                } else if (b == 3) {
                    three = true;
                }
            }
            if (two) {
                twos++;
            }
            if (three) {
                threes++;
            }
        }
        return twos * threes;
    }

    static String question2(List<String> ids) {
        for (int i = 0; i < ids.size() - 1; i++) {
            for (int j = i + 1; j < ids.size(); j++) {
                for (int k = 0; k < ids.get(i).length(); k++) {
                    if (ids.get(i).charAt(k) != ids.get(j).charAt(k)
                            && ids.get(i).substring(k + 1)
                                    .equals(ids.get(i).substring(k + 1))) {
                        return ids.get(i).substring(0, k) + ids.get(i).substring(k + 1);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        List<String> ids = read();
        System.out.println(question1(ids));
        System.out.println(question2(ids));
    }
}
