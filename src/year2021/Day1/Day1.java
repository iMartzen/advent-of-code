package year2021.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void Puzzle1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2021/Day1/input"));
        ArrayList<Integer> lineArray = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lineArray.add(scanner.nextInt());
        }
        int increased = 0;
        for (int i = 0; i < lineArray.size() - 1; i++) {
            int currentnumber = lineArray.get(i);
            int comingnumber = lineArray.get(i + 1);
            if (comingnumber > currentnumber) {
                increased++;
            }
        }
        System.out.println("Day 1: The answer is: " + increased);
    }
}