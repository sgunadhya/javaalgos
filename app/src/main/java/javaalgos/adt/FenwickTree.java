package javaalgos.adt;

public class FenwickTree {
    private int capacity;
    private int size;
    private int[] tree;

    public FenwickTree(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        tree = new int[capacity];
    }

    public FenwickTree(int capacity, int[] array) {
        this.capacity = capacity;
        this.size = array.length;
        tree = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            tree[i] = array[i];
        }
    }

    public void add(int index, int value) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        tree[index] = value;
        size++;
    }

    public int get(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        return tree[index];
    }

    public int sum(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        int sum = tree[0];
        for (int i = 1; i <= index; i++) {
            sum = sum + tree[i];
        }
        return sum;
    }

    public int sum(int from, int to) {
        if (from >= capacity || to >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        int sum = tree[from];
        for (int i = from + 1; i <= to; i++) {
            sum += tree[i];
        }
        return sum;
    }

    public void update(int index, int value) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        tree[index] = value;
    }

}
