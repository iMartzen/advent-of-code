package year2020.Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/year2020/Day11/input");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();

        while (scanner.hasNext()) {
            input.add(scanner.next());
        }

        for (String s : input) {
            System.out.println(s);
        }
    }
}
