import java.util.*;
import java.io.*;

/**
 * cutOffRanks
 */
public class CutOffRanks {


    public static int cutOffRank(int cutOffRank, int num, int[] scores) {

        /*****************************************************************
        Map<Integer, Integer> counts = new HashMap<>();
        for (int score : scores) {
            counts.put(score, counts.getOrDefault(score, 0) + 1);
        }
  
        int levelups = 0;
        int score = 100;
  
        while (score > 0 && levelups < cutOffRank) {
            levelups += counts.getOrDefault(score, 0);
            score--;
        }
  
          // now either lvlups >= cut_off (have enough players at least cut_off rank),
          // or score = 0 (every non-zero player levels up
  
        System.out.println(levelups);
        return levelups;
        ********************************************************************/


        
        

    }


    public static void main(String[] args) {

        int[] score1 = {100, 50, 50, 25}; // output = 3
        cutOffRank(3, 4, score1);

        int[] score2 = {2, 2, 3, 4, 5}; // output = 5
        // cutOffRank(4, 5, score2);
    
    }
}