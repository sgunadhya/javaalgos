package javaalgos;

import java.util.List;
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
	
	public static boolean isValidBST(BSTNode a) {
		return false;
	}
	
	public static int findFirstKeyGreaterThan(BSTNode a, int k) {
		return 0;
	}
	
	public static BSTNode findLCA(BSTNode t, BSTNode a, BSTNode b) {
		return t;
	}
	
	public static BSTNode buildMinHeightBST(int[] a) {
		return null;
	}
	
	public static List<Integer> kLargest(BSTNode a, int k) {
		return null;
	}
	
	public static List<Integer> closesEntries(int[] a, int[] b, int[] c) {
		return null;
	}
}