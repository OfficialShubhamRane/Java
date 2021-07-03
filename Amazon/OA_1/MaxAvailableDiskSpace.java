import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MaxAvailableDiskSpace {
    public static int availableSpace(int numComputer, List<Integer> hardDiskSpace, int segmentLength) {
        // WRITE YOUR BRILLIANT CODE HERE    
        int[] hardDiskSpaceArray = hardDiskSpace.stream().mapToInt(Integer::intValue).toArray();    // converting list to array

        int pcLeftToCheck = segmentLength;
        int i = 1;
        int j=hardDiskSpaceArray.length-i ;
        int localMinimum = hardDiskSpaceArray[j];
        int globalMax = 0;
        int localMinimumArray[] = new int[hardDiskSpaceArray.length];
        int k = 0;

        /**Create array for all the minimum within the segment */
        for( ; j >= pcLeftToCheck-1;  j--){        //travesing array in reverse order
            
            if (hardDiskSpaceArray[j] <= localMinimum) {    // If localminimum is less than new value with in segment
   
                localMinimum = hardDiskSpaceArray[j];       // Change local minimum
                localMinimumArray[k] = localMinimum;        // adding new found localminim within segment to local minimum array
                k++;
            }

            pcLeftToCheck--;          // keeping trakc of how many systems are left to check within the segment
            if(pcLeftToCheck == 0){    // if pcLeftToCheck becomes 0 that means segmetn is completed we can move to next segment
                i++;
                j = hardDiskSpaceArray.length - i;
                j++;
                pcLeftToCheck = segmentLength; 
            }
        }

        /**Find maximum from minimum disk space */
        
        if(localMinimumArray.length > 1 
               && localMinimumArray[0] > hardDiskSpaceArray[hardDiskSpaceArray.length-2] ){ //extra condition because wee allowed first 
                                                                                            //localminimum even though it was not minimum but it was equal   
            System.out.println();
            localMinimumArray[0] = 0;    //correcting that extra addition of localMinimum to 0 so it wont affect th output
        }
        
        for (int l : localMinimumArray) {     // calculating maximum from array of localMinimums   
            if(l > globalMax){
                globalMax = l;
            }
        }
        return globalMax; 
    }

    public static void main(String[] args) {
        

        List<Integer> hardDiskSpace = new ArrayList<Integer>();
        // hardDiskSpace.add(8);
        // hardDiskSpace.add(10);
        // hardDiskSpace.add(4);

        hardDiskSpace.add(2);
        hardDiskSpace.add(8);
        hardDiskSpace.add(6);

        // hardDiskSpace.add(6);
        // hardDiskSpace.add(5);


        int res = availableSpace(0, hardDiskSpace, 3);
        System.out.println();
        System.out.print(res);
    }
}

