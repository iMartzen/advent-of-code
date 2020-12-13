package year2020;

import year2020.Day1.Day1;
import year2020.Day10.Day10;
import year2020.Day10.Day10Part2;
import year2020.Day12.Day12;
import year2020.Day12.Day12Part2;
import year2020.Day2.Day2;
import year2020.Day2.Day2Part2;
import year2020.Day3.Day3;
import year2020.Day4.Day4;
import year2020.Day4.Day4Part2;
import year2020.Day5.Day5;
import year2020.Day6.Day6;
import year2020.Day6.Day6Part2;
import year2020.Day7.Day7;
import year2020.Day8.Day8;
import year2020.Day8.Day8Part2;
import year2020.Day9.Day9;

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
        Day5.Puzzle5();
        Day6.Puzzle6();
        Day6Part2.Puzzle6Part2();
        Day7.Puzzle7();
        Day8.Puzzle8();
        Day8Part2.Puzzle8Part2();
        Day9.Puzzle9();
        Day10.Puzzle10();
//        [WIP] Day10Part2.Puzzle10Part2();
//        [WIP] Day11.Puzzle11();
//        [WIP] Day11Part2.Puzzle11Part2();
        Day12.Puzzle12();
        Day12Part2.Puzzle12Part2();
    }
}