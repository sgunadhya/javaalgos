package javaalgos;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class BSTsTest {
	BSTs.BSTNode a;
	
	@Before public void init() {
		BSTs.BSTNode c = new BSTs.BSTNode(3,new BSTs.BSTNode(2, null, null), new BSTs.BSTNode(5, null, null));
		BSTs.BSTNode f = new BSTs.BSTNode(11, null, new BSTs.BSTNode(17, new BSTs.BSTNode(13, null, null),null));
		BSTs.BSTNode b = new BSTs.BSTNode(7, c, f);
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
		
	}
	
	@Test public void testFindFirstKeyGreaterThanAValue() {
		
	}
	
	@Test public void testFindkLargestElements() {
		
	}
	
	@Test public void testGetLCAofTwoNodes() {
		
	}
	
	@Test public void testReconstructBSTFromTraversal() {
		
	}
	
	@Test public void testClosestEntriesInSortedArrays() {
		
	}
	
	@Test public void testMostVisitedPages() {
		
	}
	
	@Test public void testMinimumHeightBSTFromASortedArray() {
		
	}
	
	@Test public void testIfThreeBSTNodesAreTotallyOrdered() {
		
	}
	
	@Test public void testLookupRange() {
		
	}
	
	@Test public void testAdditionalCreditsProblem() {
		
	}
} 