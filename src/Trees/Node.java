package Trees;

public class Node {
	Node left;
	Node right;
	int data;
	
	public Node(){}
	
	public Node(int data){
		this.data = data;
	}
	
	public boolean greater(Node node){
		if(node.data < this.data){
			return true;
		}
		return false;
	}
	
	public boolean equal(Object node){
		Node temp;
		if(node instanceof Node){
			temp = (Node)node;
		}else{
			return false;
		}
		
		
		if(this.data == temp.data){
			return true;
		}else{
			return false;
		}
	}
	
	public void setLeft(Node node){
		this.left = node;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public void setRight(Node node){
		this.right = node;
	}
	
	public Node getRight(){
		return right;
	}
	
	public String toString(){
		return "["+data+"]";
	}

}
