package Sort;

/**
 * -----------  
 * < MOOOO SORT >
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
public class QuickCowSort {
	
	
	public static int[] swap(int [] array, int i, int j){
		 //swap
		 int temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
		 
		 return array;
	}
	
	/**
	 * Only Cow's know how to sort quickly... on average but their worst case is n^2
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	 public static int[] QuickCowSort(int [] array, int low, int high){
		 
		 
		 if(high <= low){
			 return array;
		 }
		 
		 
		 int cowLow = low;
		 //put the pivot to the side
		 int cowHigh = high-1; 
		 //cow picks some pivot
		 int pivot = high;
				 
		 while(true){
			 //the cow only increments when everything is in correct partial order
			 while(cowLow <= cowHigh && array[cowLow] < array[pivot]){
				 cowLow++;
			 }
			 while(cowHigh >= cowLow && array[cowHigh] > array[pivot]){
				 cowHigh--;
			 }
			 
			 print(array,pivot);
			 //everything is now in correct partial order so we can just swap in 
			 //the pivot to top of the low stack
			 if(cowLow > cowHigh){
				 //we use cowLow because we know that it points now to
				 //first element that is larger than array[pivot]
				 swap(array,cowLow,pivot);
				 break;// out like a mad cow
			 } 
			 
			 //swap elements not in right partial order, 
			 //sometimes it will just swap the same element when cowHigh == cowLow
			    swap(array,cowLow,cowHigh);
			 	
			 //moving on to next patch of grass to munch on
			 cowLow++;
			 cowHigh--;
			 
		 }
	
		 array = QuickCowSort(array,low,cowHigh);	
		 array = QuickCowSort(array,cowLow,high);

		 return array;

	 }
	 
	 public static void print(int[] array, int pivot){
		 String out = "";
		 for(int i = 0; i< array.length;i++){
			 if(i == pivot){
				 out = out+"["+array[i]+"]";
			 }else{
				 out = out + array[i];
			 }
			 
			 if(i<array.length-1)
				 out = out+", ";
			
		 }
		 System.out.println(out);
	 }
	 
	 public static void main(String args[]){
		 int [] array = {100,12,1,4124,12,5,78,13};
		 
		 array = QuickCowSort(array,0,array.length-1);
		 		 
	 }

}
