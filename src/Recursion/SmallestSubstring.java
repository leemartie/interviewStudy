package Recursion;

import java.io.*;
import java.util.*;

/*
 * Given an input string, find the shortest substring containing all letters from
 * an alphabet.
 *
 * Ex. input string: "aabbccba", alphabet: "abc"
 * Answer: "cba"
 *
 * Reason: The shortest substring with all letters is "cba".
 */

class SmallestSubstring {

  
  /**
  * checks if all alphabet chars have been found
  */
  public boolean allTicked(HashMap<Character, Boolean> theMasterMap){
   
    for(Boolean b: theMasterMap.values()){
     if(!b){
      return false; 
     }
    }
    return true;
  }
  
  /*
  *resets check list
  */
  public void clear(HashMap<Character, Boolean> theMasterMap){
  for(Character c: theMasterMap.keySet()){
     theMasterMap.put(c,false);
    }
  }
  
  public HashMap<Character, Boolean> makeMap(char[] alphabet){
    HashMap<Character, Boolean> map = new HashMap<>();
    for(char c: alphabet){
      map.put(c,false);
    }
    return map;
  }
  
  public char[] makeSub(char[] input, int start, int end){
   
    char[] newInput = new char[end-start];
    
    int index = 0;
    for(int i = start; i<end; i++){
      newInput[index] = input[i];
      index++;
    }
    return newInput;
  }
  
  public void print(char[] list){
   for(char c: list){
    System.out.print(c+" "); 
   }
    System.out.println();
  }
  
  
  
  
  
  /**
  * finds length of substring containing all characters 
  * so since it checks each substring once and there are k+(k-1)+(k-2)+...+1 substrings
  * then this method runs in O((n(n+1))/2) which is polynomial
  * and thus something I can live with... small tweek to skip impossible cases
  */
  public String findSubString(String input, String alphabet){
    //skipping impossible cases
    if(input.length() < alphabet.length()){
     return null; 
    }
    
    char [] inputArray = input.toCharArray();
    char [] alphaArray = alphabet.toCharArray();
        
    print(inputArray);
    
    HashMap<Character, Boolean> map1 = this.makeMap(alphabet.toCharArray());
    
    for(char c: inputArray){
     map1.put(c,true); 
    }
    
    if(this.allTicked(map1)){
     String one = input; 
     String two = findSubString(new String(makeSub(inputArray,0,inputArray.length-1)), alphabet);
     String three = findSubString(new String(makeSub(inputArray,1,inputArray.length)),alphabet);
     
      if(two != null && three != null){
       
        if(two.length() < three.length()){
         return two; 
        }else{
         return three; 
        }
      }else if(two != null){
        return two;
      }else if(three != null){
        return three;
      }
      return one;
      
    }else{
     return null; 
    }


  }
  
  
  
  
  public static void main(String[] args) {

	  SmallestSubstring s = new SmallestSubstring();
    
    String found = s.findSubString("aabbccba","abc");
    
    System.out.println("*"+found+"*");
    
    
    
    
  }
}

