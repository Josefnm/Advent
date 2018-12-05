package Advent.Day4;

/**
 *
 * @author Josef
 */
public class Guard {

    private final Integer id;
    private int totalTimeSlept;
    private int tempSlept;
    private int[] sleepCount;

    public Guard(Integer id) {
        this.sleepCount = new int[60];
        this.tempSlept = 0;
        this.id = id;
        this.totalTimeSlept = 0;
    }

    public int getMaxMinute() {
        int iMax = 0;
        int max = 0;
        for (int i = 0; i < 60; i++) {
            if (sleepCount[i] > max) {
                max = sleepCount[i];
                iMax = i;
            }
        }
        return iMax;
    }

    public int getMaxCount() {

        int max = 0;
        for (int i = 0; i < 60; i++) {
            if (sleepCount[i] > max) {
                max = sleepCount[i];
            }
        }
        return max;
    }

    public Integer getId() {
        return id;
    }

    public int getTotalTimeSlept() {
        return totalTimeSlept;
    }

    public void brokeWoke(int broke, int woke) {
        this.totalTimeSlept += woke - broke;
        for (int i = broke; i < woke; i++) {
            sleepCount[i]++;
        }
    }
}
