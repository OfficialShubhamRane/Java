package Algorithms.Binary_Search;

import java.util.*;

class BinarySearch {

    private void binarySearchAlgo(List<Integer> list, int len, int target) {

        int first = 0;
        int last = len - 1;

        if (list.get(first) == target) {
            System.out.println("Item found: " + list.get(first));
        } else if (list.get(last) == target) {
            System.out.println("Item found: " + list.get(last));
        }

        while (first <= last) {
            int mid = (first + last) / 2;

            if (list.get(mid) == target) {
                System.out.println("Item found: " + list.get(mid));
                break;
            } else if (list.get(mid) < target) {
                first = mid;
            } else if (list.get(mid) > target) {
                last = mid;
            }

        }

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int len = list.size();
        BinarySearch obj = new BinarySearch();
        int target = 9;
        obj.binarySearchAlgo(list, len, target);
    }

}
