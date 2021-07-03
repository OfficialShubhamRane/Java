package AlgoMonster;

import java.util.Arrays;

public class BreakPalindrome {

    public static String breakPalindrome(String pali) {
        String s = pali;
        int n = s.length();
        char[] charS = s.toCharArray();
        
        if(n == 1){
            return "";
        }
        for(int i=0; i<n; i++){
            int j = n-1-i;
            
            if(i == j){
                continue;
            }

            if(s.charAt(i) != 'a'){
                charS[i] = 'a';
                s = String.valueOf(charS);
                System.out.println("returned from here 1" + s);
                return s;
            }
        }
        
        charS[n-1] = 'b';
        s = charS.toString();
        System.out.println("returned from here 2");
        return s;
    }

    //driver code
    public static void main(String[] args) {
        System.out.println("abccba");
        System.out.println(breakPalindrome("abccba"));
    }
    
}
