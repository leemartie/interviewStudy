package LinkedLists;

public class LinkedNode {
	
	int data = 0;
	LinkedNode next;
	
	public String toString(){
		
		String node = data+"";
		
		if(next != null)
		node = node+"-->"+next.toString();
		
		return node;
	}

}
