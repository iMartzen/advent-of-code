package year2020.Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day10 {

    public static void Puzzle10() throws FileNotFoundException {

        File file = new File("src/year2020/Day10/input");
        Scanner scanner = new Scanner(file);
        List<Integer> input = new ArrayList<>();

        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }

        List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
        int counterOne = 0;
        int counterThree = 0;

        for (int i = 1; i < sortedList.size(); i++) {
            int firstNumber = sortedList.get(i);
            int secondNumber = sortedList.get(i - 1);
            int offSet = firstNumber - secondNumber;

            if (offSet == 1) {
                counterOne++;
            }
            if (offSet == 3) {
                counterThree++;
            }
        }

        counterOne = counterOne + 1;
        counterThree = counterThree + 1;

        int result = counterOne * counterThree;
        System.out.println("Day 10: The number of 1-jolt differences * 3-jolt differences is: " + result);

    }
}
