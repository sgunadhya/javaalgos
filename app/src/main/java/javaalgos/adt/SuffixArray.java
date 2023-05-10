package javaalgos.adt;

import java.util.RandomAccess;

/**
 * Class representing a suffix array.
 */
public class SuffixArray implements RandomAccess {
    private final String text;
    private final int[] suffixArray;

    /**
     * Constructs a suffix array from a given string.
     *
     * @param text the string to construct the suffix array from
     */
    public SuffixArray(String text) {
        this.text = text;
        this.suffixArray = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            suffixArray[i] = i;
        }
        sort(0, text.length() - 1, 0);
    }

    private void sort(int lo, int hi, int d) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        int pivot = charAt(suffixArray[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int c = charAt(suffixArray[i], d);
            if (c < pivot) {
                exchange(lt++, i++);
            } else if (c > pivot) {
                exchange(i, gt--);
            } else {
                i++;
            }
        }
        sort(lo, lt - 1, d);
        if (pivot >= 0) {
            sort(lt, gt, d + 1);
        }
        sort(gt + 1, hi, d);
    }

    private void exchange(int i, int i1) {
        int temp = suffixArray[i];
        suffixArray[i] = suffixArray[i1];
        suffixArray[i1] = temp;
    }

    private int charAt(int i, int d) {
        return i + d < text.length() ? text.charAt(i + d) : -1;
    }

    public int[] lcp() {
        int[] lcp = new int[text.length()];
        int[] rank = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            rank[suffixArray[i]] = i;
        }
        int h = 0;
        for (int i = 0; i < text.length(); i++) {
            if (rank[i] == text.length() - 1) {
                h = 0;
                continue;
            }
            int j = suffixArray[rank[i] + 1];
            while (i + h < text.length() && j + h < text.length() && text.charAt(i + h) == text.charAt(j + h)) {
                h++;
            }
            lcp[rank[i]] = h;
            if (h > 0) {
                h--;
            }
        }
        return lcp;
    }

    /**
     * Return longest repeating substring.
     */
    public String longestRepeatingSubstring() {
        int[] lcp = lcp();
        int max = 0;
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (lcp[i] > max) {
                max = lcp[i];
                index = i;
            }
        }
        return text.substring(suffixArray[index], suffixArray[index] + max);
    }

    /**
     * Find the index of matching substring.
     */

    public int indexOf(String s) {
        int lo = 0;
        int hi = text.length() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = text.substring(suffixArray[mid]).compareTo(s);
            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Returns the length of the string this suffix array was constructed from.
     *
     * @return the length of the string this suffix array was constructed from
     */
    public int length() {
        return text.length();
    }

    /**
     * Returns the index of the i-th suffix.
     *
     * @param i the index of the suffix to return
     * @return the index of the i-th suffix
     */
    public int index(int i) {
        return suffixArray[i];
    }

}
