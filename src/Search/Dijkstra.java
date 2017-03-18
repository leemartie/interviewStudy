package Search;

import java.util.ArrayList;

/**
 * Dijkstra's cow.. he had one.
 * @author leemartie
 *
 */
public class Dijkstra {

	//unvisited nodes
	public ArrayList<Node> unvisited = new ArrayList<Node>();
	
	
	/**
	 * RUN
	 */
	public void run(){
		
		for(Node node: unvisited){
			for(ToEdge edge: node.toEdges){
				Node toNode = edge.to;
				int distance = node.distanceTo + edge.weight;
				if(distance < toNode.distanceTo || toNode.distanceTo == -1){
					toNode.distanceTo = distance;
					toNode.preNodeOnShortPath = node;
				}
				
			}
		}

	}
	

	
	
	public static void main(String args[]){
		
		Dijkstra dij = new Dijkstra();
		
		Node root = new Node("Root");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node end = new Node("End");
		
		root.distanceTo = 0;
		dij.unvisited.add(root);
		dij.unvisited.add(nodeA);
		dij.unvisited.add(nodeB);
		dij.unvisited.add(nodeC);
		dij.unvisited.add(end);
		
		ToEdge a = new ToEdge(nodeA, 5);
		ToEdge b = new ToEdge(nodeB,4);
		ToEdge c = new ToEdge(nodeC,8);
		
		root.addEdge(a);
		root.addEdge(b);
		root.addEdge(c);
				
		ToEdge d = new ToEdge(end,7);
			nodeA.addEdge(d);
		ToEdge e = new ToEdge(end,10);
			nodeB.addEdge(e);
		ToEdge f = new ToEdge(end,2);
			nodeC.addEdge(f);
		

		
		dij.run();
		
		System.out.println(end.pathToNode());
		
		
	}
}
