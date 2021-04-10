package javaalgos;

public class BinTrees {
	public static class TreeNode {
		int v;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v, TreeNode l, TreeNode r) {
			this.v = v;
			this.left = l;
			this.right = r;
		}
	}
	
	public static class BResult {
		int h;
		boolean r;
		public BResult(int h, boolean r) {
			this.h = h;
			this.r = r;
		}
	}
	
	public static boolean isTreeBalanced(TreeNode t) {		
		return isBalanced(t).r;
	}
	
	public static boolean isTreeSymmetric(TreeNode t) {		
		return isSymmetric(t, t);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode t, int a, int b) {
		return null;
	}
	
	private static boolean isSymmetric(TreeNode tl, TreeNode tr) {
		if(tl == tr) {
			return true;
		}
		if(tl == null || tr == null) {
			return false;
		}
		
		return tl.v == tr. v && isSymmetric(tl.left, tl.right) && isSymmetric(tl.right, tl.left);
	}
	
	private static BResult isBalanced(TreeNode t) {
		if(t == null) {
			return new BResult(0, true);
		}
		
		BResult left = isBalanced(t.left);
		BResult right = isBalanced(t.right);
		boolean isB = Math.abs(left.h  - right.h) <= 1;
		int h = Math.max(left.h, right.h);
		return new BResult(h, isB && left.r && right.r);
	}
}