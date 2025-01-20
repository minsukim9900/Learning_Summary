package test2_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_simulation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<Person> queue = new LinkedList<>();

		int N = 20;
		int pNum = 1;

		queue.add(new Person(pNum++, sc.next(), 1));

		while (N != 0) {

			// 큐에ㅓㅅ 한명이 빠져나와서 마이쮸를 가져간다.
			Person p = queue.poll();
			if(N - p.myChu < 0) {
				System.out.println(p.name + "님이 마이쮸를 " + N + "개 가져갔습니다.");
				N -= N;
			}else {
				N -= p.myChu;
				System.out.println(p.name + "님이 마이쮸를 " + p.myChu + "개 가져갔습니다.");
			}
			System.out.println("남은 마이쮸는 " + N + "개");
			if (N <= 0) {
				System.out.println(p.name + "님이 마지막 마이쮸를 가져갔습니다.");
				break;
			}

			p.myChu++;
			// 가져갈 수 있는 마이쮸의 갯수를 늘리고 삽입
			queue.add(p);

			String newMemeber = sc.next();
			queue.add(new Person(pNum++, newMemeber, 1));
			System.out.println(newMemeber);

		}
	}

}

class Person {
	int no;
	String name;
	int myChu;

	public Person(int no, String name, int myChu) {
		super();
		this.no = no;
		this.name = name;
		this.myChu = myChu;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", myChu=" + myChu + "]";
	}

}
