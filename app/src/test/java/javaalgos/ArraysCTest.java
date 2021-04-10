package javaalgos;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArraysCTest {
	
	@Test public void testMergeSorted() {
		int[] r = ArraysC.mergeSorted(new int[]{1,2,3,6,7}, new int[] {4,8,10});
		assertTrue(8 == r.length);
		assertTrue(1 == r[0]);
		assertTrue(4 == r[3]);
	}
	
	@Test public void testFindDuplicateInRange() {
		boolean r = ArraysC.findDuplicateInRange(new char[]{'a', 'b','a','a', 'c' ,'d','b','a','b','c'}, 3, 6);
		assertTrue(r);
	}

	@Test public void testMaximalSum() {
		int r = ArraysC.maximalSum(new int[]{1,2,3,4,5,12,7});
		assertTrue(r ==  34);
	}

	@Test public void testRMTree() {
		ArraysC.RangeMinQ r = new ArraysC.RangeMinQ(new int[]{23,4,5,56,6,1,11,2});
		assertTrue(1 == r.min(0, 7));
		r.set(2, 0);
		assertTrue(0 == r.min(0, 7));
	}
	
	@Test public void testFenwick() {
		ArraysC.Fenwick r = new ArraysC.Fenwick(new int[]{23,4,5,56,6,1,11,2});
		assertTrue(27 == r.prefixSum(1));
	}	 	 
}