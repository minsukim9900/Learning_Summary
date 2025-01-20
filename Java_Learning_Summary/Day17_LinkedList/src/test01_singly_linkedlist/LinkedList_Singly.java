package test01_singly_linkedlist;


class SinglyLinkedList {
	Node head;
	int size;

	public SinglyLinkedList() {
		head = new Node();
	}

	// 삽입
	public void addData(int i, String data) {
		// i 인덱스에 데이터 삽입
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입할 범위를 확인해주세요");
			return;
		}

		size++;

		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;

		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;

		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}

		// 새 노드부터 연결
		newNode.link = curr.link;
		curr.link = newNode;

	}

	// 삭제
	public void removeData(int i) {
		// 0번 : 제일 앞에 있는ㄷ ㅔ이터 삭제
		// (size-1)번 : 마지막 데이터 삭제
		if (!(0 <= i && i < size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}

		size--;

		// 삭제할 노드의 앞 노드로 이동
		Node curr = head;
		for (int k = 0; k < i - 1; k++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
		
	}

	// 조회
	
	void printAll() {
		Node curr = head.link;
		
		while(curr != null) {
			System.out.print(curr.data+ "->");
			curr = curr.link;
		}
		System.out.println();
	}
	

}

class Node {
	String data;
	Node link;
}

public class LinkedList_Singly {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addData(list.size, "0");
		list.printAll();
		list.addData(list.size, "1");
		list.addData(list.size, "2");
		list.printAll();
		list.addData(list.size, "3");
		list.addData(list.size, "4");
		list.addData(list.size, "5");
		list.addData(list.size, "6");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.printAll();
	}
}