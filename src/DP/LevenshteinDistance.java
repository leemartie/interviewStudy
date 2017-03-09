package DP;


import java.util.Arrays;

/**
 * 
 * @author leemartie
 *
 */
public class LevenshteinDistance {
	int [][] distance;
	String A;
	String B;
	
	public LevenshteinDistance(String A, String B){
		this.A = A;
		this.B = B;
		
		this.distance = new int[A.length()][B.length()];
		
		//input value across distance with default token 
		//to indicate it has not been populated yet
		for(int[] row: this.distance){
			Arrays.fill(row, -1);
		}
	}
	
	public int compute(String A, int Aindex, String B, int Bindex){
		
		if(Aindex < 0){
			return Bindex+1;//how many characters to add
		}else if(Bindex < 0){
			return Aindex+1; //how many characters to delete
		}
		if(distance[Aindex][Bindex] == -1){
			if(A.charAt(Aindex) == B.charAt(Bindex)){
				distance[Aindex][Bindex] = compute(A,Aindex-1,B,Bindex-1);
			}
			else{
				//we calculate... possible moves to get A to B
				//but ignore length 
				int swapLast = compute(A,Aindex-1,B,Bindex-1);
				
				int addBtoALast = compute(A,Aindex,B,Bindex-1);
				
				int removeALast = compute(A,Aindex -1 ,B,Bindex);
				
				distance[Aindex][Bindex] = 1+Math.min(swapLast, Math.min(addBtoALast,removeALast));
				
			}
		}//if not set
		
		return distance[Aindex][Bindex];
		
	}

	
	public static void main(String args[]){
		String A = "lee";
		String B = "eel";
		LevenshteinDistance ld = new LevenshteinDistance(A,B);
		int edits = ld.compute(A, A.length()-1, B, B.length()-1);
		
		System.out.println("Edits from "+A+" to "+B+" "+edits);
	}
	
}
