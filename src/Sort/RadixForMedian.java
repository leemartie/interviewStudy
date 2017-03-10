package Sort;

public class RadixForMedian {
	

	/**
	 * 
	 * @param arr
	 * @param numDigits
	 */
		public static void radixSort(int[] arr, int numDigits){
			int[] sorted = new int[arr.length];
			for(int i=1; i<=numDigits; i++){
				countingSort(arr, sorted, 9, i);
				int[] temp = sorted;
				sorted = arr;
				arr = temp;
			}
		}
		
		/**
		 * 
		 * @param n
		 * @param d
		 * @return
		 */
		public static int extractDigit(int n, int d){ //digit 1 is units digit, 2 is tens digit, etc.
			return (n/((int)Math.pow(10, d-1)))%10;
		}
		
		/**
		 * 
		 * @param unsorted
		 * @param sorted
		 * @param max
		 * @param digit
		 */
		public static void countingSort(int[] unsorted, int[] sorted, int max, int digit){
			int[] countArray = new int[max+1];
			
			for(int i=0; i<unsorted.length; i++)
				countArray[extractDigit(unsorted[i], digit)]++;
			
			//printList(countArray);
			
			for(int i=1; i<=max; i++)
				countArray[i] += countArray[i-1];
			
			//printList(countArray);
			
			for(int i=sorted.length-1; i >= 0; i--){
				sorted[countArray[extractDigit(unsorted[i], digit)]-1] = unsorted[i];
				countArray[extractDigit(unsorted[i], digit)]--;
			}
			
			//printList(sorted);
			
		}
	
		/**
		 * 
		 * @param list
		 */
		public static void printList(int[] list){
			for(int i = 0; i<list.length;i++){
				System.out.print(list[i]+" ");
			}
				System.out.println();
		}
	
		/**
		 * 
		 * @param args
		 */
	public static void main(String args []){
		int[] list = {1,4,10,11,2,23,50};
		

		radixSort(list,2);
		
		//printList(list);
		
		System.out.println(list[list.length/2]);
		
		
		
	}

}
