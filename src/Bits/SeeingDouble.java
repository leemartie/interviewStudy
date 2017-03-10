package Bits;

/**
 * -----------  
 * < XOR baby! >
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
public class SeeingDouble {		
	public static void main(String args[]){	
		int[] doubleButOne = {100,5,4,4,5,6,6,100,7};
		int prev = 0;
		for(int i = 0; i< doubleButOne.length; i++){	
			if(i == 0){
				prev = doubleButOne[i];
			}else{
				prev = prev ^ doubleButOne[i];
			}
		}		
		System.out.println(prev);
	}
}
