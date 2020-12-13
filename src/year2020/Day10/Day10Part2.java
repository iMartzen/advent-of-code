package year2020.Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day10Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/year2020/Day10/input");
        Scanner scanner = new Scanner(file);
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }

        //Sortedlist
        List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
        System.out.println("This is the sorted list: " + sortedList);

        //Backup
        sortedList.forEach(node -> Node.ZERO.smartAdd(node));
//        System.out.println("node : " + Node.ZERO);
    }
}
