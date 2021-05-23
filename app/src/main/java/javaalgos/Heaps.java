package javaalgos;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Heaps {
	
	public static List<Integer> asSortedList(List<Integer> ...xs) {
		List<Iterator<Integer>> iters = new ArrayList<>();
		List<Integer> r = new ArrayList<>();
		for(int i = 0; i < xs.length; i++) {
			iters.add(xs[i].iterator());
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(Iterator<Integer> it : iters) {
			while(it.hasNext()) {
				q.add(it.next());
			}
		}
		while(!q.isEmpty()) {
			r.add(q.poll());
		}
		System.out.println("r :"+r);
		return r;
	}
}