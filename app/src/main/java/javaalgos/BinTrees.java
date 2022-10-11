package javaalgos;

import com.sun.source.tree.Tree;

import java.util.*;

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

        public TreeNode(int v) {
            this.v = v;
        }
    }

    public static class TreeNodeP {
        int v;
        TreeNodeP left;
        TreeNodeP right;
        TreeNodeP parent;

        public TreeNodeP(int v) {
            this.v = v;
        }

        public TreeNodeP(int v, TreeNodeP l, TreeNodeP r, TreeNodeP p) {
            this.v = v;
            this.left = l;
            this.right = r;
            this.parent = p;
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

    public static class LCAResult {
        int n;
        TreeNode parent;

        public LCAResult(int n, TreeNode p) {
            this.n = n;
            this.parent = p;
        }

        public String toString() {
            return this.n + "...." + this.parent.v;
        }

    }

    public static boolean isTreeBalanced(TreeNode t) {
        return isBalanced(t).r;
    }

    public static boolean isTreeSymmetric(TreeNode t) {
        return isSymmetric(t, t);
    }

    public static TreeNode lowestCommonAncestor(TreeNode t, int a, int b) {
        LCAResult r = lca(t, a, b);
        // System.out.println(r);
        return r.parent;
    }

    public static TreeNodeP lowestCommonAncestorWithParent(TreeNodeP root, TreeNodeP i, TreeNodeP j) {
        int d1 = depth(i);
        int d2 = depth(j);
        if (d2 > d1) {
            TreeNodeP temp = i;
            i = j;
            j = temp;
        }
        int diff = Math.abs(d1 - d2);
        while (diff > 0) {
            i = i.parent;
            diff--;
        }
        while (i != j) {
            i = i.parent;
            j = j.parent;
        }
        return i;
    }

    public static List<Integer> sumsOfBinNumbers(TreeNode t) {
        List<Integer> l = new ArrayList<>();
        getSums(t, 0, l);
        return l;
    }

    public static boolean targetSum(TreeNode t, int target) {
        return targetS(t, 0, target);
    }

    public static void inOrderTraversal(TreeNode t) {
        Stack<TreeNode> s = new Stack<>();

    }

    private static boolean targetS(TreeNode t, int partSum, int target) {
        if (t == null) {
            return false;
        }
        partSum += t.v;
        if (t.left == null && t.right == null) {
            System.out.println(partSum);
            return partSum == target;
        }
        return targetS(t.left, partSum, target) || targetS(t.right, partSum, target);
    }

    private static int getSums(TreeNode t, int partSum, List<Integer> sums) {
        if (t == null) {
            return 0;
        }
        partSum = 2 * partSum + t.v;
        if (t.left == null && t.right == null) {
            sums.add(partSum);
        }

        return getSums(t.left, partSum, sums) +
                getSums(t.right, partSum, sums);

    }


    private static int depth(TreeNodeP n) {
        int d = 0;
        while (n.parent != null) {
            d++;
            n = n.parent;
        }
        return d;
    }

    private static LCAResult lca(TreeNode t, int a, int b) {
        if (t == null) {
            return new LCAResult(0, null);
        }
        LCAResult left = lca(t.left, a, b);
        if (left.n == 2) {
            return left;
        }
        LCAResult right = lca(t.right, a, b);
        if (right.n == 2) {
            return right;
        }

        int n = left.n + right.n + (t.v == a ? 1 : 0) + (t.v == b ? 1 : 0);
        return new LCAResult(n, n == 2 ? t : null);


    }

    private static boolean isSymmetric(TreeNode tl, TreeNode tr) {
        if (tl == tr) {
            return true;
        }
        if (tl == null || tr == null) {
            return false;
        }

        return tl.v == tr.v && isSymmetric(tl.left, tl.right) && isSymmetric(tl.right, tl.left);
    }

    private static BResult isBalanced(TreeNode t) {
        if (t == null) {
            return new BResult(0, true);
        }

        BResult left = isBalanced(t.left);
        BResult right = isBalanced(t.right);
        boolean isB = Math.abs(left.h - right.h) <= 1;
        int h = Math.max(left.h, right.h);
        return new BResult(h, isB && left.r && right.r);
    }
	
	public static List<Integer> boundary(TreeNode t) {
        List<Integer> r = new ArrayList<>();

        if (t == null) {
            return r;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(t);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode v = q.poll();
                if (v.left == null && v.right == null) {
                    r.add(v.v);
                } else if (i == 0 || i == s - 1) {
                    r.add(v.v);
                }
                if (v.left != null) {
                    q.offer(v.left);
                }
                if (v.right != null) {
                    q.offer(v.right);
                }
            }
        }
        return r;
    }


    public static TreeNode makeBinaryTree(int[] inorder, int inOrderStart, int inOrderEnd, int[] preorder,
                                          int preorderStart, int preorderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }
        int root = preorder[preorderStart];
        int rootIndex = -1;
        int j = 0;
        while(j < inorder.length) {
            if (inorder[j] == root) {
                rootIndex = j;
                break;
            }
            j++;
        }
        TreeNode t = new TreeNode(root);
        t.left = makeBinaryTree(inorder, inOrderStart, rootIndex - 1, preorder, preorderStart + 1, preorderStart + rootIndex - inOrderStart);
        t.right = makeBinaryTree(inorder, rootIndex + 1, inOrderEnd, preorder, preorderStart + rootIndex - inOrderStart + 1, preorderEnd);
        return t;
    }

    public TreeNode constuctBinaryTree(int[] preorder, int[] inorder) {
        return makeBinaryTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    public TreeNode constructBinaryTreeFromPostOrder(int[] postorder, int[] inorder) {
        return makeBinaryTreeFromPostOrder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode makeBinaryTreeFromPostOrder(int[] inorder, int i, int i1, int[] postorder, int i2, int i3) {
        if (i > i1) {
            return null;
        }
        int root = postorder[i3];
        int rootIndex = -1;
        for (int j = i; j <= i1; j++) {
            if (inorder[j] == root) {
                rootIndex = j;
                break;
            }
        }
        TreeNode t = new TreeNode(root);
        t.left = makeBinaryTreeFromPostOrder(inorder, i, rootIndex - 1, postorder, i2, i2 + rootIndex - i - 1);
        t.right = makeBinaryTreeFromPostOrder(inorder, rootIndex + 1, i1, postorder, i2 + rootIndex - i, i3 - 1);
        return t;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, a, b);
        TreeNode r = lowestCommonAncestor(root.right, a, b);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }
}