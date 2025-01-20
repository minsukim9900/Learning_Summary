package test05_Stack;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		
		// 인터페이스 분리
		// - 구현체가 달라질 수 있다.
		// List : ArrayList, LinkedList, ...
		
		// Stack
		// - 단일 클래스
		// - LIFO
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.add(2);
		stack.push(3);
		stack.push(4);
		
		stack.peek(); // 값을 꺼내지는 않고(삭제는 하지 않고 조호만 할 때)
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		
		
	}
}
