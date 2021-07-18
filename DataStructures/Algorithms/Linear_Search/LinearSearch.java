import java.util.*;

class LinearSearch {

    public void linearSearchAlgo(List<Integer> list, int len, int target) {

        /** Approach 1: Iteratice Approach */
        for (int value : list) {
            if (value == target) {
                System.out.println("Target found at index: " + list.indexOf(target));
            }
        }

        /** Approch 2: Direct approach */
        int isFound = list.indexOf(target);

        if (isFound != -1) {
            System.out.println("Target found at: " + isFound);
        } else {
            System.out.println("Target not found");
        }

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int len = list.size();
        int target = 9;
        LinearSearch obj = new LinearSearch();
        obj.linearSearchAlgo(list, len, target);
    }
}