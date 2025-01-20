package test04_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		
		// Queue
		// - FIFO
		// - Queue 인터페이스
		// - LinkedList를 구현체로 사용.
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		
		// queue.offer(), queue.add() : 둘다 추가
		// 예외처리와 관련해서 차이가 있을 수 있다.
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
