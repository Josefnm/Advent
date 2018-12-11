package Advent.Day10;

import Advent.Day;
import java.util.ArrayList;

public class Day10 extends Day {

    ArrayList<LightPoint> lights = new ArrayList<>();
    boolean[][] displayGrid;

    public Day10() {
        read();
        question1();
    }

    public void read() {
        String[] s;
        while (input.hasNextLine()) {
            s = input.nextLine().replaceAll("[^\\d-]+", " ").trim().split(" ");
            lights.add(new LightPoint(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])));
        }

    }

    public void question1() {
        int a = 0;
        while (true) {
            lights.forEach(light -> light.tick());
            a++;
            if (lights.stream().mapToInt(e -> e.getY()).max().getAsInt() - lights.stream().mapToInt(e -> e.getY()).min().getAsInt() < 12) {
                int minX = lights.stream().mapToInt(e -> e.getX()).min().getAsInt();
                int minY = lights.stream().mapToInt(e -> e.getY()).min().getAsInt();
                int diffX = lights.stream().mapToInt(e -> e.getX()).max().getAsInt()-minX;
                int diffY = lights.stream().mapToInt(e -> e.getY()).max().getAsInt()-minY;
                
                displayGrid = new boolean[diffX + 1][diffY + 1];
                
                lights.forEach(light-> displayGrid[light.getX() - minX][light.getY() - minY] = true);

                for (int i = 0; i <= diffY; i++) {
                    for (int j = 0; j <= diffX; j++) {
                        System.out.print(displayGrid[j][i] ? "#" : ".");
                    }
                    System.out.println("");
                }
                System.out.println("Q2: "+a);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Day10();
    }
}
