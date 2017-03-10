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
	
	public static void main(String args[]){
		LinkedNode head = new LinkedNode();
		head.data = 0;
		
		for(int i = 1; i<=10; i++){
			LinkedNode node = new LinkedNode();
			node.data = i;
			head = insertHead(head, node);
		}
		
		System.out.println(head);


	}

}
