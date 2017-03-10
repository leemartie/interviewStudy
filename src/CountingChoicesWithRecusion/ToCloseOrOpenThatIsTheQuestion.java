package CountingChoicesWithRecusion;


public class ToCloseOrOpenThatIsTheQuestion {

	private static void recursivelyAttemptPairs(String current, int left, int right) {
		if(left > right) return; 
		if(left == 0 && right == 0) { System.out.println(current); return;}
		if(left > 0) {
			recursivelyAttemptPairs(current + "(", left - 1, right);
		}
		if(right > 0) {		
			recursivelyAttemptPairs(current + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		recursivelyAttemptPairs("", n, n);
	}
}
