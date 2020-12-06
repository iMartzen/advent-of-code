package year2020.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {
    public static void Puzzle5() throws FileNotFoundException {
        File file = new File("src/year2020/Day5/input");
        Scanner scanner = new Scanner(file);
        ArrayList<String> lineArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lineArray.add(scanner.nextLine());
        }
        ArrayList<Integer> seatIDs = new ArrayList<>();
        for (int i = 0; i < lineArray.size(); i++) {
            String rowId = lineArray.get(i).substring(0, 7);
            String columnId = lineArray.get(i).substring(7, 10);
            int calculatedRowId = CalculateRowId(rowId);
            int calculatedColumnId = CalculateColumnId(columnId);
            int tempSeatId = calculatedRowId * 8 + calculatedColumnId;
            seatIDs.add(tempSeatId);
        }
        int maxSeatId = Collections.max(seatIDs);
        int minSeatId = Collections.min(seatIDs);
        int mySeatId = 0;
        for (int j = minSeatId - 1; j < maxSeatId; j++) {
            if (!seatIDs.contains(j) && seatIDs.contains(j - 1) && seatIDs.contains(j + 1)) {
                mySeatId = j;
            }
        }
        System.out.println("Day 5: The highest seat ID on a boarding pass is: " + maxSeatId);
        System.out.println("Day 5, Part 2: My ID of my seat is: " + mySeatId);
    }

    private static int CalculateRowId(String rowId) {
        int start = 0;
        int range = 128;
        for (int i = 0; i < rowId.length(); i++) {
            range /= 2;
            if (rowId.charAt(i) == 'B') {
                start = start + range;
            }
        }
        return start;
    }

    private static int CalculateColumnId(String columnId) {
        int start = 0;
        int range = 8;
        for (int i = 0; i < columnId.length(); i++) {
            range /= 2;
            if (columnId.charAt(i) == 'R') {
                start = start + range;
            }
        }
        return start;
    }
}

