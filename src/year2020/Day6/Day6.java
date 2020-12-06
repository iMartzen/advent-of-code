package year2020.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6 {
    public static void Puzzle6() throws FileNotFoundException {
        File file = new File("src/year2020/Day6/input");
        Scanner scanner = new Scanner(file).useDelimiter("\n\n");
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(scanner.next());
        }
        int sameFieldAnswer = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            String answersPerGroup = lineArray.get(i).replace("\n", "");
            long collect = Arrays.stream(answersPerGroup.split("")).distinct().count();
            sameFieldAnswer += collect;
        }
        System.out.println("Day 6: The sum of the questions anyone answered with 'YES' are: " + sameFieldAnswer);
    }
}
