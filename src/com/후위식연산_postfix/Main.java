package com.후위식연산_postfix;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public int solution(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) {
				stack.push(x-48);
			}else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(x=='+') stack.push(rt+lt);
				else if(x=='-') stack.push(lt-rt);
				else if(x=='*') stack.push(lt*rt);
				else if(x=='/') stack.push(lt/rt);
			}
		}
		answer = stack.get(0);
		return answer;
	}

	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.println(t.solution(str));
		kb.close();
	}
}
