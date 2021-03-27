package javaalgos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Sequences {
	
	public static int editDistance(String f, String t) {
		int n = f.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i == 0) {
					dp[i][j] = j;
				}else if(j == 0) {
				 	dp[i][j] = i;
				}else if(f.charAt(i-1) ==  t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] =  1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[n][m];
	}
	
	public static int longestCommonSubs(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		
		return dp[n][m];
	}
	
	public static int[] longestIncreasingSubs(int[] s) {
		int n = s.length;
		int[] p = new int[n];
		List<Integer> h = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		b.add(Integer.MIN_VALUE);
		h.add(-1);
		int k, r = 0;
		for(int i = 0; i < n; i++) {
			if(s[i] > b.get(b.size() - 1)) {
				h.add(i);
				b.add(s[i]);
			}else {
				r = Collections.binarySearch(b, s[i]);
				System.out.println("r: "+r);
				if(r > 0) {
					continue;
				}
				k = ~r;
				h.set(k, i);
				b.set(k, s[i]);
					 
			}
		}
		int[] arr = new int[b.size() - 1];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = s[h.get(i+1)];
		}
		System.out.println(Arrays.toString(arr));
		return arr;
		
	}
	
	
	
}