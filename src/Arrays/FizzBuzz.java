package Arrays;

public class FizzBuzz {

	
	public static void fizzOrBuzz(int fizzMultiple, int buzzMultiple, int loopMax){
		
		for(int i = 0; i< loopMax; i++){
			
			if(i%fizzMultiple == 0 && i%buzzMultiple == 0){
				System.out.println("fizzBuzz: "+i);
			}
			else if(i%fizzMultiple == 0){
				System.out.println("fizz: "+i);
			}
			else if(i%buzzMultiple == 0){
				System.out.println("buzz: "+i);
			}
		}
	}
	
	
	public static void main (String args[]){
		fizzOrBuzz(3,5,100);
	}
}
