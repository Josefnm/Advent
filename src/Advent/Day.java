package Advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Day {

    public Scanner sc;

    public Day() {
        try {
            sc = new Scanner(new File("src/Advent/" + this.getClass().getSimpleName() + "/input.txt"));
        } catch (FileNotFoundException ex) {
            sc = null;
            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
