package year2020.Day10;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int value;
    List<year2020.Day10.Node> children = new ArrayList<>();

    //WHY?????
    static year2020.Day10.Node ZERO = new year2020.Day10.Node(0);

    //Constructor
    Node(int value) {
        this.value = value;
    }

    void add(int child) {
        this.children.add(new year2020.Day10.Node(child));
    }

    void smartAdd(int child) {
        if (canIBeChild(child)) {
            add(child);
            for (year2020.Day10.Node node : children) {
                node.smartAdd(child);
            }
        } else {
            for (year2020.Day10.Node node : children) {
                node.smartAdd(child);
            }
        }
    }

    boolean canIBeChild(int child) {
        return value + 3 >= child && value != child;
    }

    int calculateRoutes() {

        // FIXME
        return 0;
    }

    public String toString() {
        return value + " " + children;
    }
}