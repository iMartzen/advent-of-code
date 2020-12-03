package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void Puzzle2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Day2/input"));
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(scanner.nextLine());
        }
        int counterValidPassword = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            String[] lines = lineArray.get(i).split(" ");
            String[] numbers = lines[0].split("-");
            int minValue = Integer.parseInt(numbers[0]);
            int maxValue = Integer.parseInt(numbers[1]);
            char character = lines[1].charAt(0);
            String password = lines[2];
            long count = password.chars().filter(ch -> ch == character).count();
            if (count >= minValue && count <= maxValue) {
                counterValidPassword++;
            }
        }
        System.out.println("Day 2: The number of passwords that are valid according to their policies: " + counterValidPassword);
    }
}
