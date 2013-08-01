package ece750.immutable.binarytree;

public class SimpleBinaryTree {
	private class Node{
		private Node left;
		private Node right; 
		
		public Node(){
		}
		
		public void setLeft(Node left){
			this.left = left;
		}
		
		public void setRight(Node right){
			this.right = right;
		}
		
		public Node getleft(){
			return this.left;
		}
		
		public Node getRight(){
			return this.right;
		}
	}
	
	private final Node head = new Node();
}
