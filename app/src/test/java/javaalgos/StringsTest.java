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
			assertTrue(Strings.longestSubstringWithoutRepetition(e.getKey()) == e.getValue());
		}
	}

	
}