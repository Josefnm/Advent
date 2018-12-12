package Advent.Day11;

public class Day11 {

    int serial = 689;
    int size = 300;
    int[][] grid = new int[size][size];

    public String question2() {
        int max = 0;
        String result = "";
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int i = 1; i <= Math.min(30, size - (int) Math.max(x, y)); i++) {
                    int sum = 0;
                    for (int a = 0; a < i; a++) {
                        for (int b = 0; b < i; b++) {
                            sum += grid[x + a][y + b];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                        result = ((x + 1) + "," + (y + 1) + "," + i);
                    }
                }
            }
        }
        return result;
    }

    public String question1() {
        int max =0;
        String result="";
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                grid[x - 1][y - 1] = ((x + 10) * y + serial) * (x + 10) / 100 % 10 - 5;
            }
        }
        for (int x1 = 0; x1 < size - 2; x1++) {
            for (int y1 = 0; y1 < size - 2; y1++) {
                int sum = 0;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        sum += grid[a + x1][b + y1];
                    }
                }
                if (sum > max) {
                    max = sum;
                    result = (x1 + 1)+","+"y1+1";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Day11 d = new Day11();
        System.out.println(d.question1());
        System.out.println(d.question2());
    }

}
