package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class TreesTest {

    @Test
    public void testToGraphFromPredecessorArray() {
        int[] pA = new int[]{-1, 0, 1, 0, 2, 3};
        Map<Integer, List<Integer>> g = Trees.toGraphFromArray(pA);
        assertTrue(g.get(0).size() == 2);
        assertTrue(g.get(1).size() == 1);
        assertTrue(g.get(2).size() == 1);
        assertTrue(g.get(3).size() == 1);
    }

    @Test
    public void testGraphToPredecessorArray() {
        Map<Integer, List<Integer>> g = new HashMap<>();
        g.put(0, Arrays.asList(1, 3));
        g.put(1, Arrays.asList(2));
        g.put(2, Arrays.asList(4));
        g.put(3, Arrays.asList(5));
        g.put(4, Collections.EMPTY_LIST);
        g.put(5, Collections.EMPTY_LIST);
        int[] pA = Trees.toArrayFromGraph(g);
        assertTrue(pA[1] == 0);
        assertTrue(pA[2] == 1);
        assertTrue(pA[3] == 0);
        assertTrue(pA[4] == 2);
        assertTrue(pA[5] == 3);
    }

    @Test
    public void testHuffmanEncoding() {
        Map<Character, Integer> charFrequency = new HashMap<>();
        charFrequency.put('a', 5);
        charFrequency.put('b', 9);
        charFrequency.put('c', 12);
        charFrequency.put('d', 13);
        charFrequency.put('e', 16);
        charFrequency.put('f', 45);
        Map<Character, String> r = new HashMap<>();
        r.put('f', "0");
        r.put('c', "100");
        r.put('d', "101");
        r.put('a', "1100");
        r.put('b', "1101");
        r.put('e', "111");
        Map<Character, String> a = Trees.huffmanEncoding(charFrequency);
        for (Map.Entry<Character, String> e : r.entrySet()) {
            assertEquals(e.getValue(), a.get(e.getKey()));
        }

    }

    @Test
    public void testLeastCommonAncestor() {
        int[] pA = new int[]{-1, 0, 1, 1, 0};
        int a = Trees.commonAncestor(pA, 2, 4);
        assertTrue(a == 0);
    }
}