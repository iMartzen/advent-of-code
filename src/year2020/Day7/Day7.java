package year2020.Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/year2020/Day7/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();

        while (scanner.hasNext()) {
            input.add(scanner.nextLine().replace("bag,", "bags,").replace("bag.", "bags").replace(".", ""));
        }

        List<Bag> bagList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String[] bags = input.get(i).split(" contain ");
            bagList.add(new Bag(bags[0], bags[1], input));
        }

        long shiny_gold = bagList.stream().filter(bag -> bag.containsBag("shiny gold")).count();

        System.out.println(bagList.get(0).rootBagColor);
        System.out.println(bagList.get(0).subBagColor.get(0));

        System.out.println(shiny_gold);
    }
}
