package year2020.Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {
    public static void puzzle9() throws FileNotFoundException {
        File file = new File("src/year2020/Day9/input");
        Scanner scanner = new Scanner(file);

        //create input
        List<Long> input = new ArrayList<>();

        //fill input
        while (scanner.hasNextLong()) {
            input.add(scanner.nextLong());
        }

        //create preamble
        for (int i = 25; i < input.size(); i++) {
            List<Long> preamble = input.subList(i - 25, i);
            long nextNumber = input.get(i);
            if (!isValid(preamble, nextNumber)) {
                System.out.println("Day 9: The first number that does not have the property is: " + nextNumber);
                decipher(input, nextNumber);
            }
        }
    }

    private static boolean isValid(List<Long> preamble, long nextNumber) {
        long previousNumber1 = 0;
        long previousNumber2 = 0;

        for (int i = 0; i < preamble.size(); i++) {
            previousNumber1 = preamble.get(i);
            for (int j = 1; j < preamble.size(); j++) {
                previousNumber2 = preamble.get(j);
                if (previousNumber1 != previousNumber2) {
                    long sum = previousNumber1 + previousNumber2;
                    if (sum == nextNumber) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean decipher(List<Long> input, long nextNumber) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                long sum = 0;
                long smallNumber = 0;
                long largeNumber = nextNumber;
                for (int k = i; k <= j; k++) {
                    long number = input.get(k);
                    sum += number;
                    if (number > smallNumber) {
                        smallNumber = number;
                    } else if (number < largeNumber)
                        largeNumber = number;
                }
                if (sum == nextNumber) {
                    long answer = smallNumber + largeNumber;
                    System.out.println("Day 9, Part 2: The encryption weakness in XMAS-encrypted list is: " + answer);
                    return true;
                }
            }
        }
        return false;
    }
}



