package Advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day {

    public Scanner input;

    public Day() {
        try {
            input = new Scanner(new File("src/Advent/" + this.getClass().getSimpleName() + "/input.txt"));
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
