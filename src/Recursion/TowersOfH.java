package Recursion;

import java.io.*;
import java.util.*;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class TowersOfH {
  
  public static void main(String[] args) {
    int nDisks = 3;
    towers(nDisks, 'A', 'B', 'C');
  }

  public static void towers(int topN, char from, char inter, char to) {
    if (topN == 1){
      System.out.println("Disk 1 from " + from + " to " + to);
    }else {
    	towers(topN - 1, from, to, inter);
      System.out.println("Disk " + topN + " from " + from + " to " + to);
      towers(topN - 1, inter, from, to);
    }
  }
}
