package javaalgos;

import java.util.*;
public class Trees {
	
	public static class HuffmanNode implements Comparable<HuffmanNode> {
		HuffmanNode left;
		HuffmanNode right;
		Character c;
		int f;
		public HuffmanNode(Character c, Integer f, HuffmanNode left, HuffmanNode right) {
			this.left = left;
			this.right = right;
			this.c = c;
			this.f = f;
		}
		
		public int compareTo(HuffmanNode o) {
			return Integer.compare(this.f, o.f);
		}
	}
	
	public static Map<Integer, List<Integer>> toGraphFromArray(int[] p) {
		Map<Integer, List<Integer>> g = new HashMap<>();
		for(int i = 1; i < p.length ; i++) {
			List<Integer> e = g.getOrDefault(p[i], new ArrayList<>());
			e.add(i);
			g.putIfAbsent(p[i], e);
		}
		return g;
	}
	
	public static int[] toArrayFromGraph(Map<Integer, List<Integer>> g) {
		Deque<Integer> q = new ArrayDeque<>();
		int[] p = new int[g.size()];
		q.offer(0);
		p[0] = -1;
		while(!q.isEmpty()) {
			int r = q.pop();
			for(Integer e : g.get(r)) {
				if(p[e] == 0) {
					p[e] = r;
					q.offer(e);
				}
			}
		}		
		return p;
	}
	
	public static Map<Character, String> huffmanEncoding(Map<Character, Integer> f) {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<>();
		Map<Character, String> r = new HashMap<>();
		for(Map.Entry<Character, Integer>  e : f.entrySet() ) {
			q.add(new HuffmanNode(e.getKey(), e.getValue(), null, null));
		}
		while(q.size() > 1) {
			HuffmanNode left = q.poll();
			HuffmanNode right = q.poll();
			q.add(new HuffmanNode('-', left.f + right.f , left, right));
			
		}
		HuffmanNode root = q.poll();
		gatherCode(r, root, "");
 		return r;
	}
	
	private static void gatherCode(Map<Character, String> s, HuffmanNode n, String k) {
		if(n.left != null && n.right != null && n.c == '-') {
			gatherCode(s, n.left, k + "0");
			gatherCode(s, n.right, k + "1");
		}else {
			s.put(n.c , k.toString());
		}
	}
	
	public static int commonAncestor(int[] pA, int x, int y) {
		int n = pA.length;
		int[] levels = new int[n];
		levels[0] = 0;
		for(int i = 1; i < n; i++) {
			levels[i] = 1 + levels[pA[i]];
		}
		int d = 1;
		while((1 << d) <= n) ++d;
		int[][] anc = new int[d][n];
		for(int i = 1; i < n; i++) {
			anc[0][i] = pA[i];
		}
		for(int j = 1; j < d; j++) {
			for(int i = 0; i < n; i++) {
				anc[j][i] = anc[j-1][anc[j-1][i]];
			}
		}
		//query
		if(levels[x] > levels[y]) {
			int temp = x;
			x = y;
			y = temp;
		}
		for(int k = d - 1; k >=0; k--) {
			if(levels[x] <= levels[y]- (1 << k)) {
				y = anc[k][y];
			}
		}
		if(x == y) {
			return x;
		}
		for(int k = d - 1; k >= 0; k--) {
			if(anc[k][x] != anc[k][y]) {
				x = anc[k][x];
				y = anc[k][y];
			}
		}
		return anc[0][x];
	}
	 
}