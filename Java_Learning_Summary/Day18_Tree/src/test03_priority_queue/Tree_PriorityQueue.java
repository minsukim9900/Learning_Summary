package test03_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (this.name.equals(o.name)) {
			return this.age - o.age;
		}
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class Tree_PriorityQueue {
	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.offer(1);
		pq.offer(3);
		pq.offer(5);
		pq.offer(10);
		// 최소 힙
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

		// 최대 힙
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

		pq2.offer(10);
		pq2.offer(20);
		pq2.offer(30);
		pq2.offer(40);
		pq2.offer(50);

		while (!pq2.isEmpty()) {
			System.out.println(pq2.poll());
		}

		PriorityQueue<Person> personPQ = new PriorityQueue<>();
		personPQ.add(new Person("루나", 3));
		personPQ.add(new Person("루나", 1));
		personPQ.add(new Person("루나", -1));
		personPQ.add(new Person("루나", 5));
		personPQ.add(new Person("데이지", 1));
		personPQ.add(new Person("맥스", 8));

		while (!personPQ.isEmpty()) {
			System.out.println(personPQ.poll());
		}
		System.out.println();
		PriorityQueue<Person> personPQ2 = new PriorityQueue<>((p1, p2) -> {
			if (p1.name.equals(p2.name)) {
				return p1.age - p2.age;
			}
			return p1.name.compareTo(p2.name);
		});

		personPQ2.add(new Person("루나", 3));
		personPQ2.add(new Person("루나", -1));
		personPQ2.add(new Person("루나", 10));
		personPQ2.add(new Person("루나", 5));
		personPQ2.add(new Person("나", 26));
		personPQ2.add(new Person("가", 26));
		while (!personPQ2.isEmpty()) {
			System.out.println(personPQ2.poll());
		}
	}
}
