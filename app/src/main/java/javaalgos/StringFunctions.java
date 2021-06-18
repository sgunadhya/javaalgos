package javaalgos;

import java.util.*;
import java.util.Arrays;


public class StringFunctions {

    public static int hash(String s) {
        char[] chars = s.toCharArray();
        final int p = 31;
        final int m = 10 ^ 9 + 9;
        int hash = 0;
        int pow = 1;
        for (int i = 0; i < chars.length; i++) {
            hash = hash + (chars[i] - 'a' + 1) * pow;
            pow = pow * p;
        }
        return hash % m;
    }

    public static int hashWithSort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        final int p = 31;
        final int m = 10 ^ 9 + 9;
        int hash = 0;
        int pow = 1;
        for (int i = 0; i < chars.length; i++) {
            hash = hash + (chars[i] - 'a' + 1) * pow;
            pow = pow * p;
        }
        return hash % m;
    }

    public static List<List<String>> groupBySimilar(String text) {
        String[] words = text.split("\\s+");
        List<List<String>> r = new ArrayList<>();
        Map<String, Set<String>> d = new HashMap<>();
        for (String s : words) {
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);
            String h = new String(chrs);
            if (d.containsKey(h)) {
                d.get(h).add(s);
            } else {
                Set<String> l = new HashSet<>();
                l.add(s);
                d.put(h, l);
            }

        }

        for (Set<String> ls : d.values()) {
            if (ls.size() > 1) {
                r.add(new ArrayList<>(ls));
            }
        }

        return r;
    }

    public static String mostProbable(Map<String, Integer> dict, String seq) {
        Map<String, Integer> pd = toPrefixDict(dict);
        Map<String, String> r = new HashMap<>();
        for (String s : pd.keySet()) {
            String mp = toCode(s);
            if (!r.containsKey(mp)) {
                r.put(mp, s);
            } else if (pd.get(r.get(mp)) < pd.get(s)) {
                r.put(mp, s);
            }
        }
        return r.getOrDefault(seq, "");
    }

    public static Map<String, Integer> toPrefixDict(Map<String, Integer> dict) {
        Map<String, Integer> m = new HashMap<>();
        for (Map.Entry<String, Integer> e : dict.entrySet()) {
            StringBuilder b = new StringBuilder();
            String s = e.getKey();
            int v = e.getValue();
            for (int i = 0, n = s.length(); i < n; i++) {
                b.append(s.charAt(i));
                String p = b.toString();
                if (m.containsKey(p)) {
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
        int[] mapping = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9};
        StringBuilder b = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            b.append(mapping[idx]);
        }
        return b.toString();
    }


    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
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
            for (int i = 0, n = s.length(); i < n; i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode(c));
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        public boolean search(String s) {
            return false;
        }

        // private boolean searchP(TrieNode n, int i, String s) {
        // 	if(	) {
        // 		return false;
        // 	}
        // 	if(i == s.length() && !n.isWord) {
        // 		return false;
        // 	} else if(n.isWord && i == s.length()) {
        // 		return true;
        // 	}else {
        // 		return searcP(n.get(s.c))
        // 	}
        // }
    }

    public static String longestPalindromicSubString(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return "";
        }

        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0, n = s.length(); i < n; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        int[] p = new int[t.length];
        int c = 0;
        int r = 0;
        int n = s.length();
        int maxVal = 0;
        int maxC = 0;

        for (int i = 1; i < t.length - 1; i++) {
            int m = 2 * c - 1;
            if (r > i) {
                p[i] = Math.max(0, Math.min(r - i, p[m]));
            }

            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i] = p[i] + 1;
            }
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
            if (p[i] > maxVal) {
                maxVal = p[i];
                maxC = i;
            }
        }

        return s.substring((maxC - 1 - maxVal) / 2, (maxC - 1 + maxVal) / 2);

    }

    public static int[] maximumBorderLength(String s) {
        int n = s.length();
        int[] b = new int[n];
        int k = 0;
        for (int i = 1; i < n; i++) {
            while (s.charAt(k) != s.charAt(i) && k > 0) {
                k = b[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            b[i] = k;
        }
        System.out.println(Arrays.toString(b));

        return b;
    }

    public static int findSubstring(String s, String p) {
        StringBuilder t = new StringBuilder(p);
        t.append("#");
        for (int i = 0, n = s.length(); i < n; i++) {
            t.append(s.charAt(i));
        }
        int[] maxB = maximumBorderLength(t.toString());
        int l = p.length();
        for (int k = 0; k < maxB.length; k++) {
            if (maxB[k] == l) {
                return k - 2 * l;
            }
        }
        return -1;
    }

    public static Integer[] suffixArray(CharSequence s) {
        int n = s.length();
        Integer[] sa = new Integer[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }
        for(int len = 1; len < n; len++) {
            long[] rank2 = new long[n];
            for (int i = 0; i < n; i++){
                rank2[i] = ((long) rank[i] << 32) + (i + len < n ? rank[i + len] + 1 : 0);
            }
            Arrays.sort(sa, Comparator.comparingLong(a -> rank2[a]));

            for (int i = 0; i < n; i++){
                rank[sa[i]] = i > 0 && rank2[sa[i - 1]] == rank2[sa[i]] ? rank[sa[i - 1]] : i;
            }
        }
        return sa;
    }
}