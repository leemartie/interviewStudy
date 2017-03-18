package Search;

import java.util.ArrayList;

public class Path {
	
	ArrayList<Node> path = new ArrayList<Node>();
	
	public void addNode(Node node){
		path.add(node);
	}
	
	
	public String toString(){
		String pathSTR = "";
		for(Node node: path){
			pathSTR = pathSTR + node+" ";
		}
		
		return pathSTR;
	}

}
