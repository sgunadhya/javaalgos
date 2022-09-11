package javaalgos.adt;

public class SegmentTree {
    private int[] tree;
    private int[] array;

    public SegmentTree(int[] array) {
        this.array = array;
        tree = new int[4 * array.length];
        build(1, 0, array.length - 1);
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = array[left];
        } else {
            int middle = (left + right) / 2;
            build(2 * node, left, middle);
            build(2 * node + 1, middle + 1, right);
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public int query(int left, int right) {
        return query(1, 0, array.length - 1, left, right);
    }

    private int query(int node, int left, int right, int i, int j) {
        if (i > right || j < left) {
            return Integer.MAX_VALUE;
        }
        if (left >= i && right <= j) {
            return tree[node];
        }
        int middle = (left + right) / 2;
        int leftMin = query(2 * node, left, middle, i, j);
        int rightMin = query(2 * node + 1, middle + 1, right, i, j);
        return Math.min(leftMin, rightMin);
    }

    public void update(int index, int value) {
        update(1, 0, array.length - 1, index, value);
    }

    private void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            tree[node] = value;
        } else {
            int middle = (left + right) / 2;
            if (index <= middle) {
                update(2 * node, left, middle, index, value);
            } else {
                update(2 * node + 1, middle + 1, right, index, value);
            }
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SegmentTree segmentTree = new SegmentTree(array);
        System.out.println(segmentTree.query(100, 1000));
        segmentTree.update(0, 10);
        System.out.println(segmentTree.query(0, 9));
    }
}
