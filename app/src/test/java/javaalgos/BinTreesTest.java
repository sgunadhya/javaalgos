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
	
}