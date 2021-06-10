package MillinuimLLC;

/**
 * MaximumNumber
 */
public class MaximumNumber {

    public static void main(String[] args) {

        /** Test Input */
        // int[] inputArr = new int[] { 2, 8, 4, 10 };
        int[] inputArr = new int[] { 6, 8, -5 };
        int n = 2;

        int[] resultArr = new int[Math.min(n, inputArr.length)];
        int resultArrIndex = 0;

        int globalMax = inputArr[0];
        int globalMaxIndex = 0;

        while (resultArrIndex < resultArr.length) {

            for (int i = 0; i < inputArr.length; i++) {
                if (inputArr[i] > globalMax) {
                    globalMax = inputArr[i];
                    globalMaxIndex = i;
                }
            }

            resultArr[resultArrIndex] = globalMax;
            inputArr[globalMaxIndex] = Integer.MIN_VALUE;
            globalMax = Integer.MIN_VALUE;
            resultArrIndex++;
        }

        /** For debugging */

        System.out.println("length: " + resultArr.length);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.println(resultArr[i]);
        }

    }
}