package javaalgos;
import java.util.*;


public class Graphs {
	
	public static class Graph {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		
		public void addEdge(Integer from, int to) {
			if(adj.containsKey(from)) {
				adj.get(from).add(to);
			}else {
				List<Integer> l = new ArrayList<>();
				l.add(to);
				adj.put(from, l);
			}
		}
		
		public List<Integer> neighbors(int n) {
			if(adj.containsKey(n)) {
				return adj.get(n);
			}else {
				return Collections.EMPTY_LIST;
			}
		}
		
		public Set<Integer> dfs(int n) {
			Set<Integer> seen = new HashSet<>();
			dfsI(n, seen);
			return seen;
		}
		
		public Set<Integer> bfs(int n) {
			Set<Integer> seen = new HashSet<>();
			bfsI(n, seen);
			return seen;
		}
		
		public int connectedComps() {
			Set<Integer> vs = adj.keySet();
			Set<Integer> seen = new HashSet<>();
			int cc = 0;
			for(Integer n : vs) {
				if(!seen.contains(n)) {
					cc++;
					dfsI(n, seen);
				}
			}
			return cc;
		}
		
		
		private void bfsI(int n, Set<Integer> seen) {
			Queue<Integer> q = new LinkedList<>();
			Map<Integer, Integer> distance = new HashMap<>();
			q.offer(n);
			distance.put(n, 0);
			seen.add(n);
			while(q.peek() != null) {
				int s = q.poll();
				for(int g : this.neighbors(s)) {
					if(seen.contains(g)) {
						continue;
					}
					seen.add(g);
					distance.put(g, distance.get(s) + 1);
					q.offer(g);				
				}
			}
			System.out.println(distance);
		}
		
		private void dfsR(int n, Set<Integer> seen) {
			seen.add(n);
			for(int g : this.neighbors(n)) {
				if(!seen.contains(g)) {
					dfsR(g, seen);
				}
			}
		}
		
		private void dfsI(int n, Set<Integer> seen) {
			seen.add(n);
			Stack<Integer> tv = new Stack<>();
			tv.push(n);
			while(!tv.isEmpty()) {
				int g = tv.pop();
				for(int x : this.neighbors(g)) {
					if(!seen.contains(x)) {
						seen.add(x);
						tv.push(x);
					}
				}
			}
		}
	}
	
}