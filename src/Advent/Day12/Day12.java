package Advent.Day12;

import Advent.Day;
import java.util.HashMap;

public final class Day12 extends Day {

    String plants;
    HashMap<String, Character> rules;

    public Day12() {
        this.rules = new HashMap<>();
        read();
        question(plants, 20);
        question(plants, 50000000000L);
    }

    public void read() {
        plants = input.nextLine().substring(15);
        input.nextLine();
        while (input.hasNextLine()) {
            String s = input.nextLine();
            rules.put(s.substring(0, 5), s.charAt(9));
        }
    }

    public void question(String plants, long round) {
        long plant0 = -5;
        plants = "....." + plants + "...";
        for (long j = 0; j < round; j++) {
            String tempPlants = "";
            for (int i = 0; i < plants.length() - 4; i++) {
                tempPlants += rules.get(plants.substring(i, i + 5));
            }
            tempPlants = ".." + tempPlants + "...";
            if (plants.equals(tempPlants.substring(1))) {
                plant0 += round - j;
                break;
            }
            plants = tempPlants;
        }
        long numbers = 0L;
        for (int i = 0; i < plants.length(); i++) {
            if (plants.charAt(i) == '#') {
                numbers += plant0;
            }
            plant0++;
        }
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        Day12 d = new Day12();
    }

}
