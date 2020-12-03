package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day1 {
    public static void Puzzle1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Day1/input"));
        ArrayList<Integer> lineArray = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lineArray.add(scanner.nextInt());
        }
        HashSet<Integer> numSet = new HashSet<>();
        int year = 2020;
        boolean next = true;

        for (int i = 0; i < lineArray.size(); i++) {
            int outcome = year - lineArray.get(i);
            if (numSet.contains(outcome)) {
                System.out.println("Day 1: The answer is: " + lineArray.get(i) + " * " + outcome + " = " + lineArray.get(i) * outcome);
            }
            numSet.add(lineArray.get(i));
        }

        for (int i = 0; i < lineArray.size() && next; i++) {
            for (int j = 0; j < lineArray.size() && next; j++) {
                int outcome = year - lineArray.get(i) - lineArray.get(j);
                if (numSet.contains(outcome)) {
                    if (!lineArray.get(i).equals(lineArray.get(j))) {
                        System.out.println("Day 1, Part 2: The answer is: " + lineArray.get(i) + " * " + outcome + " * " + lineArray.get(j) + " = " + lineArray.get(i) * outcome * lineArray.get(j));
                        next = false;
                    }
                }
                numSet.add(lineArray.get(i));
            }
        }
    }
}