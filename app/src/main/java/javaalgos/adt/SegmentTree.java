package javaalgos.adt;

public class SegmentTree<T extends Comparable<T>>{
    private T[] tree;
    private T[] array;
    private int capacity;
    private int size;

    public SegmentTree(T[] array) {
        this.array = array;
        this.capacity = array.length;
        this.size = 0;
        this.tree = (T[]) new Comparable[capacity * 2];
        buildTree();
    }

    private void buildTree() {
        System.arraycopy(array, 0, tree, capacity + 0, array.length);
        for (int i = capacity - 1; i > 0; i--) {
            tree[i] = max(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    private T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public T rangeMax(int l, int r) {
        l += capacity;
        r += capacity;
        T max = tree[l];
        while (l <= r) {
            if (l % 2 == 1) {
                max = max(max, tree[l]);
                l++;
            }
            if (r % 2 == 0) {
                max = max(max, tree[r]);
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return max;
    }

    public void update(int i, T value) {
        i += capacity;
        tree[i] = value;
        while (i > 1) {
            i /= 2;
            tree[i] = max(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public void printTree() {
        for (T t : tree) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = {1, 5, 3, 2, 4, 7, 6, 8, 9};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(array);
        segmentTree.printTree();
        segmentTree.update(3, 10);
        segmentTree.printTree();
        System.out.println(segmentTree.rangeMax(1, 5));
    }
}
