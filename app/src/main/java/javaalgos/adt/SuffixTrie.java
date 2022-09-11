package javaalgos.adt;

public class SuffixTrie {
    private TrieNode root;
    private int capacity;

    public SuffixTrie(int capacity) {
        this.capacity = capacity;
        root = new TrieNode(capacity);
    }

    public void put(CharSequence word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChildren()[c] == null) {
                node.getChildren()[c] = new TrieNode(capacity);
            }
            node = node.getChildren()[c];
        }
        node.setWord(true);
    }

    public boolean hasSuffix(CharSequence suffix) {
        TrieNode node = root;
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            if (node.getChildren()[c] == null) {
                return false;
            }
            node = node.getChildren()[c];
        }
        return node.isWord();
    }
}
