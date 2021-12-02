package year2021.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {
    public static void Puzzle() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2021/Day1/input"));
        ArrayList<Integer> lineArray = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lineArray.add(scanner.nextInt());
        }
        int increased = 0;
        for (int i = 0; i < lineArray.size() - 3; i++) {
            int currentnumber = lineArray.get(i) + lineArray.get(i + 1) + lineArray.get(i + 2);
            int comingnumber = lineArray.get(i + 1) + lineArray.get(i + 2) + lineArray.get(i + 3);
            if (comingnumber > currentnumber) {
                increased++;
            }
        }
        System.out.println("Day 1, Part 2: This is how many sums are larger than the previous sum: " + increased);
    }
}