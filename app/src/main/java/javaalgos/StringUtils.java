package javaalgos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringUtils {

    static class Suffix implements Comparable<Suffix> {
        public Suffix(int position, String text) {
            this.position = position;
            this.text = text;
        }
        int position;
        String text;

        @Override
        public int compareTo(Suffix suffix) {
            return this.text.compareTo(suffix.text);
        }

        @Override
        public String toString() {
            return "Suffix{" +
                    "position=" + position +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    static int[] suffixArray(CharSequence text){
        int[] suffixArray = new int[text.length()];
        Suffix[] suffixes = new Suffix[text.length()];
        for(int i = 0; i < text.length(); i++){
            CharSequence suffix = text.subSequence(i, text.length());
            suffixes[i] = new Suffix(i, suffix.toString());
        }
        Arrays.sort(suffixes);
        for(int i = 0; i < suffixes.length; i++){
            suffixArray[i] = suffixes[i].position;
        }
        System.out.println(Arrays.toString(suffixes));
        return suffixArray;
    }

    static int[] rank(int[] suffixArray){
        int[] rank = new int[suffixArray.length];
        for(int i = 0; i < suffixArray.length; i++){
            rank[suffixArray[i]] = i;
        }
        return rank;
    }

    //A i1 = 0
    //ANA i1 + 1 = 1
    static int[] lcp(CharSequence text){
        int[] lcp = new int[text.length()];
        int n = text.length();
        int[] sa = suffixArray(text);
        int[] rank = rank(sa);
        int k = 0;
        for(int i=0; i<n; i++ )
        {
            k = k > 0 ? k-- :0;
            if(rank[i]==n-1) {k=0; continue;}
            int j=sa[rank[i]+1];
            while(i+k<n && j+k<n && text.charAt(i+k) == text.charAt(j+k)) k++;
            lcp[rank[i]]=k;
        }
        return lcp;
    }

    public static String reverseWordsInString(String string) {
        // Write your code here.
        StringBuffer sb = new StringBuffer();
        int n = string.length();
        int i = 0;
        int j = 0;
        Stack<String> st = new Stack<>();
        while(i < n){
            if(string.charAt(i) == ' '){
                while(j < n && string.charAt(j) == ' ')j++;
            }else {
                while(j < n && string.charAt(j) != ' ')j++;
            }
            st.push(string.substring(i, j));
            i = j;
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String banana = "banana";
//        int[] suffixArray = suffixArray(banana);
//        System.out.println(Arrays.toString(suffixArray));
//        System.out.println(Arrays.toString(rank(suffixArray)));
//        System.out.println(Arrays.toString(lcp(banana)));
        System.out.println(reverseWordsInString("AlgoExpert is the best!"));
    }
}
