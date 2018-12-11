package Advent.Day08;

import Advent.Day;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Day08 extends Day {

    ArrayList<Integer> nums1;
    ArrayList<Integer> nums2;

    public Day08() {
        this.nums1 = new ArrayList<>();
        while (input.hasNext()) {
            nums1.add(input.nextInt());
        }
        nums2 = new ArrayList<>(nums1);
        System.out.println(question1(0));
        System.out.println(question2(0));
    }

    public int question1(int index) {
        //fullösning för att få ner det till 1 rad...
        return IntStream.range(0, nums1.get(index))
                .map(x -> question1(index + 2))
                .sum()
                + nums1.subList(index + 2, index + 2 + nums1.get(index + 1))
                        .stream()
                        .mapToInt(Integer::intValue).sum() 
                + IntStream.range(index, index + 2 + nums1.get(index + 1))
                        .reduce(0, (d, e) -> nums1.remove(index) / 1000);
    }

    public int question2(int index) {
        //copypastead kod från lösning 1, snyggar till när jag kommit ikapp med andra uppgifter.
        if (nums2.get(index) == 0) {
            return nums2.subList(index + 2, index + 2 + nums2.get(index + 1)).stream().mapToInt(Integer::intValue).sum() + IntStream.range(index, index + 2 + nums2.get(index + 1)).reduce(0, (d, e) -> nums2.remove(index) / 1000);
        }
        List<Integer> arr=IntStream.range(0, nums2.get(index)).map(x -> question2(index + 2)).boxed().collect(Collectors.toList());

        return nums2.subList(index + 2, index + 2 + nums2.get(index + 1)).stream().mapToInt((value) -> arr.size() >= value && !arr.isEmpty() ? arr.get(value - 1) : 0).sum() + IntStream.range(index, index + 2 + nums2.get(index + 1)).reduce(0, (d, e) -> nums2.remove(index) / 1000);
    }

    public static void main(String[] args) {
        Day08 day08 = new Day08();
    }
}
