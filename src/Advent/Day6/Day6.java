package Advent.Day6;

import Advent.Day;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Day6 extends Day {

    HashSet<Point> landings;
    Point[][] ground;
    Point maxArea;

    public Day6() {
        addLandings();
        makeGround();
    }

    public void addLandings() {
        landings = new HashSet<>();
        scanner.useDelimiter("\\D+");
        while (scanner.hasNext()) {
            landings.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
    }

    public void makeGround() {
        maxArea = landings.stream()
                .reduce((i1, i2) -> new Point(Integer.max(i1.getX(), i2.getX() + 1), Integer.max(i1.getY(), i2.getY() + 1)))
                .get();
        ground = new Point[maxArea.getX()][maxArea.getY()];
        for (int i = 0; i < maxArea.getX(); i++) {
            for (int j = 0; j < maxArea.getY(); j++) {
                ground[i][j] = (new Point(i, j));
            }
        }
    }

    public static int distance(Point a, Point b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    public void question2() {
        int result = 0;
        for (Point[] points : ground) {
            for (Point grp : points) {
                int x = landings.stream().map(landing -> distance(grp, landing)).reduce(Integer::sum).get();
                if (x < 10000) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public void question1() {
        boolean allDone = false;
        int i = 0;
        while (!allDone) {
            allDone = true;
            for (Point land : landings) {
                if (!land.isDone()) {
                    boolean done = true;
                    if (i == 0) {
                        done = ground[land.getX()][land.getY()].setOwner(land) && done;
                    }
                    for (int a = 0; a < i; a++) {
                        if (land.getX() + i - a < maxArea.getX() && land.getY() + a < maxArea.getY()) {
                            done = ground[land.getX() + i - a][land.getY() + a].setOwner(land) && done;
                        }
                        if (land.getX() - a >= 0 && land.getY() + i - a < maxArea.getY()) {
                            done = ground[land.getX() - a][land.getY() + i - a].setOwner(land) && done;
                        }
                        if (land.getX() - i + a >= 0 && land.getY() - a >= 0) {
                            done = ground[land.getX() - i + a][land.getY() - a].setOwner(land) && done;
                        }
                        if (land.getX() + a < maxArea.getX() && land.getY() - i + a >= 0) {
                            done = ground[land.getX() + a][land.getY() - i + a].setOwner(land) && done;
                        }
                    }
                    land.setDone(done);
                    allDone = done && allDone;
                }
            }
            i++;
        }

        for (int j = 0; j < maxArea.getX(); j++) {
            landings.remove(ground[j][0].getOwner());
            landings.remove(ground[j][maxArea.getY() - 1].getOwner());
        }
        for (int j = 0; j < maxArea.getY(); j++) {
            landings.remove(ground[0][j].getOwner());
            landings.remove(ground[maxArea.getX() - 1][j].getOwner());
        }

        int x = Arrays.stream(ground)
                .flatMap(Arrays::stream)
                .filter(a -> a.getOwner() != null && landings.contains(a.getOwner()))
                .collect(Collectors.toMap(
                        Point::getOwner,
                        (p) -> 1,
                        (p1, p2) -> p1 + p2,
                        HashMap::new))
                .values()
                .stream()
                .reduce((a, b) -> Math.max(a, b))
                .get();
        System.out.println(x);

    }

    public static void main(String[] args) {
        Day6 d = new Day6();

        d.question2();
        d.question1();

    }
}
