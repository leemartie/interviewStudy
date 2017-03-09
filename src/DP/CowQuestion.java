package DP;

/**
 * Cow Questions... because...
 * 
 * @author leemartie
 *
 */
public class CowQuestion {
	
	/**
	 * Count all possible steps taken across all paths by a cow
	 * @param n
	 * @return
	 */
	public static int countCowJumps(int n){
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else {
			return countCowJumps(n-1)+countCowJumps(n-2)+countCowJumps(n-3);
		}
	}
	
	/**
	 * Count all steps of min path taken by cow up stairs
	 * @param n
	 * @return
	 */
	public static int minCowJumps(int n){
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else {
			int oneStep = 1 + minCowJumps(n-1);
			int twoStep = 1 +minCowJumps(n-2);
			int threeStep = 1 +minCowJumps(n-3);
			
			return Math.min(oneStep, Math.min(twoStep,threeStep));
		}
	}
	
	/**
	 * Count possible paths to move a cow from one grid cell to another
	 * @param startRow
	 * @param startCol
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int countPaths(int startRow, int startCol, int rows, int cols){
		if(startRow > rows){
			return 0;
		}else if(startCol > cols){
			return 0;
		}
		else if(startRow == rows && startCol == cols){
			return 1;
		}else{
			return countPaths(startRow+1, startCol, rows, cols)+countPaths(startRow, startCol+1, rows, cols);
		}
		
	}
	
	
	
	
	public static void main(String args[]){
		int stairs = 20;
		
		System.out.println("cow jumps: "+countCowJumps(stairs));
		
		
		
		System.out.println("min cow jumps up "+stairs+": "+minCowJumps(stairs));
		
		System.out.println("possible paths"+countPaths(0,0,2,2));
	}

}
