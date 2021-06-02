package javaalgos;

import java.util.Deque;
import java.util.Set;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class Stacks {
	
	public static class StackWithMax {
		public void push(int x) {
			
		}
		
		public int pop() {
			return -1;
		}
		
		public int max() {
			return -1;
		}
	}
	
	public static class PostingNode {
		PostingNode next;
		PostingNode jump;
	}
	
 	public static int evaluateReversePolishExpression(String exp) {
		Deque<Integer> e = new LinkedList<>();
		String[] literals = exp.split(",");
		Set<String> operators = new HashSet<>();
		operators.add("+");
		operators.add("/");
		operators.add("*");
		operators.add("-");
		for(int i = 0; i < literals.length; i++) {
			if(operators.contains(literals[i])) {
				int y = e.pop();
				int x = e.pop();
				switch(literals[i]) {
					case "+":
					e.push(x+y);
					break;
					case "-":
					e.push(x-y);
					break;
					case "*":
					e.push(x*y);
					break;
					case "/":
					e.push(x/y);
					break;
				}
			}else {
				e.push(Integer.parseInt(literals[i]));
			}
		}
 		return e.pop();
 	}
	
	public static boolean isWellFormed(String st) {
		char[] cs = st.toCharArray();
		Deque<Character> s = new LinkedList<>();
		Map<Character, Character> mapping = new HashMap<>();
		mapping.put('}', '{');
		mapping.put(']', '[');
		mapping.put(')', '(');
		for(int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if(mapping.containsValue(c)) {
				s.push(c);
			}else if(mapping.containsKey(c)) {
				if(s.isEmpty()) {
					return false;
				}else {
					if(Character.compare(s.peek(), mapping.get(c)) == 0) {
						s.pop();
					}else{
						return false;
					}
				}
			}
		}
		return s.isEmpty();
	}
	
	public static String normalizePathName(String p) {
		return "";
	}
	
	public static int buildingsWithSunsetView(int[] b) {
		return -1;
	}
  
}