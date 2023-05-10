package javaalgos.adt;

import java.util.LinkedList;
import java.util.Queue;

public class SuffixArrayCustom {
    private int[] suffixArray;
    private CharSequence text;

    public SuffixArrayCustom(CharSequence text) {
        this.text = text;
        suffixArray = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            suffixArray[i] = i;
        }
        sort(0, text.length() - 1, 0);
    }

    private int charAt(int index, int offset) {
        return index + offset < text.length() ? text.charAt(index + offset) : -1;
    }

    private void sort(int lo, int hi, int offset) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        int pivot = charAt(suffixArray[lo], offset);
        int i = lo + 1;
        while (i <= gt) {
            int c = charAt(suffixArray[i], offset);
            if (c < pivot) {
                exchange(lt++, i++);
            } else if (c > pivot) {
                exchange(i, gt--);
            } else {
                i++;
            }
        }
        sort(lo, lt - 1, offset);
        if (pivot >= 0) {
            sort(lt, gt, offset + 1);
        }
        sort(gt + 1, hi, offset);

    }

    private void exchange(int i, int j) {
        int temp = suffixArray[i];
        suffixArray[i] = suffixArray[j];
        suffixArray[j] = temp;
    }

    public int length() {
        return suffixArray.length;
    }

    public int index(int i) {
        if (i < 0 || i >= suffixArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return suffixArray[i];
    }

    private int[] lcp() {
        int[] lcp = new int[suffixArray.length];
        lcp[0] = 0;
        for (int i = 1; i < suffixArray.length; i++) {
            lcp[i] = lcp(suffixArray[i], suffixArray[i - 1]);
        }
        return lcp;
    }

    private int lcp(int i, int j) {
        int length = 0;
        while (i < text.length() && j < text.length()) {
            if (text.charAt(i) != text.charAt(j)) {
                break;
            }
            length++;
            i++;
            j++;
        }
        return length;
    }

    public int longestRepeatedSubstring() {
        int max = 0;
        int index = -1;
        int[] lcp = lcp();
        for (int i = 1; i < lcp.length; i++) {
            if (lcp[i] > max) {
                max = lcp[i];
                index = i;
            }
        }
        return index;
    }

    public Iterable<Integer> indices(String query) {
        int lo = rank(query);
        int hi = rank(query + Character.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = lo; i < hi; i++) {
            queue.add(suffixArray[i]);
        }
        return queue;
    }

    public CharSequence select(int i) {
        if (i < 0 || i >= suffixArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return text.subSequence(suffixArray[i], text.length());
    }

    public int rank(CharSequence query) {
        int lo = 0;
        int hi = suffixArray.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = compare(query, suffixArray[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private int compare(CharSequence query, int index) {
        int i = 0;
        int j = index;
        while (i < query.length() && j < text.length()) {
            if (query.charAt(i) != text.charAt(j)) {
                return query.charAt(i) - text.charAt(j);
            }
            i++;
            j++;
        }
        return query.length() - (j - index);
    }

    public int count(String query) {
        int lo = rank(query);
        int hi = rank(query + Character.MAX_VALUE);
        return hi - lo;
    }

    public Iterable<Integer> search(String query) {
        Queue<Integer> queue = new LinkedList<>();
        int lo = rank(query);
        int hi = rank(query + Character.MAX_VALUE);
        for (int i = lo; i < hi; i++) {
            queue.offer(suffixArray[i]);
        }
        return queue;
    }

    public static void main(String[] args) {
        SuffixArrayCustom suffixArray = new SuffixArrayCustom("banana");
        for (int i = 0; i < suffixArray.length(); i++) {
            System.out.println(suffixArray.select(i));
        }
        System.out.println(suffixArray.rank("ana"));
        System.out.println(suffixArray.count("ana"));
        for (int index : suffixArray.search("ana")) {
            System.out.println(index);
        }
    }
}
