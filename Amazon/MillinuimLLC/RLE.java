package MillinuimLLC;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RLE {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    byte[] testInput = new byte[5];
    int i = 0;
    while (i < 5) {
      testInput[i] = sc.nextByte();
      i++;
    }

    System.out.println("Output");
    for (i = 0; i < testInput.length; i++) {
      System.out.println(testInput[i]);
    }

    String inputStr = new String(testInput);
    System.out.println(inputStr);

    byte[] outputByte = inputStr.getBytes();
    for (i = 0; i < outputByte.length; i++) {
      System.out.println(outputByte[i]);
    }

    // byte[] inputByteArr = new byte[]{97,97,97,98,98,98};
    // String inputStr = new String(inputByteArr);

    // char prevChar = inputStr.charAt(0);
    // int prevCharCount = 1;

    // for (int i = 1; i < inputStr.length(); i++) {

    // char currChar = inputStr.charAt(1);
    // if( ){

    // }

    // }
  }
}
