package year2020.Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13Part2 {
    public static void Puzzle13Part2() throws FileNotFoundException {
        File file = new File("src/year2020/Day13/input");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();

        while (scanner.hasNext()) {
            input.add(scanner.next());
        }

        List<Integer> busIDs = new ArrayList<>();
        for (String id : input.get(1).split(",")) {
            if (id.equals("x"))
                busIDs.add(0);
            else
                busIDs.add(Integer.parseInt(id));
        }

        long step = 1;
        long out = 0;

        for (int i = 0; i < busIDs.size(); i++) {
            int busID = busIDs.get(i);
            if (busID == 0) {
                continue;
            }
            while ((out + i) % busID != 0)
                out += step;

            step *= busID;
        }
        System.out.println("Day 13, Part 2: The earliest timestamp is: " + out);
    }
}
