package Arrays;

import java.io.*;
import java.util.*;

/*
 * Given two strings S and T, determine if they are one edit distance away. Can you do it in one pass
 * input: two strings
 *
 * output: boolean
 */

public class DiffByOne {
  
  
  public static boolean distOne(String s, String t){
    
    
    if(Math.abs(s.length()-t.length()) > 1 ){
      return false;
    }
    
    int dist = 0;
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    
    int sLength = sArray.length;
    int tLength = tArray.length;
    
    char[] larger = tArray;
    char[] smaller = sArray;
    if(sLength > tLength){
      larger = sArray;
      smaller = tArray;
      dist++;
    }else if(sLength < tLength){
      larger = tArray;
      smaller = sArray;
      dist++;
    }
    
    for(int i = 0; i<smaller.length; i++){
     
      if(larger[i] != smaller[i]){
       dist++; 
      }
      
    }
    
    
    if(dist > 1 || dist == 0)
      return false;
    else
      return true;
    
    
  }
  
  
  public static void main(String[] args) {
    
    System.out.println(distOne("test","tes")); // this should be true
    System.out.println(distOne("test","test")); // true/false is okay. i forgot to specify //fixed 
    System.out.println(distOne("test","fest")); // this should be true
    System.out.println(distOne("test", "testa")); // this should be true
    System.out.println(distOne("test", "text")); // nice
  }
}

