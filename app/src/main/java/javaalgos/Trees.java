package javaalgos;

import java.util.*;
public class Trees {
	
	public static Map<Integer, List<Integer>> toGraphFromArray(int[] p) {
		Map<Integer, List<Integer>> g = new HashMap<>();
		for(int i = 1; i < p.length ; i++) {
			List<Integer> e = g.getOrDefault(p[i], new ArrayList<>());
			e.add(i);
			g.putIfAbsent(p[i], e);
		}
		return g;
	}
	 
}