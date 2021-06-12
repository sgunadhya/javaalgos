package javaalgos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class StringsTest {
	
	@Test public void testLargestSubstring() {
		Map<String, Integer> tests = new HashMap<>();
		tests.put("abcabcbb", 3);
		tests.put("bbbbb", 1);
		tests.put("pwwkew", 3);
		tests.put("", 0);
		for(Map.Entry<String, Integer> e : tests.entrySet()) {
			int r = Strings.longestSubstringWithoutRepetition(e.getKey());
			assertTrue(e.getKey()+" has max length at :"+ e.getValue()+" but got: "+r, r == e.getValue());
		}
	}
	//Leet code 345
	@Test
	public void testReverseVowel() {
		assertEquals("leotcede", Strings.reverseVowels("leetcode"));
		assertEquals("hello", Strings.reverseVowels("holle"));
		assertEquals("ia", Strings.reverseVowels("ai"));
	}

	
}