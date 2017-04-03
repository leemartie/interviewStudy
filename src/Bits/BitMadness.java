package Bits;

public class BitMadness {
	
	
	public static boolean isIntPalindrome(int number){
		
		int numberOfDigits = (int)Math.log10(number)+1;
		int mask = (int)Math.pow(10, numberOfDigits-1);

		System.out.println("number of digits: "+numberOfDigits);
		System.out.println("mask: "+mask);
		
		for(int i = 0; i<numberOfDigits/2;i++){
			
			int lead = number/mask;
			
			int end = number%10;
			
			System.out.println("lead: "+lead+", end:"+end);
			
			
			if(lead != end){
				return false;
			}
			
			//mask+rest (bottom digits)
			number = number % mask;
			
			//top digites
			number = number/10;
			
			//updated mask
			mask = mask/100;
		}
		return true;

		
	}
	
	
	
	public static void main(String args[]){
		System.out.println(isIntPalindrome(13231));
	}

}
