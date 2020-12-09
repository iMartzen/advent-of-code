package year2020.Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {
    String rootBagColor;
    ArrayList<BagInfo> subBagInfo;

    static Map<String, ArrayList<BagInfo>> bagList = new HashMap<>();

    static class BagInfo {
        public int quantity;
        public String subBagColor;
    }

    Bag(String rootBagColor, String subBagString) {

        this.rootBagColor = rootBagColor.replace(" bags", "");

        ArrayList<BagInfo> bagInformation = new ArrayList<>();

        if (!subBagString.contains("no other bags")) {
            String[] subBags = subBagString.split(", ");
            for (int i = 0; i < subBags.length; i++) {
                BagInfo bagInfo = new BagInfo();
                bagInfo.quantity = Integer.parseInt(subBags[i].substring(0, 1));
                bagInfo.subBagColor = subBags[i].substring(2).replace(" bags", "");
                bagInformation.add(bagInfo);
            }
        }

        this.subBagInfo = bagInformation;
    }

    static boolean containsBag(String bag) {
        for (Bag.BagInfo subBag : bagList.get(bag)) {
            if (subBag.subBagColor.equals("shiny gold")) {
                return true;
            }
        }

        for (Bag.BagInfo subBag : bagList.get(bag)) {
            if (containsBag(subBag.subBagColor)) {
                return true;
            }
        }
        return false;
    }

    static int countBag(String bag) {
        int count = 1;
        List<Bag.BagInfo> goldBag = bagList.get(bag);
        for (Bag.BagInfo subBag : goldBag) {
            count += (subBag.quantity * countBag(subBag.subBagColor));
        }
        return count;
    }
}
