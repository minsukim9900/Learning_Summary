package test01_stack_implement;

import java.util.Arrays;
import java.util.Stack;

public class Stack_Implement {

	static String[] stack = new String[100];
	// 마지막에 들어간 데이터의 index를 가리키는 top
	static int top = -1;

	public static void main(String[] args) {

//		Stack<String> stack = new Stack<>();
//		
//		stack.push("고양이");
//		stack.push("토끼");
//		stack.push("코끼리");
//		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
		push("고양이");
		push("토끼");
		push("쥐");
		
		while(!isEmpty()) {
			System.out.println(pop());
		}
		
		for(int i = 0; i<=100; i++) {
			push(i + "");
		}

	}

	static boolean isEmpty() {
//		if (top < 0) {
//			return true;
//		}
//		return false;
		return top <= -1;
	}

	static boolean isFull() {
		return top == stack.length-1;
	}
	
	static void push(String item) {
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = item;
	}
	
	static String pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top--];
	}
	
	static String peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}
