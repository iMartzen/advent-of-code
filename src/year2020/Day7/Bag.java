package year2020.Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bag {
    String rootBagColor;
    List<String> subBagColor = new ArrayList<>();

    public Bag(String rootBagColor, String subBagString, List<String> input) {

        //setRootBag
        this.rootBagColor = rootBagColor.replace(" bags", "");

        //put subBagColor in list
        if (input.size() > 0 && !subBagString.contains("no other bags")) {
            List<String> subBags = Arrays.asList(subBagString.split(", "));
            for (int i = 0; i < subBags.size(); i++) {
                this.subBagColor.add(subBags.get(i).substring(2).replace( " bags", ""));
            }
        }
    }

    //Does bag contain "shiny gold"?
    public boolean containsBag(String rootBagColor){
        if (rootBagColor.equals(this.rootBagColor)){
            return true;
        }
        for (int i = 0; i < subBagColor.size(); i++){
            if (subBagColor.get(i).contains("shiny gold")){
                return true;
            }
        }
        return false;
    }
}
