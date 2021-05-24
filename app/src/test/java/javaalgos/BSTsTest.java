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
		
	}
	
	@Test public void testAdditionalCreditsProblem() {
		
	}
} 