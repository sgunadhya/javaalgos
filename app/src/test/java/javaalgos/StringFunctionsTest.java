
package javaalgos;
import java.util.List;	
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class StringFunctionsTest {
    @Test public void testAppHasAGreeting() {
		assertEquals(22, StringFunctions.hash("test"));
		assertEquals(StringFunctions.hash("test"), StringFunctions.hash(new String("test")));
    }
	
    @Test public void testAnagrams() {
		List<List<String>> r = StringFunctions.groupBySimilar("below the car is a rat drinking cider and bending its elbow while this thing is an arc that can act like a cat which cried during the night caused by pain in its bowel");
		assertEquals(5, r.size());
    }
	
    @Test public void testToCode() {
		String s = StringFunctions.toCode("abc");
		assertEquals("222", s);
		
		String s1 = StringFunctions.toCode("add");
		assertEquals("233", s1);
    }
	
    @Test public void testPrefixDict() {
		Map<String, Integer> dict = new HashMap<>();
		dict.put("abc", 2);
		Map<String, Integer> m  = StringFunctions.toPrefixDict(dict);
		assertTrue(m.containsKey("a"));
		assertTrue(m.containsKey("ab"));
		assertTrue(m.containsKey("abc"));
		assertTrue(2 ==  m.get("a"));
		assertTrue(2 == m.get("ab"));
		assertTrue(2 == m.get("abc"));		
    }
	
    @Test public void testMostProbable() {
		Map<String, Integer> dict = new HashMap<>();
		dict.put("abc", 2);
		String m  = StringFunctions.mostProbable(dict, "2");
		assertEquals("a", m);
    }
	
    @Test public void testTrieNode() {
		StringFunctions.TrieNode n = new StringFunctions.TrieNode('c');
		assertTrue('c' == n.v);
		assertFalse(n.isWord);
    }
	
    @Test public void testTrie() {
		StringFunctions.Trie t = new StringFunctions.Trie();
		t.add("hello");
		assertTrue(' ' == t.root.v);
		assertTrue(t.root.children.containsKey('h'));
		assertTrue(t.root.children.get('h').children.containsKey('e'));
		assertTrue(t.root.children.get('h').children.get('e').children.containsKey('l'));
		assertTrue(t.root.children.get('h').children.get('e').children.get('l').children.containsKey('l'));
		assertTrue(t.root.children.get('h').children.get('e').children.get('l').children.get('l').children.containsKey('o'));
		
	}

    @Test public void testLongestPalindromicSubstringEmpty() {
		String p = StringFunctions.longestPalindromicSubString("");
		assertEquals("", p);
	}
	
    @Test public void testLongestPalindromicSubstringNonEmpty() {
		String p = StringFunctions.longestPalindromicSubString("tabam");
		assertEquals("aba", p);
	}

    @Test public void testMaxBorderLen() {
		int[] p = StringFunctions.maximumBorderLength("tabam");
		assertEquals(5, p.length);
		assertTrue(0 == p[0]);
	}
	
    @Test public void testMaxBorderLenTrue() {
		int[] p = StringFunctions.maximumBorderLength("lilipolilil");
		assertTrue(0 == p[0]);
	}
		
	
    @Test public void testSubstring() {
		int p = StringFunctions.findSubstring("testsdfghjkghj", "sdf");
		assertTrue(4 == p);
	}
	
}
