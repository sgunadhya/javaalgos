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
		
		public String toString() {
			return " "+data;
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
	
	public static void deleteKthLast(ListNode a, int k) {
		ListNode dummyNode = new ListNode(0, a);
		ListNode first = dummyNode.next;
		while(k-- > 0) {
			first = first.next;
		}
		ListNode second = dummyNode.next;
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		deleteNode(second);
	}
	
	public static void removeDuplicates(ListNode a) {
		ListNode iter = a; 
		ListNode u;
		while(iter != null) {
			u = iter.next;
			while(u != null && u.data == iter.data) {
				u = u.next;
			}
			iter.next = u;
			iter = u;
		}
	}
	
	public static ListNode cyclicShift(ListNode a, int k) {
		ListNode tail = a;
		int n = 1;
		while(tail.next != null) {
			tail = tail.next;
			n++;
		}
		tail.next = a;
		int steps = n - (k % n);
		ListNode newTail = tail;
		while(steps-- > 0) {
			newTail = newTail.next;
		}
		ListNode newHead = newTail.next;
		newTail.next = null;
		return newHead;
	}
}