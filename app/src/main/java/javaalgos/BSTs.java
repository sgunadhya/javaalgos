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
		return areKeysInRange(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean areKeysInRange(BSTNode a, Integer lower, Integer upper) {
		if(a == null) {
			return true;
		}else if(Integer.compare(a.data, lower) < 0 || Integer.compare(a.data, upper) > 0) {
			return false;
		}else {
			return areKeysInRange(a.right, a.data, upper)
				&& areKeysInRange(a.left, lower, a.data);
		}
	}
	
	public static int findFirstKeyGreaterThan(BSTNode a, int k) {
		BSTNode subtree = a;
		BSTNode r = null;
		while(subtree != null) {
			if(subtree.data > k) {
				r = subtree;
				subtree = subtree.left;
			}else {
				subtree = subtree.right;
			}
		}
		return r.data;
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