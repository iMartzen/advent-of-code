package year2020;

import year2020.Day1.Day1;
import year2020.Day2.Day2;
import year2020.Day2.Day2Part2;
import year2020.Day3.Day3;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Advent Of Code 2002");
        Day1.Puzzle1();
        Day2.Puzzle2();
        Day2Part2.Puzzle2Part2();
        Day3.Puzzle3();
    }
}