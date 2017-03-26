package Recursion;

public class GCD {

	
	
	public static int findGCD(int a, int b){
		
		if(b == 0){
			return a;
		}			
		if(a == 0){
			return b;
		}		
		
		if(a == b){
			return a;
		}
		else if(a > b && a%b == 0){
			return findGCD(b, a%b);
		}else if(a < b && b%a == 0){
			return findGCD(a,b%a);
		}else{
			if(a<b){
				return findGCD(a,b%a);
			}else{
				return findGCD(b,a%b);
			}
		}
	}
	
	
	public static void main(String args[]){
		int a = 55;
		int b = 10;
		System.out.println("GCD "+a+","+b+" "+findGCD(a,b));
		
	}
}
