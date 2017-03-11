package CountingChoicesWithRecusion;

public class Combination {
	
	public static void combination(String someString, int size){
		char[] arrayOfChars = someString.toCharArray();
		combination(arrayOfChars, new StringBuilder(), size);
	}
	
	public static void combination(char[] arrayOfChars, StringBuilder sb, int size){
		
		if(sb.length() == size){
			
			System.out.println("-->"+sb);
			return;
		}
		
		
		for(int i = 0; i<arrayOfChars.length; i++){
			sb = sb.append(arrayOfChars[i]);
			
			char[] smallerArray = new char[arrayOfChars.length-(i+1)];
			int count = 0;
			for(int j = i+1;j<arrayOfChars.length;j++){				
				smallerArray[count] = arrayOfChars[j];
				count++;
			}//j
			
			combination(smallerArray, sb, size);
			
			//pop the char
			if(sb.length() > 0){
				StringBuilder remove = sb.deleteCharAt(sb.length()-1);
				sb = remove;
			}
		}//i
	}
	public static void main(String args[]){
		
		combination("tedf",3);
		
	}
}
