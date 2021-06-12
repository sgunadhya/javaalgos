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
	
    public static String reverseVowels(String st) {
        int s = 0;
        int e = st.length() - 1;
        char[] t = st.toCharArray();
        while(s <= e) {
            if(isVowel(t[s])) {
				System.out.println("init: Found vowel at "+s+ " : "+t[s] );
                while(!isVowel(t[e]) && e >= s){
                    --e;
                }
				System.out.println("init: Swapping with vowel at "+e+ " : "+t[e] );
                char temp = t[s];
                t[s] = t[e];
                t[e] = temp;
            }else if(isVowel(t[e])) {
				System.out.println("end: Found vowel at "+e+ " : "+t[e] );
                while(!isVowel(t[s]) && s < e) {
                    s++;
                }  
				System.out.println("end: Swapping with vowel at "+s+ " : "+t[s] );
                char temp = t[s];
                t[s] = t[e];
                t[e] = temp;

            }
            s++;
            --e;
        }
        
        return new String(t);
    }
    
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'o' || c == 'O' || c == 'u' || c == 'U' || c == 'i' || c == 'I';
    }

}