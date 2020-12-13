package year2020.Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12Part2 {
    public static void Puzzle12Part2() throws FileNotFoundException {
        File file = new File("src/year2020/Day12/input");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next());
        }

        int sx = 0;
        int sy = 0;
        int wx = 10;
        int wy = 1;
        String facingDirection = "E";

        for (int i = 0; i < input.size(); i++) {
            String direction = input.get(i).substring(0, 1);
            int units = Integer.parseInt(input.get(i).substring(1));

            switch (direction) {
                case "N":
                    wy += units;
                    break;
                case "E":
                    wx += units;
                    break;
                case "S":
                    wy -= units;
                    break;
                case "W":
                    wx -= units;
                    break;
                case "L":
                    for (int j = 0; j < units / 90; j++) {
                        int temp = wy;
                        wy = wx;
                        wx = temp * -1;
                    }
                    break;
                case "R":
                    for (int k = 0; k < units / 90; k++) {
                        int temp = wy;
                        wy = wx * -1;
                        wx = temp;
                    }
                    break;
                case "F":
                    switch (facingDirection) {
                        case "N":
                            sy = sy + wy * units;
                            sx = sx + wx * units;
                            break;
                        case "E":
                            sx = sx + wx * units;
                            sy = sy + wy * units;
                            break;
                        case "S":
                            int tempwy = wy * units;
                            int tempwx = wx * units;
                            sy = sy - tempwx;
                            sx = sx + tempwy;
                            break;
                        case "W":
                            tempwy = wy * units;
                            tempwx = wx * units;
                            sx = sx - tempwy;
                            sy = sy + tempwx;
                            break;
                    }
                    break;
            }
        }
        System.out.println("Day 12, Part 2: The Manhattan distance between the location and the ship's starting position is: " + (Math.abs(sx) + Math.abs(sy)));
    }
}
