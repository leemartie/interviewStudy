package DP;

import java.util.Arrays;

public class KnapSackWithMemoization {

	public static int maxValue(int index, int capacity, int[] values, int[] weights, int[][] memo){

		if(index >= values.length || capacity <= 0){
			return 0;
		}else if(memo[index][capacity] != -1){
			//we already calculated this path
			return memo[index][capacity];
		}else{

			//skip first cow 
			int valueOfSkip = maxValue(index+1,capacity,values,weights, memo);
			//add first cow and fits
			if(weights[index] <= capacity){
				int valueOfAdding = values[index] + maxValue(index+1,capacity-weights[index],values,weights,memo);
				int value = Math.max(valueOfSkip, valueOfAdding);
				memo[index][capacity] = value;
				return value;
			}else{
				memo[index][capacity] = valueOfSkip;
				return valueOfSkip;
			}
		}
	}
	
	
	
	public static void main(String args[]){
		int [] cowValues = {10,50,5,100};
		int [] cowWeights = {500,100,20,550};
		int cowKnapSackCapacity = 700;
		int[][] memo = new int[cowValues.length][cowKnapSackCapacity+1];
		
		//init memo
		for(int[] weights: memo){
			Arrays.fill(weights,-1);
		}
		
		int mostValue = maxValue(0, cowKnapSackCapacity,cowValues,cowWeights,memo);
		
		System.out.println("most value of cows is: "+mostValue);
		
		
	}
	
}
