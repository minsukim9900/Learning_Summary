package test04_insertion_sort;


public class Queue_priority_queue {

	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {

		enQueue(10);
		enQueue(12);
		enQueue(3);
		enQueue(9);
		enQueue(8);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}

	static void enQueue(int data) {
		// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
		int j;
		for (j = ++rear - 1; j >= 0 && queue[j] > data; j--) {
				queue[j+1] = queue[j];
		}
		
		queue[j+1] = data;
	}

	static int deQueue() {
		return queue[++front];
	}

}
