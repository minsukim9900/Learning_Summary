package test01_queueimplement;

import java.util.Scanner;

public class Queue_Implement {
	
	
	// 배열 사이즈가 10이면 10버 삽입할 수 있다.
	private static String[] queue = new String[10];
	private static int front = -1, rear = -1;
	
	
	
	public static void main(String[] args) {
		
		for(int i = 0 ; i<100; i++) {
			enQueue(""+i);
		}
		
		System.out.println("size : " + size());
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
		
		
		
	}
	
	// 공백상태 확인
	
	private static boolean isEmpty() {
		if(front == rear) {
			front = -1;
			rear = -1;
			return true;
		}
		return false;
	}
	
	// 포화상태 확인
	private static boolean isFull() {
		return rear == queue.length -1;
	}
	
	// 삽입
	// 삽입 성공 여부를 반환하려면 boolean타입도 반환 가능
	private static void enQueue(String item) {
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue[++rear] = item;
	}
	
	// 삭제
	private static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}
	
	// 조회
	private static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front + 1];
	}
	
	// 큐에 들어있는 데이터 갯수
	private static int size() {
		return rear - front;
	}
	
}
