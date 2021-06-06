package javaalgos;


public class Strings {
	
	public static int longestSubstringWithoutRepetition(String st) {
		if(st == null || st.isEmpty()) {
			return 0;
		}
		int s = 0;
		int e = 0;
		int i = 0;
		int maxLen = 1;
		while(e < st.length()) {
			char c = st.charAt(e);
			i = s;
			while(i < e) {
				if(st.charAt(i) == c) {
					s = i + 1;
					break;
				}
				i++;
			}
			maxLen = Math.max(maxLen, e - s + 1);
			e++;
		}
		return maxLen;
	}

}