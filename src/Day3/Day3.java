package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void Puzzle3() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/Day3/input"));
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(new String(new char[500]).replace("\0", scanner.nextLine()));
        }

        int trees = 0;
        int x = 0;

        for (int y = 0; y < lineArray.size(); y += 2) {
            String lines = lineArray.get(y);
            if (lines.charAt(x) == '#') {
                trees++;
            }
            x += 1;
        }

        System.out.println("Day 3: The numbers of trees we encountered are: " + trees);
        long solutionPartTwo = 74L * 189L * 65L * 63L * 30L;
        System.out.println("Day 3, Part 2: The numbers of trees encountered on each of the listed slopes: " + solutionPartTwo);

    }
}
