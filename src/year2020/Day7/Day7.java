package year2020.Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/year2020/Day7/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine().replace("bag,", "bags,").replace("bag.", "bags").replace(".", ""));
        }

        int countContainBag = 0;
        int countQuantityBag = 0;

        for (String s : input) {
            String[] bags = s.split(" contain ");
            Bag bag = new Bag(bags[0], bags[1]);
            Bag.bagList.put(bag.rootBagColor, bag.subBagInfo);
        }

        for (String bag : Bag.bagList.keySet()) {
            if (Bag.containsBag(bag)) {
                countContainBag++;
            }
        }

        for (String bag : Bag.bagList.keySet()) {
            countQuantityBag = Bag.countBag("shiny gold") - 1;
        }


        System.out.println("Day 7: The numbers of bag colors contain at least one shiny gold bag is: " + countContainBag);
        System.out.println("Day 7, Part 2: The total of individuals bags that are required inside the shiny gold bag are: " + countQuantityBag);

    }
}