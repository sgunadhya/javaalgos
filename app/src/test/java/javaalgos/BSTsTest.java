package javaalgos;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class BSTsTest {
	BSTs.BSTNode a;
	BSTs.BSTNode b;
	BSTs.BSTNode c;
	BSTs.BSTNode f;
	
	@Before public void init() {
		c = new BSTs.BSTNode(3,new BSTs.BSTNode(2, null, null), new BSTs.BSTNode(5, null, null));
		f = new BSTs.BSTNode(11, null, new BSTs.BSTNode(17, new BSTs.BSTNode(13, null, null),null));
		b = new BSTs.BSTNode(7, c, f);
		BSTs.BSTNode i = new BSTs.BSTNode(43, 
			new BSTs.BSTNode(23, null, 
				new BSTs.BSTNode(37, 
					new BSTs.BSTNode(29, null, 
						new BSTs.BSTNode(31, null, null)), 
							new BSTs.BSTNode(41, null, null))), 
								new BSTs.BSTNode(47, null, new BSTs.BSTNode(53, null, null)));
		a = new BSTs.BSTNode(19, b, i);
		 
	}
	
	@Test public void testIsValidBST() {
		assertTrue(BSTs.isValidBST(a));
	}
	
	
	@Test public void testIsValidBSTOverflow() {
		assertTrue(BSTs.isValidBST(new BSTs.BSTNode(2147483647, null, null)));
	}
	
	@Test public void testIsValidBSTOverflowWithEqual() {
		assertFalse(BSTs.isValidBST(new BSTs.BSTNode(2, new BSTs.BSTNode(2, null, null), new BSTs.BSTNode(2, null, null))));
	}
	
	@Test public void testFindFirstKeyGreaterThanAValue() {
		assertTrue(BSTs.findFirstKeyGreaterThan(a, 50) == 53);
	}
	
	@Test public void testFindkLargestElements() {
		List<Integer> r = BSTs.kLargest(a, 3);

		assertTrue(r.contains(53));
		assertTrue(r.contains(47));
		assertTrue(r.contains(43));
	}
	
	@Test public void testGetLCAofTwoNodes() {
		assertTrue(BSTs.findLCA(a, c, f) == b);
	}
	
	@Test public void testReconstructBSTFromTraversal() {
		
	}
	
	@Test public void testClosestEntriesInSortedArrays() {
		List<Integer> r = BSTs.closesEntries(new int[]{5,10,15}, new int[]{3,6,9,12,15}, new int[]{8,16,24});
		assertTrue(r.contains(15));
		assertTrue(r.contains(16));
	}
	
	@Test public void testMostVisitedPages() {
		
	}
	
	@Test public void testMinimumHeightBSTFromASortedArray() {
		BSTs.BSTNode r = BSTs.buildMinHeightBST(new int[]{2,3,5,7,11,13,17,19,23});
		assertTrue(r.data == 11);
	}
	
	@Test public void testIfThreeBSTNodesAreTotallyOrdered() {
		
	}
	
	@Test public void testLookupRange() {
		List<Integer> r = BSTs.findInRange(a, 16, 31);
		int[] x = new int[] {17,19,23,29,31};
		for(int i = 0; i < x.length; i++) {
			assertTrue("r should contain "+x[i], r.contains(x[i]));
		}
	}
	/** LeetCode : 538
		**/
	@Test
	public void testBSTToGreaterTree() {
		BSTs.BSTNode a1 = new BSTs.BSTNode(0, null, new BSTs.BSTNode(1, null, null));
		BSTs.toGreaterTree(a1);
		assertTrue(a1.data == 1);
		assertTrue(a1.left == null);
		assertTrue(a1.right != null);
		assertTrue(a1.right.data == 1);

		BSTs.BSTNode a2 = new BSTs.BSTNode(1, new BSTs.BSTNode(0, null, null), new BSTs.BSTNode(2, null, null));
		BSTs.toGreaterTree(a2);
		assertTrue("First Node", a2.data == 3);
		assertTrue("Second Node", a2.left.data == 3);
		assertTrue("Third Node", a2.right.data == 2);

		BSTs.BSTNode a3 = new BSTs.BSTNode(3, new BSTs.BSTNode(2, new BSTs.BSTNode(1, null, null), null), new BSTs.BSTNode(4, null, null));
		BSTs.toGreaterTree(a3);
		assertTrue("First Node", a3.data == 7);
		assertTrue("Second Node", a3.right.data == 4);
		assertTrue("Third Node", a3.left.data == 9);
		assertTrue("Third Node", a3.left.left.data == 10);
		
		// [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
		BSTs.BSTNode b0 = new BSTs.BSTNode(0);
		BSTs.BSTNode b1 = new BSTs.BSTNode(1);
		BSTs.BSTNode b2 = new BSTs.BSTNode(2);
		BSTs.BSTNode b3 = new BSTs.BSTNode(3);
		BSTs.BSTNode b4 = new BSTs.BSTNode(4);
		BSTs.BSTNode b5 = new BSTs.BSTNode(5);
		BSTs.BSTNode b6 = new BSTs.BSTNode(6);
		BSTs.BSTNode b7 = new BSTs.BSTNode(7);
		BSTs.BSTNode b8 = new BSTs.BSTNode(8);
		b2.right = b3;
		b1.right = b2;
		b1.left = b0;
		b4.left = b1;
		b4.right = b6;
		b6.left = b5;
		b6.right = b7;
		b7.right = b8;
		BSTs.toGreaterTree(b4);
		BSTs.BSTNode[] val = new BSTs.BSTNode[]{b0, b1, b2, b3, b4, b5, b6, b7, b8};
		int[] r = new int[]{36, 36, 35, 33, 30,26, 21, 15, 8};
		for(int i = 0; i < val.length; i++) {
			assertTrue(i+" should be "+r[i]+" : but it is "+val[i].data, r[i] == val[i].data);
		}
			
	}
	
	//Leet Code 1214
	@Test
	public void testTwoSumBST() {
		BSTs.BSTNode b0 = new BSTs.BSTNode(0);
		BSTs.BSTNode b1 = new BSTs.BSTNode(1);
		BSTs.BSTNode b3 = new BSTs.BSTNode(3);
		b1.left = b0;
		b1.right = b3;

		BSTs.BSTNode a2 = new BSTs.BSTNode(2);
		BSTs.BSTNode a1 = new BSTs.BSTNode(1);
		BSTs.BSTNode a4 = new BSTs.BSTNode(4);
		a2.left = a1;
		a2.right = a4;
		assertTrue(BSTs.twoSumBSTs(b1, a2, 5));
		
		BSTs.BSTNode a10 = new BSTs.BSTNode(-300988154, null, 
			new BSTs.BSTNode(740140743, 
				new BSTs.BSTNode(697166207, null, null), 
					new BSTs.BSTNode(818410759, null,
						new BSTs.BSTNode(936731239, null, null))));
		BSTs.BSTNode b10 = new BSTs.BSTNode(-177861296, new BSTs.BSTNode(-534957072, null, null), new BSTs.BSTNode(127474120, null, null));
		assertTrue(BSTs.twoSumBSTs(a10, b10, -478849450));
		
	}
	

} 