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


	}

}
