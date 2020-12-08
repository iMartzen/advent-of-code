package year2020.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day8Part2 {
    public static void Puzzle8Part2() throws FileNotFoundException {
        File file = new File("src/year2020/Day8/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }

        for (int i = 0; i < input.size(); i++) {
            List<String> copyInput = new ArrayList<>();
            copyInput.addAll(input);

            if (copyInput.get(i).contains("jmp")) {
                copyInput.set(i, copyInput.get(i).replace("jmp", "nop"));

                int accumulator = checkHasInfiniteLoop(copyInput);
                if (accumulator != 0) {
                    System.out.println("Day 8, Part 2: The value of the accumulator is: " + accumulator);
                }
            }
        }
    }

    private static int checkHasInfiniteLoop(List<String> input) {
        int accumulator = 0;
        int currentLineIndex = 0;
        List<Integer> executeCounter = new ArrayList<>(Collections.nCopies(input.size(), 0));

        while (currentLineIndex < input.size()) {

            String move = input.get(currentLineIndex).substring(0, 3);
            int step = Integer.parseInt(input.get(currentLineIndex).substring(4));

            if (executeCounter.get(currentLineIndex).equals(1)) {
                return 0;
            }
            executeCounter.set(currentLineIndex, 1);

            if (move.equals("acc")) {
                accumulator += step;
                currentLineIndex++;
            } else if (move.equals("jmp")) {
                currentLineIndex += step;
            } else if (move.equals("nop")) {
                currentLineIndex++;
            }
        }
        return accumulator;
    }
}
