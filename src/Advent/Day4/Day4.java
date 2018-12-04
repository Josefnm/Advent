package Advent.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Day4 {

    private final TreeMap<String, String> list;
    private final HashMap<Integer, Guard> guards;

    public Day4() throws FileNotFoundException {
        this.guards = new HashMap<>();
        this.list = new TreeMap();
        read();
        guardStats();
    }

    private void read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Advent/Day4/day4.txt"));
        String s;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            list.put(s.substring(5, 17).replaceAll("[^0-9]", ""), s.substring(25));
        }
    }

    private void guardStats() {
        Guard currentGuard = null;
        for (Map.Entry<String, String> entry : list.entrySet()) {
            switch (entry.getValue().charAt(0)) {
                case '#':
                    Integer s = Integer.parseInt(entry.getValue().replaceAll("[^0-9]", ""));
                    guards.computeIfAbsent(s, t -> new Guard(t));
                    currentGuard = guards.get(s);
                    break;
                case 'a':
                    currentGuard.sleep(Integer.parseInt(entry.getKey().substring(6, 8)));
                    break;
                case 'u':
                    currentGuard.woke(Integer.parseInt(entry.getKey().substring(6, 8)));
                    break;
            }
        }
    }

    public int question1() {
        Guard maxGuard = null;
        for (Guard guard : guards.values()) {
            if (maxGuard == null || guard.getTimeSlept() > maxGuard.getTimeSlept()) {
                maxGuard = guard;
            }
        }
        return maxGuard.getMaxMinute() * maxGuard.getId();
    }

    public int question2() {
        int id = 0;
        int max = 0;
        for (Guard guard : guards.values()) {
            int x = guard.getMaxCount();
            if (x > max) {
                id = guard.getId();
                max = x;
            }
        }
        return id * guards.get(id).getMaxMinute();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day4 d = new Day4();
        System.out.println(d.question1());
        System.out.println(d.question2());
    }

}
