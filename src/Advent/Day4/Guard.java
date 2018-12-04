package Advent.Day4;

/**
 *
 * @author Josef
 */
public class Guard {

    private final Integer id;
    private int timeSlept;
    private int tempSlept;
    private int[] sleepCount;

    public Guard(Integer id) {
        this.sleepCount = new int[60];
        this.tempSlept = 0;
        this.id = id;
        this.timeSlept = 0;
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

    public int getTimeSlept() {
        return timeSlept;
    }

    private void addTimeSlept(int timeSlept) {
        this.timeSlept += timeSlept - tempSlept;
    }

    public void sleep(int slept) {
        tempSlept = slept;
    }

    public void woke(int woke) {
        addTimeSlept(woke);
        for (int i = tempSlept; i < woke; i++) {
            sleepCount[i]++;
        }

    }

}
