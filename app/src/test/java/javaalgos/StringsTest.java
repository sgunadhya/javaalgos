package javaalgos;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class StringsTest {

    @Test
    public void testLargestSubstring() {
        Map<String, Integer> tests = new HashMap<>();
        tests.put("abcabcbb", 3);
        tests.put("bbbbb", 1);
        tests.put("pwwkew", 3);
        tests.put("", 0);
        for (Map.Entry<String, Integer> e : tests.entrySet()) {
            int r = Strings.longestSubstringWithoutRepetition(e.getKey());
            assertTrue(e.getKey() + " has max length at :" + e.getValue() + " but got: " + r, r == e.getValue());
        }
    }

    //Leet code 345
    @Test
    public void testReverseVowel() {
        assertEquals("leotcede", Strings.reverseVowels("leetcode"));
        assertEquals("hello", Strings.reverseVowels("holle"));
        assertEquals("ia", Strings.reverseVowels("ai"));
    }

    //Leet code 541
    @Test
    public void testReverseStr() {
        assertEquals("bacdfeg", Strings.reverseStr("abcdefg", 2));
        assertEquals("bacd", Strings.reverseStr("abcd", 2));
    }

    //Leet code 557
    @Test
    public void testReverseWords() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", Strings.reverseWords("Let's take LeetCode contest"));
        assertEquals("doG gniD", Strings.reverseWords("God Ding"));
    }

    @Test
    public void testPalindromeWithAlphanumeric() {
        // assertTrue(Strings.isPalindrome("A man, a plan, a canal: Panama"));
        // assertFalse(Strings.isPalindrome("race a car"));
        assertTrue(Strings.isPalindrome(".,"));
    }

    @Test
    public void testAddBinary() {
        assertEquals("100", Strings.addBinary("11", "1"));
    }

    @Test
    public void testMyAtoi() {
        assertTrue("First ", -42 == Strings.myAtoi("   -42"));
        assertTrue(4193 == Strings.myAtoi("4193 with words"));
        assertTrue(0 == Strings.myAtoi("words and 987"));
        assertTrue(Integer.MIN_VALUE == Strings.myAtoi("-91283472332"));
        assertTrue(0 == Strings.myAtoi("+"));
        assertTrue(-4 == Strings.myAtoi("   -04f"));
    }

    @Test
    public void testRomanToInt() {
        String[] args = new String[]{"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] x = new int[]{3, 4, 9, 58, 1994};
        for (int i = 0; i < x.length; i++) {
            assertTrue(x[i] == Strings.romanToInt(args[i]));
        }
    }


}