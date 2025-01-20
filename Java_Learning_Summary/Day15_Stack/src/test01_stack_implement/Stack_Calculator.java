package test01_stack_implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack_Calculator {
	private static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('/', 2);
		map.put('*', 2);
		map.put('(', 0);
	}

	public static void main(String[] args) {
		String expression = "3+8+9+(2*7)";

		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		
		int result = evalPostfix(postfix);
		System.out.println(result);
		
		int result2 = evaluate(expression);
		System.out.println(result2);

	}
	
	
	private static int evaluate(String expression) {
		return evalPostfix(infixToPostfix(expression));
	}
	

	private static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {

			char c = infix.charAt(i);

			// 피연산자가 나오면 바로 출력
			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					stack.pop();
				} else {
					while (stack.peek() != '(') {
						postfix += stack.pop();
					}
					stack.pop();
				}
//				char popItem = stack.pop();
//				while(popItem != '(') {
//					postfix += popItem;
//					popItem = stack.pop();
//				}
			} else {
				// 연산자 스택의 마지막에
				// 우선순위가 낮은 연산자가 올 때까지 pop
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}

				stack.push(c);

			}

		}
		// 스택 비워주기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;

	}

	private static int evalPostfix(String postfix) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result = 0;

				switch (c) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
				stack.push(result);
			}
			
		}
		
		return stack.pop();
	}
}
