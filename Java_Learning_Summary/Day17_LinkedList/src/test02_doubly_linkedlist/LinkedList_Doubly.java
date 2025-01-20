package test02_doubly_linkedlist;

public class LinkedList_Doubly {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, 1);
		list.addData(0, 2);
		list.addData(0, 3);
		list.addData(0, 4);
		list.addData(0, 5);
		
		list.printRevers();
		
		list.removeData(2);
		list.printRevers();
		System.out.println(list.size);
	}

}

class Node {
	int data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 삽입
	void addData(int i, int data) {

		// 0 : 제일 앞에 삽입
		// size : 제일 뒤에 삽입
		if (!(i >= 0 && i <= size)) {
			System.out.println("인덱스가 잘못 선언 되었습니다.");
			return;
		}
		size++;

		// 삽입 위치 앞의 노드를 찾는다.
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		// 새 노드 만들어주기
		Node newNode = new Node();
		newNode.data = data;

		// 새 노드 연결 해주기
		newNode.next = curr.next;
		newNode.prev = curr;

		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;

	}

	// 삭제
	void removeData(int i) {
		// 0 : 제일 앞의 데이터 삭제
		// size - 1 : 맨 뒤 데이터 삭제

		if (!(i >= 0 && i < size)) {
			System.out.println("삭제 할 수 없는 범위입니다.");
			return;
		}
		size--;

		// 삭제할 위치를 찾기
		// rmNode는 지역변수이므로 메서드 리턴과 동시에 접근불가 : GC가 남
		Node rmNode = head.next;
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;

	}
	
	void printRevers() {
		Node curr = tail.prev;
		String str = "";
		while(curr != head) {
			str = "<-" + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}

}