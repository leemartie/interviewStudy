package CountingChoicesWithRecursion;


public class ToCloseOrOpenThatIsTheQuestion {

	private static void recursivelyAttemptPairs(String current, int left, int right) {
		if(left > right) return; 
		if(left == 0 && right == 0) { System.out.println(current); return;}
		if(left > 0) {
			System.out.println("(");
			recursivelyAttemptPairs(current + "(", left - 1, right);
			
		}
		if(right > 0) {		
			
			recursivelyAttemptPairs(current + ")", left, right - 1);
			System.out.println(")");
			
		}
	}
	
	
	
	
	
	/**
	 * Example of recursively making choices, but where choice
	 * depends on how many and the relationship between choices
	 * @param current
	 * @param left
	 * @param right
	 */
	private static void paren(String current, int left, int right){
			
		if(left == 0 && right == 0){
			System.out.println(current);	
			return;
		}
		
		if(left >0){
			paren(current+"(", left-1,right);
		}
		
		
		if(right>0 && left < right){
			paren(current+")",left,right-1);
		}
		
		
		
	}

	public static void main(String[] args) {
		int n = 4;
		paren("", n, n);
	}
}
