package javaalgos.adt;

public class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    private int capacity;

    public TrieNode(int capacity) {
        this.capacity = capacity;
        children = new TrieNode[capacity];
        isWord = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }
}
