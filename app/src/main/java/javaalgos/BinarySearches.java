package javaalgos;


public class BinarySearches {
	public static int findGreatestIndex(int[] s, int e) {
		int k = 0;
		int n = s.length;
		for(int b = n/2; b >= 1; b /= 2) {
			System.out.println("b :"+b);
			while( k + b < n && e >= s[k + b]) {
				System.out.println("k :"+k);
				k += b;
			}
		}
		return k;
	}
}