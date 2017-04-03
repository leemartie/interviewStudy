package Arrays;

import java.io.*;
import java.util.*;

/*
 * Find the contiguous subarray within an array of integers that has the largest
 * product. For example, given the array [2, 3, -2, 4], the contiguous subarray
 * [2, 3] has the largest product of 6. 
 * 
 * Input: int[]
 * Output: int[]
 */

class SubSetSum {
  
  
  public int[] makeSubArray(int[] array, int start, int end){
   int [] subArray = new int[end-start];
    int index = 0;
    for(int i = start;i<end; i++){
     subArray[index] = array[i];
      index++;
    }
    return subArray;
  }
  
  public int[] max(int[] a1, int[] a2){
	  int prod1 = 1;
	  int prod2 = 1;
	  
	  for(Integer i: a1){
		  prod1 *= i;
	  }
	  
	  for(Integer i: a2){
		  prod2 *= i;
	  }
	  
	  if(prod1 > prod2)
		  return a1;
	  else
		  return a2;
	  
  }
  
  public int[] findThatMax(int[] array, int start, int end, int max, boolean started){
	 // print(makeSubArray(array,start,end));
   if(end == start)
	   return array;

    int upperIndex = start;
    int runningProduct = 1;
    
    for(int i = start ;i<end;i++){
     
      int num = array[i];
      
      if(!started){
        max = num;
        started = true;
        upperIndex++;
      }else{
        runningProduct *= num;
        
        if(max < runningProduct){
         max = runningProduct; 
          upperIndex=i;
        }
        
      }
      
    }
    
    int[] subArray =  makeSubArray(array,start, upperIndex+1);
    int[] subArray2 =  findThatMax(array,start+1, array.length,max,true);
    
    
    return max(subArray, subArray2);
    

    
  }
  
  
  public void print(int [] array){
    // another way to do this is using the Arrays.toString() method
	    System.out.println(Arrays.toString(array));//sweet

  }
  
  public static void main(String[] args) {

    
    int[] test =  {2, 3, -2, 4};
    int[] test2 =  {2, 3, 0,-2, 4,-1};
    
    SubSetSum s = new SubSetSum();
    
    int[] result = s.findThatMax(test,0,test.length,0,false);
    	s.print(result);
    int[] result2 = s.findThatMax(test2,0,test2.length,0,false); 
    	s.print(result2);
    
    
  }
}

