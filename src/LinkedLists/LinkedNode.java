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
	
	public int hashCode(){
		return data;
	}
	
	public boolean equals(Object o){
		if(o instanceof LinkedNode){
			LinkedNode temp = (LinkedNode)o;
			
			if(temp.data == this.data)
				return true;
			else 
				return false;
		}
		else{
			return false;
		}
	}

}
