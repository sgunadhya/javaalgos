package javaalgos;

public class LLists {
	public static class ListNode {
		int data;
		ListNode next;
		public ListNode(int data) {
			this.data = data;
		}
		
		public ListNode(int data, ListNode l) {
			this.data = data;
			this.next = l;
		}
	}
	
	public static ListNode mergeSortedLinkedLists(ListNode a, ListNode b) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		ListNode p1 = a;
		ListNode p2 = b;
		while(p1 != null && p2 != null) {
			if(p1.data < p2.data) {
				current.next = p1;
				p1 = p1.next;
			}else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		current.next = p1 == null? p2 : p1;
		return dummyHead.next;
	}
	
	public static ListNode reverseLinkedSublist(ListNode h, int s, int e) {
		ListNode dummyHead = new ListNode(0, h);
		ListNode lh = dummyHead;
		//Get the s-th node
		int k = 1;
		while(k++ < s) {
			lh = lh.next;
		}
		
		//reverse
		ListNode li = lh.next;
		while(s++ < e) {
			ListNode tmp = li.next;
			li.next = tmp.next;
			tmp.next = lh.next;
			lh.next = tmp;
		}
		return dummyHead.next;
	}
	
	public static boolean hasCycle(ListNode a) {
		ListNode slow = a;
		ListNode fast = a;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteNode(ListNode a) {
		a.data = a.next.data;
		a.next = a.next.next;
	}
}