package test02_heap;

public class Tree_MinHeap {

	static int[] heap = new int[100];
	static int heapSize = 0;

	public static void main(String[] args) {

		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(17);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);

		int size = heapSize;
		
		while(heapSize != 0) {
			System.out.println(heapPop());
		}
	}

	// swap

	static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	// 삽입 연산
	static void heapPush(int data) {
		// 1. 완전 이진트리 마지막에 data 추가
		heap[++heapSize] = data;

		int p = heapSize / 2;
		int ch = heapSize;

		while (ch != 1 && heap[p] > heap[ch]) {
			// 2. 부모와 비교해서 자식이 더 작으면 swap
			swap(p, ch);

			// 3. swap 이후 인덱스 갱신
			ch = p;
			p = ch / 2;
		}

	}

	// 삭제 연산
	static int heapPop() {
		// 1. 루트에 있는 데이터 저장
		int popItemp = heap[1];

		// 2. 마지막 노드를 루트로 옮긴다.
		heap[1] = heap[heapSize--];

		// 3. 자식과 부모 비교하여 swap 반복

		int p = 1;
		int ch = p * 2;
		if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1]) {
			ch++;
		}

		while (ch <= heapSize && heap[ch] < heap[p]) {
			swap(p, ch);

			// 4. swap 이후 인덱스 갱신
			p = ch;
			ch = p * 2;

			if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1]) {
				ch++;
			}

		}

		return popItemp;
	}

}
