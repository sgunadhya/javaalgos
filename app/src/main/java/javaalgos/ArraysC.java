package javaalgos;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class ArraysC {
	
	public static int[] mergeSorted(int[] x, int[] y) {
		int n = x.length;
		int m = y.length;
		int[] r = new int[n+m];
		int i = 0, j = 0;
		int ri = 0;
		while(i < n || j < m) {
			if(j == m || i < n && x[i] <= y[j]) {
				r[ri] = x[i];
				i++;
			}else {
				r[ri] = y[j];
				j++;
			}
			ri++;
		}
		return r;
	}
	
	public static boolean findDuplicateInRange(char[] n, int s, int e) {
		int[] p = new int[n.length];
		int[] q = new int[n.length];
		int maxI = -1;
		int val = 0;
		Map<Character, Integer> m = new HashMap<>();
		for(int i = 0; i < n.length; i++) {
			if(m.containsKey(n[i])) {
				p[i] = m.get(n[i]);
			}else {
				p[i] = -1;
			}
			m.put(n[i], i);
			
			if(p[i] > maxI) {
				maxI = p[i];
			}
			q[i] = maxI;
		}
		return q[e-1] < s;
	}
	
	public static int maximalSum(int[] s) {
		int mSum = s[0];
		int cSum = s[0];
		for(int i = 1; i < s.length; i++) {
		   cSum = Math.max(cSum , cSum + s[i]);
		   if(cSum > mSum) {
			   mSum = cSum;
		   }
		}
		return mSum;
	}
	
	public static class RangeMinQ {
		int[] s;
		int n = 1;
		public RangeMinQ(int[] a) {
			int m = a.length;
			while(this.n < m) {
				this.n = this.n*2;
			}
			s = new int[2*this.n];
			Arrays.fill(s, Integer.MAX_VALUE);
			for(int i = 0; i < m; i++) {
				this.s[this.n+i] = a[i];
			}
			for(int j = this.n - 1; j >= 0; j--) {
				this.s[j] =  Math.min(this.s[2*j], this.s[2*j+1]);
			}
		}
		
		public void set(int k, int x) {
			int p = this.n + k;
			this.s[p] = x;
			for(p /= 2; p >= 1; p /= 2) {
				this.s[p] = Math.min(this.s[2*p], this.s[2*p+1]);
			}
		}
		
		public int min(int s, int e) {
			return minRange(1, 0, this.n, s, e);
		}
		
		private int minRange(int p, int start, int span, int i, int k) {
			if (start + span <= i || k <= start) {
				return Integer.MAX_VALUE;
			}
			if(i <= start && start + span <= k) {
				return this.s[p];
			}
			int left = minRange(2*p, start, span/2, i, k);
			int right = minRange(2*p + 1, start + span/2 , span/2, i,k);
			return Math.min(left, right);
		}
	} 
	
	
	public static class Fenwick {
		int[] s;
		public Fenwick(int[] n) {
			this.s = new int[n.length + 1];
			for(int i = 0; i < n.length; i++) {
				this.add(i, n[i]);
			}			
		}
		
		public void add(int i, int v) {
			int j = i + 1;
			while (j < this.s.length) {
				this.s[j] += v;
				j += (j & -j);
			}
		}
		
		public int prefixSum(int i) {
			int j = i + 1;
			int t = 0;
			while (j > 0) {
				t += this.s[j];
				j -= (j & -j);
			}
			return t;
		}
	}
	
	public static void dutchFlag(int[] flag, int middle) {
		int s = 0;
		int e = 0;
		int l = flag.length;
		int tmp;
		while(e < l) {
			if(flag[e] < middle) {
				tmp = flag[s];
				flag[s] = flag[e];
				flag[e] = tmp;
				s++;
				e++;
			}else if(flag[e] > middle) {
				l--;
				tmp = flag[l];
				flag[l] = flag[e];
				flag[e] = tmp;
			}else {
				e++;
			}
		}			
	}
	
	public static void removeDuplicatesFromSortedArray(int[] a) {
		int u = 1;
		for(int i = 1; i < a.length; i++) {
			if(a[i] != a[u-1]) {
				a[u] = a[i];
				u++;
			}
		}
		for(int j = u; j < a.length; j ++) {
			a[j] = 0;
		}		
	}
	
	public static int maximumProfit(int[] prices) {
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return profit;
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> r = new HashSet<>();
		int i = 0;
		while(i < nums.length - 2) {
			int s = i + 1;
			int e = nums.length - 1;
			while(s < e) {
				if(nums[i] + nums[s] + nums[e] == 0) {
					r.add(Arrays.asList(nums[i], nums[s], nums[e]));
					s = s + 1;
					e = e - 1;
				}else if(nums[i] + nums[s] + nums[e] < 0 ) {
					s = s + 1;
				}else {
					e = e - 1;
				}
			}
			i++;
		}
        return new ArrayList<>(r);
    }
	
public static int numberOfWays(int[] arr, int k) {
    // Write your code here
    Map<Integer, Integer> counter = new HashMap<>();
    int s = 0;
    for(int i = 0; i < arr.length; i++) {
      int count = counter.getOrDefault(arr[i], 0);
      counter.put(arr[i], count + 1);
    }
    Set<Integer> r = counter.keySet();
    Set<Integer> seen = new HashSet<>();
    for(Map.Entry<Integer, Integer> c : counter.entrySet()) {
      if(counter.containsKey(k - c.getKey()) && !seen.contains(k - c.getKey())) {
		if(c.getKey() == k - c.getKey()) {
			s += (c.getValue()*(c.getValue() - 1))/2;
		}else {
			s += counter.get(k - c.getKey())* c.getValue();
		}
        
        seen.add(c.getKey());
      }
    }

    return s;

  }
  
  public static void nextPermutation(int[] a) {
	  return;
  }
  
}