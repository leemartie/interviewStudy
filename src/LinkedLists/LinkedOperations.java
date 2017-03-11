package LinkedLists;

public class LinkedOperations {
	
	/**
	 * 
	 * @param list
	 * @param newHead
	 * @return
	 */
	public  static LinkedNode insertHead(LinkedNode list, LinkedNode newHead){
		newHead.next = list;
		return newHead;
	}
	
	/**
	 * 
	 * @param list
	 * @param tail
	 * @return
	 */
	public static LinkedNode insertTail(LinkedNode list, LinkedNode tail){
		LinkedNode head = list;
		while(head != null){
			if(head.next == null){
				head.next = tail;
			}else{
				head = head.next;
			}		
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static boolean hasCycle(LinkedNode list){

		
		if(list == null)
			return false;
		
		LinkedNode turtle = list;
		LinkedNode rabbit = list;
		
		while(true){
			turtle = turtle.next;
			
			if(turtle != null)
				rabbit = turtle.next.next;
			else
				return false; //hit end
			
			if(rabbit == null || rabbit.next == null)
				return false; //hit end
			
			if(rabbit.equals(turtle) || rabbit.next.equals(turtle)){
				return true;
			}
		}

	}
	
	/**
	 * 
	 * @param list
	 * @param m
	 * @return
	 */
	public static LinkedNode findMthElement(LinkedNode list, int m){
		LinkedNode p1 = list;
		LinkedNode p2 = list;
		int count = 0;
		while(p1 != null){
			if(count > m){
				p2 = p2.next;
			}
			p1 = p1.next;
			
			count++;
			
		}
		
		//case where mth element does not exist
		if(count < m)
			return null;
		
		return p2;
	}
	
	/**
	 * Testing each of the Linked List Operations
	 * @param args
	 */
	public static void main(String args[]){
		LinkedNode head = new LinkedNode();
		head.data = 0;
		
		for(int i = 1; i<=10; i++){
			LinkedNode node = new LinkedNode();
			node.data = i;
			head = insertHead(head, node);
		}
		
		System.out.println(head);
		
		int m = 2;
		System.out.println(m+"th element: "+findMthElement(head,m));
		
		
		//......test the cycle test method
		LinkedNode headCycle = new LinkedNode();
		head.data = 0;
		LinkedNode node = null;
		
		//constructing the list
		for(int i = 1; i<=11; i++){

			
			if(i < 11){
				node = new LinkedNode();
				node.data = i;
				headCycle = insertHead(headCycle, node);
			}else{
				headCycle.next = node;
			}
		}
		
		boolean hasCycle = hasCycle(headCycle);
		
		System.out.println("has cycle: "+hasCycle);
		
		
		


	}

}
