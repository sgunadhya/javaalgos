import java.util.*;

class ListNode {
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int v) { this.val = v;}
    public ListNode(int v, ListNode n) { this.val = v; this.next = n;}
    @Override
    public String toString() {
        return String.format("%d -> %s", this.val, this.next != null ? this.next.toString() : "[]");
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int v) {this.val = v;}
    public BinaryTreeNode(int v, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = v;
        this.left = left;
        this.right = right;
    }
}

class Interval {
    int start;
    int end;
    public Interval(){}
    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.start, this.end);
    }   
}
