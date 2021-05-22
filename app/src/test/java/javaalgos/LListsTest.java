package javaalgos;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class LListsTest {
	
	LLists.ListNode a;
	
	@Before public void init() {
		this.a = new LLists.ListNode(2);
		LLists.ListNode b = new LLists.ListNode(4);
		LLists.ListNode c = new LLists.ListNode(6);
		LLists.ListNode d = new LLists.ListNode(8);
		LLists.ListNode e = new LLists.ListNode(10);
		this.a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;	
	}
	
	@Test public void testMergeSortedLinkedLists() {
		LLists.ListNode a = new LLists.ListNode(2);
		LLists.ListNode b = new LLists.ListNode(4);
		LLists.ListNode c = new LLists.ListNode(6);
		a.next = b;
		b.next = c;
		
		LLists.ListNode x = new LLists.ListNode(1);
		LLists.ListNode y = new LLists.ListNode(3);
		LLists.ListNode z = new LLists.ListNode(5);
		x.next = y;
		y.next = z;
		
		LLists.ListNode m = LLists.mergeSortedLinkedLists(x, a);
		assertTrue("Return value should not be null", m != null);
		assertTrue("First node value should be 1", m.data == 1);
		assertTrue("Second node value should be 2", m.next.data == 2);
		assertTrue("Third node value should be 3", m.next.next.data == 3);
		assertTrue(m.next.next.next.data == 4);
		assertTrue(m.next.next.next.next.data == 5);
		assertTrue(m.next.next.next.next.next.data == 6);
		assertTrue(m.next.next.next.next.next.next == null);
	}
	
	
	@Test public void testReverseSublistLinkedList() {
		LLists.ListNode a1 = new LLists.ListNode(1);
		LLists.ListNode a2 = new LLists.ListNode(2, a1);
		LLists.ListNode a3 = new LLists.ListNode(3, a2);
		LLists.ListNode a4 = new LLists.ListNode(4, a3);
		LLists.ListNode a5 = new LLists.ListNode(5, a4);
		LLists.ListNode a6 = new LLists.ListNode(6, a5);
		LLists.ListNode a7 = new LLists.ListNode(7, a6);
		LLists.ListNode a8 = new LLists.ListNode(8, a7);
		LLists.ListNode a9 = new LLists.ListNode(9, a8);
		
		LLists.ListNode head = LLists.reverseLinkedSublist(a9, 2, 5);
		assertTrue(head != null);
		assertTrue(head.next.data == 5);
		assertTrue(head.next.next.data == 6);
		assertTrue(head.next.next.next.data == 7);
		assertTrue(head.next.next.next.next.data == 8);
		assertTrue(head.next.next.next.next.next.data == 4);
		assertTrue(head.next.next.next.next.next.next.data == 3);
		assertTrue(head.next.next.next.next.next.next.next.data == 2);
		assertTrue(head.next.next.next.next.next.next.next.next.data == 1);
	}
	
	@Test public void findCycle() {
		LLists.ListNode a = new LLists.ListNode(2);
		LLists.ListNode b = new LLists.ListNode(4);
		LLists.ListNode c = new LLists.ListNode(6);
		LLists.ListNode d = new LLists.ListNode(8);
		LLists.ListNode e = new LLists.ListNode(10);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = b;
		boolean hasCycle = LLists.hasCycle(a);
		assertTrue("The linked list has cycles", hasCycle);
	}
	
	@Test public void testDeleteNodeFromLinkedList() {
		LLists.ListNode a = new LLists.ListNode(2);
		LLists.ListNode b = new LLists.ListNode(4);
		LLists.ListNode c = new LLists.ListNode(6);
		LLists.ListNode d = new LLists.ListNode(8);
		LLists.ListNode e = new LLists.ListNode(10);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLists.deleteNode(c); 
		assertFalse("Value of c should be as d", c.data == 6);
		assertTrue(c.next == e);
	}
	
	@Test public void testDeleteKthLastElementFromLinkedList() {
		LLists.deleteKthLast(this.a, 2);
		assertTrue("2nd last element should be deleted "+this.a.next.next.next.data,this.a.next.next.next.data == 10);
	}
	
	@Test public void testRemoveDuplicateValuesFromLinkedList() {
		LLists.ListNode a = new LLists.ListNode(2);
		LLists.ListNode b = new LLists.ListNode(2);
		LLists.ListNode c = new LLists.ListNode(4);
		LLists.ListNode d = new LLists.ListNode(4);
		LLists.ListNode e = new LLists.ListNode(8);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLists.removeDuplicates(a);
		assertTrue(a.next.data == 4);
		assertTrue(a.next.next.data == 8);
	}
	
	
	@Test public void testCyclicShiftLinkedList() {
		LLists.ListNode a = new LLists.ListNode(1);
		LLists.ListNode b = new LLists.ListNode(2);
		LLists.ListNode c = new LLists.ListNode(3);
		LLists.ListNode d = new LLists.ListNode(4);
		LLists.ListNode e = new LLists.ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLists.ListNode a1 = LLists.cyclicShift(a, 2);
		assertTrue("1 "+a1.data,a1.data == 4);
		assertTrue("2",a1.next.data == 5);
        assertTrue("3",a1.next.next.data == 1);
		assertTrue("4",a1.next.next.next.data == 2);
		assertTrue("5",a1.next.next.next.next.data == 3);
	}
	
	@Test public void testEvenOddMerge() {
		LLists.ListNode a = new LLists.ListNode(1);
		LLists.ListNode b = new LLists.ListNode(2);
		LLists.ListNode c = new LLists.ListNode(3);
		LLists.ListNode d = new LLists.ListNode(4);
		LLists.ListNode e = new LLists.ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLists.ListNode r = LLists.evenOddMerge(a);
		assertTrue(r.data == 2);
		assertTrue(r.next.data == 4);
		assertTrue(r.next.next.data == 1);
		assertTrue(r.next.next.next.data == 3);
		assertTrue(r.next.next.next.next.data == 5);		
	}
	
	@Test public void testIsLinkedListPalindromic() {
		LLists.ListNode a = new LLists.ListNode(1);
		LLists.ListNode b = new LLists.ListNode(2);
		LLists.ListNode c = new LLists.ListNode(3);
		LLists.ListNode d = new LLists.ListNode(2);
		LLists.ListNode e = new LLists.ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		assertTrue(LLists.isPalindrome(a));
	}
	
	@Test public void testLinkedListPivoting() {
		LLists.ListNode a = new LLists.ListNode(3);
		LLists.ListNode b = new LLists.ListNode(2);
		LLists.ListNode c = new LLists.ListNode(3);
		LLists.ListNode d = new LLists.ListNode(1);
		LLists.ListNode e = new LLists.ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLists.ListNode a1 = LLists.pivotLinkedList(a, 2);
		assertTrue(a1.data == 1);
		assertTrue(a1.next.data == 2);
		assertTrue(a1.next.next.data == 3);
		assertTrue(a1.next.next.next.data == 3);
		assertTrue(a1.next.next.next.next.data == 3);
	}
	 

}