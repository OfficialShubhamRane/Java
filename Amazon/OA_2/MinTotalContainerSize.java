public class MinTotalContainerSize {
    
    public static int minTotalContainerSize(int[] itemSizeArray, int days){

    }

    public static void main(String[] args) {
        
        int[] itemSizeArray1 = {10, 2, 20, 5, 15, 10, 1};
        


        minTotalContainerSize(itemSizeArray1, 3);
        /** Output = 31
         * day1 - [10,2,20,5,15], container size = 20
         * day2 - [10] container size = 10
         * day3 - [1] container size = 1
         * 20+10+1 = 31
         */

        // minTotalContainerSize(itemSizeArray1, 5);
        /** Output = 43
         * day1 - [10] container size = 10
         * day2 - [2] container size = 2
         * day3 - [20,5,15] container size = 20
         * day4 - [10] container size = 10
         * day5 - [1] container size = 1
         * 10+2+20+10+1 = 43
         */

        int[] itemSizeArray2 = {5,4,2,4,3,4,5,4};
        // minTotalContainerSize(itemSizeArray2, 5);
        /** Output = 16
         * day1 - [5,4] container size = 5
         * day2 - [2] container size = 2
         * day3 - [4,3] container size = 4
         * day4 - [4,5,4] container size = 5
         * 5+2+4+5 = 16
         */

        int[] itemSizeArray3 = {22, 12, 1, 14, 17};
        // minTotalContainerSize(itemSizeArray3, 2);
        /** Output = 39
         * day1 - [22, 12] container size = 22
         * day2 - [1, 14, 17] container size = 17
         * 22 + 17 = 39
         */
    }
}
