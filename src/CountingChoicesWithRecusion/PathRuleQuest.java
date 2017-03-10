package CountingChoicesWithRecusion;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * / Here's a nasty O() for all paths in a \
*	\ graph                                 /
* 	--------------------------------------- 
*        \   ^__^
*         \  (oo)\_______
*            (__)\       )\/\
*                ||----w |
*                ||     ||
 * @author leemartie
 *
 */
public class PathRuleQuest {
	
	
	ArrayList<ArrayList<Edge>> paths = new ArrayList<ArrayList<Edge>>();
	
	private class Edge{
		public String from;
		public String to;
		
		public Edge(String from, String to) {
			this.from = from;
			this.to = to;
		}
		
		public String toString(){
			return from+"->"+to;
		}

	}
	
	
	public void findPathsBetween(String from, String to, ArrayList<Edge> edges, Stack<Edge> prospectPath){
		
		//at the end folks!
		if(from.equals(to)){
			//System.out.println(new ArrayList<Edge>(prospectPath));
			this.paths.add(new ArrayList<Edge>(prospectPath));
			
		}else{
			for(int i = 0; i<edges.size(); i++){
				Edge anEdge = edges.get(i);
				String edgeFrom = anEdge.from;
				String edgeTo = anEdge.to;
				
				
				if(edgeFrom.equals(from) && !edgeFrom.equals(to)){
					
					
					ArrayList<Edge> tmpEdges = new ArrayList<Edge>(edges);
					tmpEdges.remove(i);
					
					prospectPath.push(anEdge);
					findPathsBetween(edgeTo, to, tmpEdges, prospectPath);
					prospectPath.pop();
					
				}
			}
		}
		
		

		
	}
	
	
	public static void main(String args[]){
		
		PathRuleQuest pr = new PathRuleQuest();
		
		String spec = 	 "AE"
						+"\nA: BCD"
						+"\nB: C"
						+"\nC: E"
						+"\nD: B";
		
		
		Scanner scan = new Scanner(spec);
		scan.useDelimiter("\n");
		
		scan.useDelimiter(spec);
		int count = 0;
		String startFrom = "";
		String endTo = "";
		
		Set<String> nodes = new HashSet<String>();
		ArrayList<Edge> edgeSet = new ArrayList<Edge>();
		
		//get all the nodes first....
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			if(count == 0){
				startFrom = line.charAt(0)+"";
				endTo = line.charAt(1)+"";
				nodes.add(startFrom);
				nodes.add(endTo);
			}else{
				String[] edges = line.split(":");
				
				String from = edges[0];
				
				
				for(int i = 1;i<edges.length;i++){
					
					
					String names = edges[i].trim();
					if(names.length() > 1){
						
						for(int j = 0; j<names.length(); j++){
							String name = names.charAt(j)+"";
									edgeSet.add( pr.new Edge(from,name));
							nodes.add(name);
						}
						
						
					}else{
						nodes.add(names);
						
						//inner class instantiation ya know
						edgeSet.add( pr.new Edge(from,names));
					}
					
				}
			}
			count++;
			
			
		}
		scan.close();
		
		//look mom a graph!
		//System.out.println(edgeSet);
		
		pr.findPathsBetween(startFrom,endTo, edgeSet,new Stack<Edge>());
		
		//System.out.println(pr.paths);
		
		for(int i = 0; i<pr.paths.size();i++){
			System.out.println(pr.paths.get(i));
		}
		
		
		
		
		
	}

}
