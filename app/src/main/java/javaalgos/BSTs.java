package javaalgos;

import java.util.List;
import java.util.ArrayList;
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
		BSTNode h = a.data > b.data ? a : b;
		BSTNode l = a.data > b.data ? b : a;
		BSTNode s = t;
		while(s.data < l.data || s.data > h.data) {
			while(s.data < l.data) {
				s = s.right;
			}
			
			while(s.data > h.data) {
				s = s.left;
			}
		}
		return s;
	}
	
	public static BSTNode buildMinHeightBST(int[] a) {
		return minHeightBSTHelper(a, 0, a.length);
	}
	
	private static BSTNode minHeightBSTHelper(int[] a, int s, int e) {
		if(s >= e) {
			return null;
		}
		int mid = s + (e - s)/2;
		return new BSTNode(a[mid], minHeightBSTHelper(a, s, mid), minHeightBSTHelper(a, mid + 1, e));
	}
	
	public static List<Integer> kLargest(BSTNode a, int k) {
		List<Integer> r = new ArrayList<>();
		kLargestHelper(a, k, r);
		return r;
	}
	
	private static void kLargestHelper(BSTNode a, int k, List<Integer> r) {
		if(a != null && r.size() < k) {
			kLargestHelper(a.right, k, r);
			if(r.size() < k) {
				r.add(a.data);
				kLargestHelper(a.left, k, r);
			}
		}
	}
	
	public static List<Integer> closesEntries(int[] a, int[] b, int[] c) {
		return new ArrayList<>();
	}
	
	public static List<Integer> findInRange(BSTNode a, int s, int e) {
		List<Integer> r = new ArrayList<>();
		findInRangeHelper(a, s, e, r);
		return r;
	}
	
	public static void findInRangeHelper(BSTNode a, int s, int e, List<Integer> r) {
		if(a == null) {
			return;
		}
		if(a.data >= s && a.data <= e) {
			findInRangeHelper(a.left, s, e, r);
			r.add(a.data);
			findInRangeHelper(a.right, s, e, r);
		}else if(a.data < s) {
			findInRangeHelper(a.right, s, e, r);
		}else {
			findInRangeHelper(a.left, s, e, r);
		}
	}
	
	public static void toGreaterTree(BSTNode a) {
		return;
	}
}