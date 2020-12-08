package year2020.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day8 {
    public static void Puzzle8() throws FileNotFoundException {
        File file = new File("src/year2020/Day8/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }

        long accumulator = 0;
        int currentLineIndex = 0;
        List<Integer> executeCounter = new ArrayList<>(Collections.nCopies(input.size(), 0));

        while (currentLineIndex < input.size()) {

            String move = input.get(currentLineIndex).substring(0, 3);
            int step = Integer.parseInt(input.get(currentLineIndex).substring(4));

            if (executeCounter.get(currentLineIndex).equals(1)) {
                break;
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
        System.out.println("Day 8: The value of the accumulator is: " + accumulator);
    }
}
