package year2020.Day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day15 {
    public static void Puzzle15() throws FileNotFoundException {
        File file = new File("src/year2020/Day15/input");
        Scanner scanner = new Scanner(file).useDelimiter(",");
        List<Integer> input = new ArrayList<>();

        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }

        int index = 0;
        int last = -1;
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {

            int num = input.get(i);
            index++;

            if (i == input.size() - 1) {
                last = num;
            } else {
                lastSeen.put(num, index);
            }
        }

        while (index < 2020) {
            last = step(last, index, lastSeen);
            index++;
        }

        System.out.println("Day 15: The 2020th number spoken will be: " + last);

        while(index < 30000000)
        {
            last = step(last, index, lastSeen);
            index++;
        }

        System.out.println("Day 15, Part 2: The 30000000th number spoken will be: " + last);

    }

    public static int step(int lastSpoken, int index, Map<Integer, Integer> seenLast) {
        int lastSeenTemp = seenLast.getOrDefault(lastSpoken, -1);
        seenLast.put(lastSpoken, index);
        return lastSeenTemp == -1 ? 0 : (index - lastSeenTemp);
    }
}
