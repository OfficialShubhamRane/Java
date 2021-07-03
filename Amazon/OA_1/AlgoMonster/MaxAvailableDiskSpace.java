package AlgoMonster;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class MaxAvailableDiskSpace {

    public static int availableSpace(int numComputer, List<Integer> hardDiskSpace, int segmentLength) {

        int res = Integer.MIN_VALUE;

        // strictly monotone increasing of (index, space)

        ArrayDeque<Map.Entry<Integer, Integer>> lows = new ArrayDeque<>();

        for (int i = 0; i < hardDiskSpace.size(); i++) {
            int space = hardDiskSpace.get(i);

            if (lows.size() > 0 && lows.getFirst().getKey() <= i - segmentLength)
                lows.pollFirst();

            while (lows.size() > 0 && lows.getLast().getValue() >= space)
                lows.pollLast();

            lows.offerLast(Map.entry(i, space));
            if (i >= segmentLength)
                res = Math.max(res, lows.getFirst().getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numComputer = Integer.parseInt(scanner.nextLine());
        List<Integer> hardDiskSpace = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int segmentLength = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = availableSpace(numComputer, hardDiskSpace, segmentLength);
    }
}