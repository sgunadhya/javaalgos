package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class BinTreesTest {
    @Test
    public void testIsTreeBalanced() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(2,
                new BinTrees.TreeNode(3, null, null),
                new BinTrees.TreeNode(4, null, null)),
                new BinTrees.TreeNode(5, new BinTrees.TreeNode(6, null, null), new BinTrees.TreeNode(7, null, null)));
        assertTrue(BinTrees.isTreeBalanced(t));
    }

    @Test
    public void testIsTreeSymmetric() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(2,
                new BinTrees.TreeNode(3, null, null),
                new BinTrees.TreeNode(4, null, null)),
                new BinTrees.TreeNode(2, new BinTrees.TreeNode(3, null, null), new BinTrees.TreeNode(4, null, null)));
        assertTrue(BinTrees.isTreeSymmetric(t));
    }

    @Test
    public void testLowestCommonAncestor() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(7,
                new BinTrees.TreeNode(9, null, null),
                new BinTrees.TreeNode(10, null, null)),
                new BinTrees.TreeNode(2, new BinTrees.TreeNode(3, null, null), new BinTrees.TreeNode(4, null, null)));
        BinTrees.TreeNode n = BinTrees.lowestCommonAncestor(t, 2, 3);
        assertNotNull(n);
        assertEquals(n.v, 2);
    }

    @Test
    public void testLowestCommonAncestorWithP() {
        BinTrees.TreeNodeP root = new BinTrees.TreeNodeP(1);
        BinTrees.TreeNodeP leftR = new BinTrees.TreeNodeP(2);
        BinTrees.TreeNodeP rightR = new BinTrees.TreeNodeP(3);
        BinTrees.TreeNodeP leftRL = new BinTrees.TreeNodeP(4);
        BinTrees.TreeNodeP leftRR = new BinTrees.TreeNodeP(5);

        root.parent = null;
        root.left = leftR;
        root.right = rightR;

        leftR.parent = root;
        leftR.left = leftRL;
        leftR.right = leftRR;

        rightR.parent = root;
        rightR.left = null;
        rightR.right = null;

        leftRL.left = null;
        leftRL.right = null;
        leftRL.parent = leftR;

        leftRR.left = null;
        leftRR.right = null;
        leftRR.parent = leftR;


        BinTrees.TreeNodeP n = BinTrees.lowestCommonAncestorWithParent(root, rightR, leftRR);
        assertNotNull(n);
        assertEquals(root, n);

    }

    @Test
    public void testSumBinaryNumbers() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(0,
                new BinTrees.TreeNode(1, null, null),
                new BinTrees.TreeNode(0, null, null)),
                new BinTrees.TreeNode(0, null, null));
        List<Integer> l = BinTrees.sumsOfBinNumbers(t);
        assertTrue(l.size() == 3);
    }


    @Test
    public void testTargetSum() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(0,
                new BinTrees.TreeNode(2, null, null),
                new BinTrees.TreeNode(3, null, null)),
                new BinTrees.TreeNode(7, null, null));
        assertTrue(BinTrees.targetSum(t, 4));
    }
	

	//Leet code 545
    @Test
    public void testBinaryTreeBoundary() {
        BinTrees.TreeNode t = new BinTrees.TreeNode(1, null, new BinTrees.TreeNode(2,
                new BinTrees.TreeNode(3, null, null),
                new BinTrees.TreeNode(4, null, null)));
        assertTrue(4 == BinTrees.boundary(t).size());
    }

    // @Test
// 	public void testInOrderIterative() {
// 		BinTrees.TreeNode t = new BinTrees.TreeNode(1, new BinTrees.TreeNode(0,
// 			new BinTrees.TreeNode(2, null, null),
// 				new BinTrees.TreeNode(3, null, null)),
// 					new BinTrees.TreeNode(7, null, null));
// 		BinTrees.inOrderInterative(t);
//
// 	}


}