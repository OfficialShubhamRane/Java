package Algorithms.Binary_Search;

import java.util.*;

public class Recursive_binary_search {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int len = list.size();
        int target = 0;
        int first = 0;
        int last = len - 1;
        Recursive_binary_search obj = new Recursive_binary_search();
        obj.binarySearchAlgo(list, first, last, target);
    }

    private void binarySearchAlgo(List<Integer> list, int first, int last, int target) {

        int mid = (first + last) / 2;

        if (list.get(mid) == target) {
            System.out.println("Item Found: " + list.get(mid));
            System.exit(0);
        } else if (list.get(list.size() - 1) == target) {
            System.out.println("Item found: " + list.get(list.size() - 1));
        } else if (list.get(mid) > target) {
            binarySearchAlgo(list, first, mid, target);
        } else if (list.get(mid) < target) {
            binarySearchAlgo(list, mid, last, target);
        }

    }
}
