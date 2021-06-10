package javaalgos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TreesTest {
	
	@Test
	public void testToGraphFromPredecessorArray() {
		int[] pA = new int[]{-1, 0,1,0,2,3};
		Map<Integer, List<Integer>> g = Trees.toGraphFromArray(pA);
		assertTrue(g.get(0).size() == 2);
		assertTrue(g.get(1).size() == 1);
		assertTrue(g.get(2).size() == 1);
		assertTrue(g.get(3).size() == 1);
	}
}