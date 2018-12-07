package Advent.Day1;

import Advent.Day;
import java.util.ArrayList;
import java.util.HashSet;

public class Day1 extends Day {

     public ArrayList<Integer> read()  {
        
        ArrayList<Integer> freqList = new ArrayList<>();
        while (scanner.hasNext()) {
            freqList.add(scanner.nextInt());
        }
        return freqList;
    }

     public void question1(ArrayList<Integer> freqList) {
        System.out.println(freqList.stream().mapToInt(Integer::intValue).sum());
    }

     public void question2(ArrayList<Integer> freqList) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, count = -1;
        while(set.size()==++count) {
            set.add(sum+=freqList.get(count%freqList.size()));
        }
        System.out.println(sum);
        
    }

    public static void main(String[] args)  {
        Day1 d=new Day1();
        ArrayList<Integer> freqList = d.read();
        d.question1(freqList);
        d.question2(freqList);

    }

}
