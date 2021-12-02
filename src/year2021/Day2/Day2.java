package year2021.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void Puzzle() throws FileNotFoundException {
        File file = new File("src/year2021/Day2/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lineArray.add(scanner.nextLine());
        }

        int depth = 0;
        int horizontal = 0;

        for (String s : lineArray) {
            String[] split = s.split(" ");
            String direction = split[0];
            int step = Integer.parseInt(split[1]);
            if (direction.equals("forward")) {
                horizontal = horizontal + step;
            } else if (direction.equals("up")) {
                depth = depth - step;
            } else {
                depth = depth + step;
            }
        }
        System.out.println("Day 2: Multiplied final horizontal position by final depth = " + depth * horizontal);
    }
}

