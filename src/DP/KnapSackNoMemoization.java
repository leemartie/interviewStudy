package DP;

public class KnapSackNoMemoization {
	
	
	public static int maxValue(int index, int capacity, int[] values, int[] weights){

		if(index >= values.length || capacity <= 0){
			return 0;
		}else{
			//skip first cow 
			int valueOfSkip = maxValue(index+1,capacity,values,weights);
			//add first cow and fits
			if(weights[index] <= capacity){
				int valueOfAdding = values[index] + maxValue(index+1,capacity-weights[index],values,weights);
				return Math.max(valueOfSkip, valueOfAdding);
			}else{
				return valueOfSkip;
			}
		}
	}
	
	public static void main(String args[]){
		int [] cowValues = {10,50,5,100};
		int [] cowWeights = {500,100,20,550};
		int cowKnapSackCapacity = 700;
		
		int mostValue = maxValue(0, cowKnapSackCapacity,cowValues,cowWeights);
		
		System.out.println("most value of cows is: "+mostValue);
		
		
	}

}
