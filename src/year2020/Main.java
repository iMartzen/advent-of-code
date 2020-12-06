package year2020;

import year2020.Day1.Day1;
import year2020.Day2.Day2;
import year2020.Day2.Day2Part2;
import year2020.Day3.Day3;
import year2020.Day4.Day4;
import year2020.Day4.Day4Part2;
import year2020.Day6.Day6;
import year2020.Day6.Day6Part2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Advent Of Code 2020");
        Day1.Puzzle1();
        Day2.Puzzle2();
        Day2Part2.Puzzle2Part2();
        Day3.Puzzle3();
        Day4.Puzzle4();
        Day4Part2.Puzzle4Part2();
        Day6.Puzzle6();
        Day6Part2.Puzzle6Part2();
    }
}