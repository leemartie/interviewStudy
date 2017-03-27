package Sort;

import java.lang.reflect.Array;

/**
 * -----------  
 * < MERGE MOOOOOOOOO! >
 *  ----------- 
 *       \   ^__^
 *        \  (oo)\_______
 *           (__)\       )\/\
 *               ||----w |
 *               ||     ||
 * 
 * @author leemartie
 *
 */
public class CowMergeSort {
	
	
	public static int[] merge(int [] array1, int[] array2){
		int sum = array1.length+array2.length;
		int[] mergedArray = new int[sum];
		
		int pointer1 = 0;
		int pointer2 = 0;
		int index = 0;
		while(pointer1 < array1.length && pointer2 < array2.length){
			if(array1[pointer1] <= array2[pointer2]) {
				mergedArray[index] = array1[pointer1];
				pointer1++;
				index++;
			}else if(array1[pointer1] > array2[pointer2]){
				mergedArray[index] = array2[pointer2];
				pointer2++;
				index++;
			}
		}
		
		//now one of the pointers is still less than length maybe..
		
		if(pointer1 < array1.length){
			for(int i = pointer1; i<array1.length;i++){
				mergedArray[index] = array1[i];
				index++;
			}
		}else if(pointer2 < array2.length){
			for(int i = pointer2; i<array2.length;i++){
				mergedArray[index] = array2[i];
				index++;
			}
		}
		
		
		return mergedArray;
		
	}
	
	public static int[] subArray(int [] array, int low, int high){
		int[] subArray = new int[high-low];	
		int index = 0;

		for(int i = low; i<high; i++){
			subArray[index] = array[i];
			index++;
		}	

		return subArray;
	}
	
	public static int [] mergeSort(int [] array){
		 //print(array);		//one element so already sorted
		if(array.length <= 1){
			return array;
		}

		int mid = (array.length)/2;		
		
		int [] array1 = mergeSort(subArray(array,0,mid));
		int [] array2 = mergeSort(subArray(array,mid,array.length));
		
		
		return merge(array1, array2);
	}
	
	 public static void print(int[] array){
		 String out = "";
		 for(int i = 0; i< array.length;i++){
				 out = out + array[i];

			 if(i<array.length-1)
				 out = out+", ";
			
		 }
		 System.out.println(out);
	 }
	
	public static void main(String [] args){
		 int [] array = {100,12,1,4124,12,5,78,13};
		 
		 array = mergeSort(array);
		 print (array);
	}

}
