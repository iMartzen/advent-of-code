package year2020.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void Puzzle4Part2() throws FileNotFoundException {

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

                //Validation of birthYear
                if (passport[j].substring(0, 3).matches("byr")) {
                    int birthYear = Integer.parseInt(passport[j].substring(4));
                    if (birthYear >= 1920 && birthYear <= 2002) {
                        validatedField++;
                    }
                }

                //Validation of issueYear
                if (passport[j].substring(0, 3).matches("iyr")) {
                    int issueYear = Integer.parseInt(passport[j].substring(4));
                    if (issueYear >= 2010 && issueYear <= 2020) {
                        validatedField++;
                    }
                }

                //Validation of expirationYear
                if (passport[j].substring(0, 3).matches("eyr")) {
                    int expirationYear = Integer.parseInt(passport[j].substring(4));
                    if (expirationYear >= 2020 && expirationYear <= 2030) {
                        validatedField++;
                    }
                }

                //Validation of height
                if (passport[j].substring(0, 3).matches("hgt") && passport[j].substring(passport[j].length() - 2).matches("cm|in")) {
                    if (passport[j].substring((passport[j].length() - 2)).equals("cm")) {
                        int height = Integer.parseInt(passport[j].substring(4, passport[j].length() - 2));
                        if (height >= 150 && height <= 193)
                            validatedField++;
                    }
                    if (passport[j].substring((passport[j].length() - 2)).equals("in")) {
                        int height = Integer.parseInt(passport[j].substring(4, passport[j].length() - 2));
                        if (height >= 59 && height <= 76)
                            validatedField++;
                    }
                }

                //Validation of hairColor
                if (passport[j].substring(0, 3).matches("hcl") && passport[j].substring(4).startsWith("#")) {
                    if (passport[j].substring(5, 10).matches("[a-z0-9]+") && passport[j].length() != 10) {
                        validatedField++;
                    }
                }

                //Validation of eyeColor
                if (passport[j].substring(0, 3).matches("ecl") && passport[j].substring(passport[j].length() - 3).matches("amb|blu|brn|gry|grn|hzl|oth")) {
                    validatedField++;
                }

                //Validation of passportId
                if (passport[j].substring(0, 3).matches("pid")) {
                    if (passport[j].substring(4).length() == 9 && passport[j].substring(4).matches("[0-9]+")) {
                        validatedField++;
                    }
                }
            }
            if (validatedField >= 7) {
                counterValidPassports++;
            }
        }
        System.out.println("Day 4, Part 2: The number of valid passports with the validations are: " + counterValidPassports);
    }
}
