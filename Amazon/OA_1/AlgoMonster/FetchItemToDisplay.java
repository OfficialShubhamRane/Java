package AlgoMonster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class FetchItemsToDisplay {

    public static List<String> fetchItemsToDisplay(int sortParameter, int sortOrder, int itemsPerPage, int pageNumber, Map<String, int[]> items) {

        // WRITE YOUR BRILLIANT CODE HERE
        ArrayList<String> ordered = new ArrayList<>(items.keySet()); // create a list of item names
        ordered.sort((a, b) -> {

            int res;
            if (sortParameter == 0) { // compare item name alphabetical
                res = a.compareTo(b);
            } else {
                // compare by relevance or price. sortParamter - 1 because subtracting the item name spot
                res = items.get(a)[sortParameter - 1] - items.get(b)[sortParameter - 1];
            }
            return res * (sortOrder == 0 ? 1 : -1); // if reverse order, then * -1
        });

        int startIndex = itemsPerPage * pageNumber;
        return ordered.subList(startIndex, Math.min(startIndex + itemsPerPage, ordered.size()));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sortParameter = Integer.parseInt(scanner.nextLine());
        int sortOrder = Integer.parseInt(scanner.nextLine());
        int itemsPerPage = Integer.parseInt(scanner.nextLine());
        int pageNumber = Integer.parseInt(scanner.nextLine());
        int itemsLength = Integer.parseInt(scanner.nextLine());
        HashMap<String, int[]> items = new HashMap<>();

        for (int i = 0; i < itemsLength; i++) {
            String[] segs = scanner.nextLine().split(" ");
            items.put(segs[0], new int[] { Integer.parseInt(segs[1]), Integer.parseInt(segs[2]) });
        }

        scanner.close();
        List<String> res = fetchItemsToDisplay(sortParameter, sortOrder, itemsPerPage, pageNumber, items);
        System.out.println(String.join(" ", res));
    }
}
