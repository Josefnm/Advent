package Advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day {

    public Scanner scanner;

    public Day() {
        try {
            scanner = new Scanner(new File("src/Advent/" + this.getClass().getSimpleName() + "/input.txt"));
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
