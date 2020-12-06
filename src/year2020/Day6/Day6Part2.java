package year2020.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6Part2 {
    public static void Puzzle6Part2() throws FileNotFoundException {
        File file = new File("src/year2020/Day6/input");
        Scanner scanner = new Scanner(file).useDelimiter("\n\n");
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(scanner.next());
        }
        int sameFieldAnswer = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            String[] answersPerPerson = lineArray.get(i).split("\n");
            String answersPerGroup = lineArray.get(i).replace("\n", "");
            long count = Arrays.stream(answersPerGroup.split(""))
                    .distinct()
                    .filter(character -> allContainsChar(answersPerPerson, character))
                    .count();
            sameFieldAnswer += count;
        }
        System.out.println("Day 6, Part 2: The sum of the questions everyone answered 'YES' are: " + sameFieldAnswer);
    }

    public static boolean allContainsChar(String[] group, String character) {
        for (String person : group) {
            if (!person.contains(character)) {
                return false;
            }
        }
        return true;
    }
}
