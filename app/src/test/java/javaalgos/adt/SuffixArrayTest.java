package javaalgos.adt;

import junit.framework.TestCase;
import org.junit.Test;

public class SuffixArrayTest extends TestCase {

    @Test
    public void testLcp() {
        SuffixArray array = new SuffixArray("banana");
        assertEquals(array.lcp()[0], 1);
        assertEquals(array.lcp()[1], 3);
        assertEquals(array.lcp()[2], 0);
    }

    @Test
    public void testSuffixArray() {
        SuffixArray array = new SuffixArray("banana");
        assertEquals(array.index(0), 5);
        assertEquals(array.index(1), 3);
        assertEquals(array.index(2), 1);
        assertEquals(array.index(3), 0);
        assertEquals(array.index(4), 4);
    }
    public void testLongestRepeatingSubstring() {
        SuffixArray a = new SuffixArray("banana");
        assertEquals(a.longestRepeatingSubstring(), "ana");
    }

    public void testIndexOf() {
    }
}