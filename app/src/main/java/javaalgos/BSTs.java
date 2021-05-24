package javaalgos;

public class BSTs {
	
	public static class BSTNode {
		int data;
		BSTNode left;
		BSTNode right;
		public BSTNode(int data) {
			this.data = data;
		}
		public BSTNode(int data, BSTNode left, BSTNode right) {
			this.data = data;
			this.right = right;
			this.left = left;
		}
	}
}