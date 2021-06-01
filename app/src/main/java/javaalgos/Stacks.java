package javaalgos;

import java.util.Deque;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;

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
	
	public static boolean isWellFormed(String s) {
		return false;
	}
	
	public static String normalizePathName(String p) {
		return "";
	}
	
	public static int buildingsWithSunsetView(int[] b) {
		return -1;
	}
  
}