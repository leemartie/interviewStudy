package Search;


public class BinarySearch {

	/**
	 * 
	 * @param array
	 * @param value
	 * @param bottom
	 * @param top
	 * @return
	 */
	public static int indexOfNotSorted(int[] array,int value, int bottom,int top){
		int mid = ((top-bottom)/2)+bottom;
					
		if(array[mid] == value){
			return mid;
		}else if(top==bottom){
			return -1;
		}else{
			int index1 = indexOfNotSorted(array,value,0,mid);
			int index2 = indexOfNotSorted(array,value,mid+1,top);
						
			if(index1 != -1)
				return index1;
			if(index2 != -1)
				return index2;
		}
		return -1;		
	}
	
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @param bottom
	 * @param top
	 * @return
	 */
	public static int indexOfSorted(int[] array,int value, int bottom,int top){
		int mid = ((top-bottom)/2)+bottom;

		
		//System.out.println("value "+value+" bottom"+bottom+ "top"+top+" mid"+mid);
		int midValue = array[mid];
		
		//System.out.println(midValue);
		
		if(midValue == value){
			return mid;
		}else if(top == bottom){
			return -1;
		}else{
			int index = -1;
			
			if(midValue > value)
				index = indexOfSorted(array,value,0,mid);
			else
				index = indexOfSorted(array,value,mid+1,top);
						
			return index;
		}
	}
	
	
	public static void main(String args[]){
		int [] list = {1,2,3,40,50,60,100,500,2200};
		
		System.out.println(indexOfNotSorted(list,2200,0,list.length-1));
		
		System.out.println(indexOfSorted(list,2200,0,list.length-1));

	}
}
