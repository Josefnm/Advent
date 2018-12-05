package Advent.Day4;

import Advent.Day;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Day4 extends Day {

    private final TreeMap<String, Integer> times;
    private final HashMap<Integer, Guard> guards;

    public Day4() {
        this.guards = new HashMap<>();
        this.times = new TreeMap();
        read();
        guardStats();

    }

    private void read() {
        String s;
        while (sc.hasNextLine()) {
            s = sc.nextLine().replaceAll("[^0-9]", "");
//            System.out.println(s.substring(0, 12));
//            System.out.println(Integer.parseInt(s.substring(12)+0)/10);
            times.put(s.substring(0, 12), Integer.parseInt(s.substring(12) + 0) / 10);
            //LocalDateTime dt=LocalDateTime.parse(s.substring(0, 12),DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        }
    }

    private void guardStats() {
        Guard currentGuard = null;
        for (Iterator<Map.Entry<String, Integer>> it = times.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() > 0) {
                guards.computeIfAbsent(entry.getValue(), t -> new Guard(t));
                currentGuard = guards.get(entry.getValue());
            } else {
                currentGuard.brokeWoke(Integer.parseInt(entry.getKey().substring(10, 12)), Integer.parseInt(it.next().getKey().substring(10, 12)));
            }

        }
    }

    public int question1() {
        Guard maxGuard = null;
        for (Guard guard : guards.values()) {
            if (maxGuard == null || guard.getTotalTimeSlept() > maxGuard.getTotalTimeSlept()) {
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

    public static void main(String[] args) {
        Day4 d = new Day4();
        System.out.println(d.question1());
        System.out.println(d.question2());
    }

}
