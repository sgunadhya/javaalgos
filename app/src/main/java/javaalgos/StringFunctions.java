package javaalgos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class StringFunctions {
	
	public static int hash(String s) {
		char[] chars = s.toCharArray();
		final int p = 31;
		final int m = 10^9 + 9;
		int hash = 0;
		int pow = 1;
		for(int i = 0; i < chars.length; i++) {
			hash = hash + (chars[i] - 'a' + 1)*pow;
			pow = pow*p;
		}
		return hash % m;
	}
	
	public static int hashWithSort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		final int p = 31;
		final int m = 10^9 + 9;
		int hash = 0;
		int pow = 1;
		for(int i = 0; i < chars.length; i++) {
			hash = hash + (chars[i] - 'a' + 1)*pow;
			pow = pow*p;
		}
		return hash % m;
	}
	
	public static List<List<String>> groupBySimilar(String text) {
		String[] words = text.split("\\s+");
		List<List<String>> r = new ArrayList<>();
		Map<String, Set<String>> d = new HashMap<>();
		for(String s : words) {
			char[] chrs = s.toCharArray();
			Arrays.sort(chrs);
			String h = new String(chrs);
			if(d.containsKey(h)) {
				d.get(h).add(s);
			} else {
				Set<String> l = new HashSet<>();
				l.add(s);
				d.put(h, l);
			}
			
		}
		
		for(Set<String> ls : d.values()) {
			if(ls.size() > 1) {
				r.add(new ArrayList(ls));
			}
		}
		
		return r;
	}
	
	public static String mostProbable(Map<String, Integer> dict, String seq) {
		Map<String, Integer> pd = toPrefixDict(dict);
		Map<String, String> r = new HashMap<>();
		for(String s : pd.keySet()) {
			String mp = toCode(s);
			if(!r.containsKey(mp)) {
				r.put(mp, s);
			} else if(pd.get(r.get(mp)) < pd.get(s))  {
				r.put(mp, s);
			}
		}
		return r.getOrDefault(seq, "");
	}
	
	public static Map<String, Integer> toPrefixDict(Map<String, Integer> dict) {
		Map<String, Integer> m = new HashMap<>();
		for(Map.Entry<String, Integer> e : dict.entrySet()) {
			StringBuilder b = new StringBuilder();
			String s = e.getKey();
			int v = e.getValue();
			for(int i = 0, n = s.length(); i < n; i++) {
				b.append(s.charAt(i));
				String p = b.toString();
				if(m.containsKey(p)) {
					int valueNow = m.get(p);
					m.put(p, valueNow + v);
				} else {
					m.put(p, v);
				}
			}
		}
		return m;
	}
	
	public static String toCode(String s) {
		int[] mapping = new int[] {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9};
		StringBuilder b = new StringBuilder();
		for(int i = 0, n = s.length(); i < n; i++) {
			char c = s.charAt(i);
			int idx = c - 'a';
			b.append(mapping[idx]);
		}
		return b.toString();
	}
	
	
	public static class TrieNode {
		Map<Character, TrieNode> children =  new HashMap<>();
		char v;
		boolean isWord;
		
		public TrieNode(char c) {
			this.v = c;
		}
	}
	
	public static class Trie {
		TrieNode root;
		
		public Trie() {
			this.root = new TrieNode(' ');
		}
		public void add(String s) {
			TrieNode curr = root;
			for(int i = 0, n = s.length(); i < n; i++) {
				char c = s.charAt(i);
				if(!curr.children.containsKey(c)) {
					curr.children.put(c, new TrieNode(c));
				}
				curr = curr.children.get(c);
			}
			curr.isWord = true;
		}
		
		public boolean search(String s) {
			
		}
		
		private boolean searchP(TrieNode n, int i, String s) {
			if(	) {
				return false;
			}
			if(i == s.length() && !n.isWord) {
				return false;
			} else if(n.isWord && i == s.length()) {
				return true;
			}else {
				return searcP(n.get(s.c))
			}
		}
	}
}