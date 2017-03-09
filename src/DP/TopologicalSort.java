package DP;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class TopologicalSort {

	
	private static HashMap<String, Node> map = new HashMap<String, Node>();	
	
	private class Node{
		public HashSet<Node> children = new HashSet<Node>();
		public int finishTime = 0;
		public String value;
		
		public String graph(){
			String str = "";
			str = value+": "+finishTime+" ->";
			for(Node child: children){
				str = str+child.value+", ";
			}
			for(Node child: children){
				str = str+"\n\t"+child.graph();
			}
			//str = str+"\n";
			
			return str;
			
		}
		
		public String toString(){
			
			//return graph();
			return value;
		}
		
		public boolean equals(Node node){
			if(node.value == this.value)
				return true;
			else
				return false;
		}
		
		public String hashcode(){
			return value;
		}
	}
	
	/**
	 * dfs
	 * @param node
	 * @param time
	 */
	public void dfs(Node node, int time){
		
		if(node.children.size() > 0){
			for(Node child: node.children){
				dfs(child, time+1);
			}
		}
		
		node.finishTime = node.finishTime+time;
	}
	
	/**
	 * sort by finish time
	 * @return
	 */
	public Node[] sortByfinishTime(Node[] nodes){
		
		for(int i = 0; i<nodes.length; i++){
			for(int j = i+1; j<nodes.length; j++){
				if(nodes[i].finishTime > nodes[j].finishTime){
					Node temp = nodes[j];
					nodes[j] = nodes[i];
					nodes[i] = temp;
				}
			}
		}
		
		return nodes;
	}
	
	public Node[] setToArray(Collection<Node> nodes){
		Node[] nodeArray = new Node[nodes.size()];
		int count = 0;
		
		for(Node node: nodes){
			nodeArray[count] = node;
			count++;
		}
		
		return nodeArray;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		
		String[] words = {"ccda", "ccbk", "cd", "a", "ab"};
		
		TopologicalSort ts = new TopologicalSort();
		
	
		//make the nodes
		for(String word: words){				
			for(int i = 0; i<word.length();i++){				
				char letter = word.charAt(i);
				Node node = ts.map.get(letter);
				
				if(node == null){
					node = ts.new Node();
					node.value = letter+"";	
					ts.map.put(letter+"", node);
				}
			}
		}
		
		//make the edges
		for(String word: words){
			for(int i = 0; i<word.length()-1;i++){		
				char letter = word.charAt(i);
				char letter2 = word.charAt(i+1);
					if(letter != letter2){
						ts.map.get(letter+"").children.add(ts.map.get(letter2+""));
					}
			}
			
		}
		
		//traverse and set times - times are score of how long it takes to visit a node
		//the longer it takes the later in the order it comes
		for(Node node: map.values()){
			ts.dfs(node,0);
		}
		
		Node[] order = ts.sortByfinishTime(ts.setToArray(ts.map.values()));
		
		for(Node node: order){
			System.out.print(node.value+" ");
		}
		
	}//main
}
