package Search;

import java.util.ArrayList;

public class Node {

	public boolean visited = false;
	
	public ArrayList<ToEdge> toEdges = new ArrayList<ToEdge>();
	
	public String name = "";
	
	public int distanceTo = -1;
	
	public Node preNodeOnShortPath = null;
	
	public ArrayList<Node> pathToNode(){
		ArrayList<Node> list = new ArrayList<Node>();
		
		if(preNodeOnShortPath == null)
			list.add(this);
		else{
			ArrayList<Node> subList = preNodeOnShortPath.pathToNode();
			subList.add(this);
			list.addAll(subList);
		}
		

		return list;
	}
	
	public Node(String name){
		this.name = name;
	}
	
	public String toString(){
		return name + "("+distanceTo+")";
	}
	
	public void addEdge(ToEdge edge){
		toEdges.add(edge);
	}
	
	
	
}
