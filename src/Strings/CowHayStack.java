package Strings;

import java.io.*;
import java.util.*;

/*
 * Find the index of the first occurrence of a substring in a string
 * If the substring does not exist, return -1
 * 
 * This function is known as strstr() in C
 */

class CowHayStack {
  public static int needleInHaystack(String needle, String haystack) {
    // your code goes here!
    
    //handling weird corner cases
    if(haystack.length() == 0 && needle.length() == 0){
     return -1; 
    }
    
    if(haystack.length() < needle.length()){
      return -1;
    }
    
    if(haystack.length() == needle.length() && haystack.charAt(0) != needle.charAt(0)){
     return -1; 
    }
    
    
    char [] charedStackOfHay = haystack.toCharArray();
    
    char [] charedNeedle = needle.toCharArray();
    
     
      int needleIndex = 0;
      int start = 0; 
      for(int i = 0;i<charedStackOfHay.length; i++){
        if(charedStackOfHay[i] == charedNeedle[needleIndex]){
          needleIndex++;
          
        }else{
          needleIndex = 0;
          //have to check for the case where we could be starting a new match
          if(charedStackOfHay[i] == charedNeedle[needleIndex]){
           needleIndex++;
          }
          
        }
        
        if(needleIndex == 1){
         start = i;  
        }
        
        if(needleIndex == charedNeedle.length){
          return start;
        }
      }
  

    return -1;
    
    
  }
  

  public static void main(String[] args) {
    String needle = "abc";
    String haystack = "words: abc, def, ghi";
    System.out.println(needleInHaystack(needle, haystack) == 7); // should return 7

    haystack = "word does not exist here";
    System.out.println(needleInHaystack(needle, haystack) == -1); // should return -1
    
    haystack = "aaaaabc";
    System.out.println(needleInHaystack(needle, haystack) == 4); // should return 4
    
    haystack = "abcdefg";
    System.out.println(needleInHaystack(needle, haystack) == 0); // should return 0
    
    haystack = "ababcdefg";
    System.out.println(needleInHaystack(needle, haystack) == 2); // should return 2
    
    haystack = "";
    System.out.println(needleInHaystack(needle, haystack) == -1); // should return -1
    
    haystack = "-=09abc-0231";
    System.out.println(needleInHaystack(needle, haystack) == 4); // should return 4
    
    haystack = "abc";
    System.out.println(needleInHaystack(needle, haystack) == 0); // should return 0
    
    haystack = "ab";
    System.out.println(needleInHaystack(needle, haystack) == -1); // should return -1
    
    haystack = "abcabc";
    System.out.println(needleInHaystack(needle, haystack) == 0); // should return 0
    
    haystack = "ababc";
    System.out.println(needleInHaystack(needle, haystack) == 2); // should return 2
    
  }
}

