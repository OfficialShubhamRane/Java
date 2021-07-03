package AlgoMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    public static int fillTheTruck(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {

        int ans = 0;
        int boxesLeft = truckSize;
        ArrayList<Map.Entry<Integer, Integer>> unitsBoxes = new ArrayList<>();
        for (int i = 0; i < unitSize; i++)
            unitsBoxes.add(Map.entry(unitsPerBox.get(i), boxes.get(i)));
        unitsBoxes.sort(Comparator.comparing(e -> -e.getKey()));
        for (Map.Entry<Integer, Integer> e : unitsBoxes) {
            int units = e.getKey();
            int box = Math.min(boxesLeft, e.getValue());
            ans += box * units;
            boxesLeft -= box;
            if (boxesLeft == 0)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        //Driver Code
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> boxes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int unitSize = Integer.parseInt(scanner.nextLine());
        List<Integer> unitsPerBox = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int truckSize = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = fillTheTruck(num, boxes, unitSize, unitsPerBox, truckSize);
        System.out.println(res);
    }

	public Object maxRoot;
}


/** Solution from leetcode */
/** But first get the input in array of array format with numOfBoxes as a first element and numOfUnits as a second element */
/**
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}
*/