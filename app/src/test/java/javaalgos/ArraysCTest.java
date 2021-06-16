package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class ArraysCTest {

    @Test
    public void testMergeSorted() {
        int[] r = ArraysC.mergeSorted(new int[]{1, 2, 3, 6, 7}, new int[]{4, 8, 10});
        assertTrue(8 == r.length);
        assertTrue(1 == r[0]);
        assertTrue(4 == r[3]);
    }

    @Test
    public void testFindDuplicateInRange() {
        boolean r = ArraysC.findDuplicateInRange(new char[]{'a', 'b', 'a', 'a', 'c', 'd', 'b', 'a', 'b', 'c'}, 3, 6);
        assertTrue(r);
    }

    @Test
    public void testMaximalSum() {
        int r = ArraysC.maximalSum(new int[]{1, 2, 3, 4, 5, 12, 7});
        assertTrue(r == 34);
    }

    @Test
    public void testRMTree() {
        ArraysC.RangeMinQ r = new ArraysC.RangeMinQ(new int[]{23, 4, 5, 56, 6, 1, 11, 2});
        assertTrue(1 == r.min(0, 7));
        r.set(2, 0);
        assertTrue(0 == r.min(0, 7));
    }

    @Test
    public void testFenwick() {
        ArraysC.Fenwick r = new ArraysC.Fenwick(new int[]{23, 4, 5, 56, 6, 1, 11, 2});
        assertTrue(27 == r.prefixSum(1));
    }

    @Test
    public void testDutchNationalFlag() {
        int[] flag = new int[]{3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1, 1};
        ArraysC.dutchFlag(flag, 2);
        assertTrue("1st index did not work", flag[0] == 1);
        assertTrue("2nd index did not work", flag[1] == 1);
        assertTrue("3rd index did not work", flag[2] == 1);
        assertTrue("4th index did not work", flag[3] == 1);
        assertTrue("5th index did not work", flag[4] == 1);
        assertTrue("6th index did not work", flag[5] == 1);
        assertTrue("7th index did not work", flag[6] == 2);
        assertTrue("8th index did not work", flag[7] == 2);
        assertTrue("9th index did not work", flag[8] == 2);
        assertTrue("10th index did not work", flag[9] == 3);
        assertTrue("11th index did not work", flag[10] == 3);
        assertTrue("12th index did not work", flag[11] == 3);
        assertTrue("13th index did not work", flag[12] == 3);
    }

    @Test
    public void testDeleteRepeatedValuesFromSortedArray() {
        int[] a = new int[]{2, 3, 5, 5, 7, 11, 11, 11, 13};
        ArraysC.removeDuplicatesFromSortedArray(a);

        int[] r = new int[]{2, 3, 5, 7, 11, 13, 0, 0, 0};
        for (int i = 0; i < r.length; i++) {
            assertTrue("i-th result does not match i:" + i, a[i] == r[i]);
        }
    }

    @Test
    public void testDeleteRepeatedValuesFromSortedArrayWithOneElement() {
        int[] a = new int[]{2, 2, 2, 2, 2, 2, 2, 2};
        ArraysC.removeDuplicatesFromSortedArray(a);

        int[] r = new int[]{2, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < r.length; i++) {
            assertTrue("i-th result does not match i:" + i, a[i] == r[i]);
        }
    }

    @Test
    public void testFindMaxProfit() {
        int[] prices = new int[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
        int profit = ArraysC.maximumProfit(prices);
        assertTrue("Maximum profit should be 30 instead it is : " + profit, profit == 30);
    }

    @Test
    public void testThreeSum() {
        List<List<Integer>> t = ArraysC.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(t);
        int r = t.size();
        System.out.println(r);
        assertTrue("Size should be 2 instead it is :" + r, 2 == r);
    }

    @Test
    public void testPOairSum() {
        assertTrue(2 == ArraysC.numberOfWays(new int[]{1, 2, 3, 4, 3}, 6));
        assertTrue(4 == ArraysC.numberOfWays(new int[]{1, 5, 3, 3, 3}, 6));
    }


    @Test
    public void testNextPermutation() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{3, 2, 1};
        int[] c = new int[]{1, 1, 5};
        ArraysC.nextPermutation(a);
        ArraysC.nextPermutation(b);
        ArraysC.nextPermutation(c);
        assertArrayEquals("Case 1", new int[]{1, 3, 2}, a);
        assertArrayEquals("Case 2", new int[]{1, 2, 3}, b);
        assertArrayEquals("Case 3", new int[]{1, 5, 1}, c);
    }
}