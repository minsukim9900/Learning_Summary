package test2_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_QueueAPI {
	
	public static void main(String[] args) {
		
		// 큐는 인터페이스이기 떄문에 구현체를 따로 설정해주어야 한다.
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		queue.add(1); // 추가가 될 수 없으면 예외가 발생한다.
		queue.offer(1); // 추가가 될 수 없으면 return false;
		
		System.out.println(queue);
		// 삭제
		
		queue.remove(); // 삭제 될 수 없으면 예외 발생
		queue.poll(); // 삭제될 수 없으면 return null;
		
		// 조회
		queue.element(); // 예외 발생
		queue.peek(); // 널
	}
}
