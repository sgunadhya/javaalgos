package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequencesTest {

    @Test
    public void testEditDistance() {
        assertTrue(Sequences.editDistance("sunday", "saturday") == 3);
        assertTrue(Sequences.editDistance("cat", "cut") == 1);
        assertTrue(Sequences.editDistance("geek", "gesek") == 1);
    }

    @Test
    public void testLCS() {
        assertTrue(Sequences.longestCommonSubs("AGGTAB", "GXTXAYB") == 4);
    }

    @Test
    public void testLIS() {
        int[] s = Sequences.longestIncreasingSubs(new int[]{23, 1, 3, 2, 4, 1, 5, 8, 12, 1});
        assertTrue(6 == s.length);
    }

}