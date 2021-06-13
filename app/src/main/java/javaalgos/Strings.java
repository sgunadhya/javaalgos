package javaalgos;

import java.util.*;
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
			boolean isBeginVowel = isVowel(t[s]);
			boolean isEndVowel = isVowel(t[e]);
            if(isVowel(t[s])) {
                while(!isVowel(t[e]) && e >= s){
                    --e;
                }
                char temp = t[s];
                t[s] = t[e];
                t[e] = temp;
            }else if(isVowel(t[e])) {
                while(!isVowel(t[s]) && s < e) {
                    s++;
                }  
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
	
    public static String reverseStr(String st, int k) {
        char[] t = st.toCharArray();
        //iterate through string keep a count of k
        //
        for(int i = 0; i < st.length(); i+=2*k) {
            int s = i;
            int e = Math.min(s + k - 1, t.length - 1);
            while(s < e) {
                char temp = t[s];
                t[s] = t[e];
                t[e] = temp;
                s++;
                --e;
            }
        }
        return new String(t);
    }
	
	
    public static String reverseWords(String st) {
           char[] t = st.toCharArray();
           int m = 0;
           while(m < t.length - 1) {
               if(isSpace(t[m])) {
                   m++;
               }else {
                   int s = m;
                   int e = m;
                   while(e < t.length  && !isSpace(t[e])){
                   	 e++;
                   }
				   m = e;
                   --e;				   
                   while(s < e) {
                       char temp = t[s];
                       t[s] = t[e];
                       t[e] = temp;
                       s++;
                       --e;
                   }
                
               }
			   
           }
           return new String(t);
                
       }
	   
	   private static boolean isSpace(char c) {
		   return c == ' ';
	   }
	   
       public static boolean isPalindrome(String st) {
		   int s = 0;
		   int e = st.length() - 1;
		   char[] t = st.toCharArray();
		   while(s < e) {
			   while(s < (t.length) && !isValidForPalindrome(t[s])) s++;
			   while(e > 0 && !isValidForPalindrome(t[e])) --e;
			   if(s > e) {
				   return true;
			   }
			   if(Character.toLowerCase(t[s]) != Character.toLowerCase(t[e])) {
				   return false;
			   }
			   s++;
			   --e;
		   }
		   return true;
       }
    
       private static boolean isValidForPalindrome(char c) {
           return Character.isLetter(c);
       }
	   
	   public static String addBinary(String a, String b){
           String x = a.length() > b.length() ? a : b;
           String y = a.length() > b.length() ? b : a;
           int carry = 0;
           int w = 0;
		   int diff = x.length() - y.length();
           StringBuilder r = new StringBuilder();
           for(int i = x.length() - 1; i >= 0; i--) {
               int m = x.charAt(i) - '0';
               if(i - diff >= 0) {
                   int n = y.charAt(i-diff) - '0';
                   w = m + n + carry;
               }else {
                  w = m + carry; 
               }
               if(w > 1) {
                       carry = 1;
                       r.insert(0, '0');
                   }else {
                       carry = 0;
                       r.insert(0, w);
                   }

           }
		   if(carry > 0) {
			   r.insert(0, '1');
		   }
           return r.toString();
	   }
	   
	   public static int myAtoi(String st) {
		   char[] t = st.toCharArray();
		   int wC = 0;
		   boolean isPositive = true;
		   while(wC < t.length && Character.isWhitespace(t[wC])) wC++;
		   if(wC == t.length ) {
			   return 0;
		   }
		   if(t[wC] == '-') {
			   isPositive = false;
			   wC++;
		   }else if (t[wC] == '+') {
			   wC++;
		   }
		   if(wC == t.length) {
			   return 0;
		   }
		   if(Character.isDigit(t[wC])) {
			   int d = wC;
			   while(d < t.length  && Character.isDigit(t[d])) d++;
			   d--;
			   int r = 0;
			   int n = 0;
			   int m = 0;
			   while(wC <= d) {
				   n = t[wC] - '0';
				   try {
					   m = Math.multiplyExact(r, 10);
					   r = Math.addExact(m, n);
				   }catch(ArithmeticException e) {
					   return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
				   }
				   wC++;
			   }
			   return isPositive? r : r*-1;
		   }else {
			   return 0;
		   }
	   }
	   
	   
	   public static int romanToInt(String s) {
		   int i = 0;
		   Map<Character, Integer> m = new HashMap<>();
		   m.put('I', 1);
		   m.put('V', 5);
		   m.put('X', 10);
		   m.put('L', 50);
		   m.put('C', 100);
		   m.put('D', 500);
		   m.put('M', 1000);
		   int r = 0;
		   while(i < s.length()) {
			   char c = s.charAt(i);
			   if(c == 'I') {
				   if(i + 1 < s.length()) {
					   if(s.charAt(i+1) == 'V') {
						   r = r + 4;
						   i++;
					   }else if(s.charAt(i+1) == 'X'){
						   r = r + 9;
						   i++;
					   }else {
						   r = r + m.get(c);
					   }
				   }else {
				   	r = r + m.get(c);
				   }
			   }else if (c == 'X') {
				   if(i + 1 < s.length()) {
					   if(s.charAt(i+1) == 'L') {
						   r = r + 40;
						   i++;
					   }else if(s.charAt(i+1) == 'C'){
						   r = r + 90;
						   i++;
					   }else {
						   r = r + m.get(c);
					   }
				   }else {
				   	r = r + m.get(c);
				   }
			   }else if(c == 'C') {
				   if(i + 1 < s.length()) {
					   if(s.charAt(i+1) == 'D') {
						   r = r + 400;
						   i++;
					   }else if(s.charAt(i+1) == 'M'){
						   r = r + 900;
						   i++;
					   }else {
						   r = r + m.get(c);
					   }
				   }else {
				   	r = r + m.get(c);
				   }
			   	
			   }else {
			   	r = r + m.get(c);
			   }
			   i++;
		   }
			   
		   return r;	
	   }

}