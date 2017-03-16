package Trees;

public class BinarySearchTree {
	
	/*The root node of the tree*/
	public Node root;
	
	/**
	 * Constructor
	 */
	BinarySearchTree(){}
	
	/**
	 * Insert Node
	 * @param node
	 */
	public void insertNode(Node node){
		
		if(root == null){
			root = node;
		}else{
			Node temp = root;
			Node parent = temp;
			boolean parentLess = false;
			
			//find the place to insert
			while(temp != null){
				parent = temp;
				
				if(node.greater(temp)){
					temp = temp.getRight();
					parentLess = true;
				}else {
					temp = temp.getLeft();
					parentLess = false;
				}
				
			}
			
			//make the insertion
			if(parentLess){
				parent.right = node;
			}else{
				parent.left = node;
			}
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	public void printInOrder(Node node){
		if(node.left != null){
			System.out.println("go left");
			printInOrder(node.left);
		}
		System.out.println(node);
		if(node.right != null){
			System.out.println("go right");
			printInOrder(node.right);
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	public void printPreOrder(Node node){
		System.out.println(node);
		if(node.left != null){		
			System.out.println("go left");
			printPreOrder(node.left);
		}
		
		if(node.right != null){
			System.out.println("go right");
			printPreOrder(node.right);
		}
	}
	
	/**
	 * 
	 * @param node
	 */
	public void printPostOrder(Node node){
		
		if(node.left != null){		
			System.out.println("go left");
			printPostOrder(node.left);
		}
		
		if(node.right != null){
			System.out.println("go right");
			printPostOrder(node.right);
		}
		
		System.out.println(node);
	}
	
	/**
	 * get Max
	 * @return
	 */
	public Node getMax(){
		Node max = root;
		Node temp = root;
		while(temp != null){
			max = temp;
			
			temp = temp.right;
			
		}
		return max;
	}
	
	/**
	 * get Min
	 * @return
	 */
	public Node getMin(){
		Node min = root;
		Node temp = root;
		while(temp != null){
			min = temp;
			
			temp = temp.left;
			
		}
		return min;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insertNode(new Node(2));
		bst.insertNode(new Node(5));
		bst.insertNode(new Node(1));
		bst.insertNode(new Node(10));
		bst.insertNode(new Node(12));
		
		System.out.println("---=== In Order (print by sorted order) ===---");
		bst.printInOrder(bst.root);
		
		System.out.println("---=== Pre Order (print by visit) ===---");
		bst.printPreOrder(bst.root);
		
		System.out.println("---=== Post Order (print from leaves up left to right) ===---");
		bst.printPostOrder(bst.root);
		
		System.out.println("---=== Get Max ===---");
		System.out.println(bst.getMax());
		
		System.out.println("---=== Get Min ===---");
		System.out.println(bst.getMin());
	}

}
