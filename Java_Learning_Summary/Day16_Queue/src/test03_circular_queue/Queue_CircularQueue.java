package test03_circular_queue;

import java.util.Arrays;
import java.util.Scanner;

public class Queue_CircularQueue {
	
	// 데이터를 3개 담을 수 있다.
	static int N = 4;
	static String[] queue = new String[N];
	static int front, rear;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<N; i++) {
			enQueue(sc.next());
		}
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		System.out.println(rear);
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
		for(int i = 0; i<N; i++) {
			enQueue(sc.next());
		}
		System.out.println(Arrays.toString(queue));
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
	}
	
	// 포화상태 확인
	static boolean isFull() {
		return (N + front - rear) % N == 1;
	}
	
	// 공백 상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 삽입
	static void enQueue(String data) {
		
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		
		rear =(rear+1) % N;
		queue[rear] = data;
	}
	
	//삭제
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		front = (front + 1) % N;
		return queue[front];
	}
	
	//조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		front = (front + 1) % N;
		return queue[front];
	}
	
	// 데이터 개수
	static int size() {
		return (rear - front + N) % N;
	}
}
