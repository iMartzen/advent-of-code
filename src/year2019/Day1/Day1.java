package year2019.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2019/Day1/input"));
        ArrayList<Integer> lineArray = new ArrayList<>();
        while (scanner.hasNextInt()) {
            lineArray.add(scanner.nextInt());
        }
        int fuelNeeded = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            int operationOne = lineArray.get(i) / 3;
            int operationTwo = operationOne - 2;
            fuelNeeded += operationTwo;
        }
        System.out.println("Day 1: The answer of the total needed fuel is: " + fuelNeeded);
    }
}