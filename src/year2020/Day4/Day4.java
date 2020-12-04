package year2020.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void Puzzle4() throws FileNotFoundException {
        File file = new File("src/year2020/Day4/input");
        Scanner scanner = new Scanner(file).useDelimiter("\n\n");
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNext()) {
            lineArray.add(scanner.next());
        }
        String[] validatedFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int counterValidPassports = 0;
        for (int i = 0; i < lineArray.size(); i++) {
            String[] passport = lineArray.get(i).split("\\s");
            int validatedField = 0;
            for (int j = 0; j < passport.length; j++) {
                String field = passport[j].substring(0, 3);
                for (int k = 0; k < validatedFields.length; k++) {
                    if (field.equals(validatedFields[k])) {
                        validatedField++;
                    }
                }
            }
            if (validatedField >= 7) {
                counterValidPassports++;
            }
        }
        System.out.println("Day 4: The number of valid passports are: " + counterValidPassports);
    }
}
