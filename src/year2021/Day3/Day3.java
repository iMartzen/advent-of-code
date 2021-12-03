package year2021.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void Puzzle() throws FileNotFoundException {
        File file = new File("src/year2021/Day3/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lineArray.add(scanner.nextLine());
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        int[] count = new int[lineArray.get(0).length()];
        for (String s : lineArray) {
            for (int j = 0; j < lineArray.get(0).length(); j++) {
                if (s.charAt(j) == '1') {
                    count[j]++;
                }
            }
        }
        for (int j : count) {
            if (j > (lineArray.size() - j)) {
                gamma.append('1');
                epsilon.append('0');
            } else {
                gamma.append('0');
                epsilon.append('1');
            }
        }
        int gammaRate = Integer.parseInt(gamma.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilon.toString(), 2);
        int powerConsumption = gammaRate * epsilonRate;
        System.out.println("Day 3: The power consumption of the submarine is: " + gammaRate + " * " + epsilonRate + " = " + powerConsumption);
    }
}