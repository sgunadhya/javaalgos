package javaalgos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class BinarySearchesTest {
	
	@Test
	public void testWhenTheElementIsAtTheRightEnd() {
		int[] s = new int[] {1,2,3,4,5,6,7,8,9};
		int k = BinarySearches.findGreatestIndex(s, 8);
		assertTrue(k == 7);
	}

	@Test
	public void testWhenTheElementIsAtTheLeftEnd() {
		int[] s = new int[] {1,2,3,4,5,6,7,8,9};
		int k = BinarySearches.findGreatestIndex(s, 2);
		assertTrue(k == 1);
	}
		
	@Test
	public void testWhenTheElementIsNotPresentRight() {
		int[] s = new int[] {1,2,3,4,5,6,7,8,9};
		int k = BinarySearches.findGreatestIndex(s, 12);
		assertTrue(k == 8);
	}
	
	@Test
	public void testWhenTheElementIsNotPresentLeft() {
		int[] s = new int[] {1,2,3,4,5,6,7,8,9};
		int k = BinarySearches.findGreatestIndex(s, 0);
		assertTrue(k == 0);
	}
	
	
}