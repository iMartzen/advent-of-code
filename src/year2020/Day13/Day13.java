package year2020.Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13 {
    public static void Puzzle13() throws FileNotFoundException {
        File file = new File("src/year2020/Day13/input");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();

        while (scanner.hasNext()) {
            input.add(scanner.next());
        }

        int timestamp = Integer.parseInt(input.get(0)); //Long.parseLong(input.get(0));
        List<Integer> busIDs = new ArrayList<>();
        for (String id : input.get(1).split(",")) {
            if (!id.equals("x")) {
                busIDs.add(Integer.parseInt(id));
            }
        }

        int earliestBus = 1;
        int smallest = Integer.MAX_VALUE;

        for (int ids : busIDs) {
            if (timestamp % ids != 0) {
                int ciel = (int) (Math.ceil(timestamp / (double) ids) * ids);
                if (ciel < smallest) {
                    smallest = ciel;
                    earliestBus = ids;
                }
            }
        }

        long waitTime = smallest - timestamp;
        long sum = waitTime * earliestBus;
        System.out.println("Day 13: The earliest bus you can take to the airport multiplied by the number of minutes you'll need tot wait for that bus is: " + sum);
    }
}
