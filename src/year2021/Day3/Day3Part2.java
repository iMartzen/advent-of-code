package year2021.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {
    public static void Puzzle() throws FileNotFoundException {
        File file = new File("src/year2021/Day3/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lineArray.add(scanner.nextLine());
        }
        ArrayList<String> og = new ArrayList<>(lineArray);
        ArrayList<String> co2 = new ArrayList<>(lineArray);
        for (int i = 0; i < og.get(0).length(); i++) {
            if (og.size() == 1) break;
            int one = 0;
            for (String s : og) if (s.charAt(i) == '1') one++;
            boolean ones = one >= (og.size() - one);
            for (int j = 0; j < og.size(); j++) {
                if ((ones && og.get(j).charAt(i) == '0') || (!ones && og.get(j).charAt(i) == '1')) {
                    og.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < co2.get(0).length(); i++) {
            if (co2.size() == 1) break;
            int one = 0;
            for (String s : co2) if (s.charAt(i) == '1') one++;
            boolean ones = one >= (co2.size() - one);
            for (int j = 0; j < co2.size(); j++) {
                if ((ones && co2.get(j).charAt(i) == '1') || (!ones && co2.get(j).charAt(i) == '0')) {
                    co2.remove(j);
                    j--;
                }
            }
        }
        int ogRate = Integer.parseInt(og.get(0), 2);
        int co2Rate = Integer.parseInt(co2.get(0), 2);
        int lifeSupport = (Integer.parseInt(og.get(0), 2) * Integer.parseInt(co2.get(0), 2));
        System.out.println("Day 3, Part 2: The life support rating of the submarine is: " + ogRate + " * " + co2Rate + " = " + lifeSupport);
    }
}