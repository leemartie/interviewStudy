package CountingChoicesWithRecusion;

/**
 * 
 * @author leemartie
 *
 */
public class Permutation {
	
	
	/**
	 * 
	 * @param someString
	 */
	public static void permute(String someString){
		char[] arrayOfChars = someString.toCharArray();
		permute(arrayOfChars, new StringBuilder());
	}
	
	
	/**
	 * 
	 * @param arrayOfChars
	 * @param sb
	 */
	public static void permute(char[] arrayOfChars, StringBuilder sb){
		
		//System.out.println(arrayOfChars);
		
		if(arrayOfChars.length == 0)
			System.out.println("-->"+sb);
		
		for(int i = 0; i<arrayOfChars.length; i++){
			sb.append(arrayOfChars[i]);
			
			char[] smallerArray = new char[arrayOfChars.length-1];
			int count = 0;
			for(int j = 0;j<arrayOfChars.length;j++){
				
				if(j == i)
					continue;
				
				smallerArray[count] = arrayOfChars[j];
				count++;
			}//j
			
			permute(smallerArray, sb);
			//pop the char
			sb.deleteCharAt(sb.length()-1);
		}//i
	}
	

	
	
	public static void main(String args[]){
		
		permute("ted");
		
	}

}
