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
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
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

BinaryTreeNode a = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4), new BinaryTreeNode(5)), new BinaryTreeNode(3, new BinaryTreeNode(6), new BinaryTreeNode(7)));
