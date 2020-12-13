package year2020.Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12 {
    public static void Puzzle12() throws FileNotFoundException {
        File file = new File("src/year2020/Day12/input");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next());
        }

        int x = 0;
        int y = 0;
        String facingDirection = "E";

        for (String s : input) {
            String direction = s.substring(0, 1);
            int units = Integer.parseInt(s.substring(1));

            switch (direction) {
                case "N":
                    y += units;
                    break;
                case "E":
                    x += units;
                    break;
                case "S":
                    y -= units;
                    break;
                case "W":
                    x -= units;
                    break;
                case "L":
                case "R":
                    facingDirection = rotateDirection(direction, units, facingDirection);
                    break;
                case "F":
                    switch (facingDirection) {
                        case "N":
                            y += units;
                            break;
                        case "E":
                            x += units;
                            break;
                        case "S":
                            y -= units;
                            break;
                        case "W":
                            x -= units;
                            break;
                    }
                    break;
            }
        }
        System.out.println("Day 12: The Manhattan distance between the location and the ship's starting position is: " + (Math.abs(x) + Math.abs(y)));
    }

    static String rotateDirection(String direction, int units, String facingDirection) {

        if(direction.equals("R")) {
            if (facingDirection.equals("N")) {
                if (units == 90) { direction = "E"; }
                if (units == 180) { direction = "S"; }
                if (units == 270) { direction = "W"; }
            }
            if (facingDirection.equals("E")) {
                if (units == 90) { direction = "S"; }
                if (units == 180) { direction = "W"; }
                if (units == 270) { direction = "N"; }
            }
            if (facingDirection.equals("S")) {
                if (units == 90) { direction = "W"; }
                if (units == 180) { direction = "N"; }
                if (units == 270) { direction = "E"; }
            }
            if (facingDirection.equals("W")) {
                if (units == 90) { direction = "N"; }
                if (units == 180) { direction = "E"; }
                if (units == 270) { direction = "S"; }
            }
        }
        if (direction.equals("L")){
            if (facingDirection.equals("N")) {
                if (units == 90) { direction = "W"; }
                if (units == 180) { direction = "S"; }
                if (units == 270) { direction = "E"; }
            }
            if (facingDirection.equals("E")) {
                if (units == 90) { direction = "N"; }
                if (units == 180) { direction = "W"; }
                if (units == 270) { direction = "S"; }
            }
            if (facingDirection.equals("S")) {
                if (units == 90) { direction = "E"; }
                if (units == 180) { direction = "N"; }
                if (units == 270) { direction = "W"; }
            }
            if (facingDirection.equals("W")) {
                if (units == 90) { direction = "S"; }
                if (units == 180) { direction = "E"; }
                if (units == 270) { direction = "N"; }
            }
        }
        return direction;
    }
}
