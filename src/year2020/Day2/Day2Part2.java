package year2020.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Part2 {
    public static void Puzzle2Part2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2020/Day2/input"));
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(scanner.nextLine());
        }

        int counterValidPassword = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            String[] lines = lineArray.get(i).split(" ");
            String[] numbers = lines[0].split("-");
            int allowed1 = Integer.parseInt(numbers[0]);
            int allowed2 = Integer.parseInt(numbers[1]);
            char character = lines[1].charAt(0);
            String password = lines[2];
            if (password.charAt(allowed1 - 1) == character ^ password.charAt(allowed2 - 1) == character) {
                counterValidPassword++;
            }
        }
        System.out.println("Day 2, Part 2: The number of passwords that are valid according to their policies: " + counterValidPassword);
    }
}
