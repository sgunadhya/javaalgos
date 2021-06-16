package javaalgos;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.*;

public class HeapsTest {

    @Test
    public void testSortInputSequencesThatAreAlreadySorted() {
        List<Integer> a = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> b = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> c = Arrays.asList(12, 14, 16, 18, 20);
        List<Integer> d = Arrays.asList(13, 15, 17, 19, 21);
        List<Integer> sorted = Heaps.asSortedList(a, b, c, d);
        for (int i = 0; i < sorted.size(); i++) {
            assertTrue(sorted.get(i) == i + 1);
        }
    }
}