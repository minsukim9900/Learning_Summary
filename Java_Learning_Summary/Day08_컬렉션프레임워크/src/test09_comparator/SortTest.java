package test09_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		// 정렬
		// - 순서가 있는 자료 구조 : List
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("daisy", 3));
		persons.add(new Person("luna", 3));
		persons.add(new Person("max", 3));
		persons.add(new Person("alice", 2));
		
		System.out.println(persons);
		
		// 정렬
		// Collections 유틸리티 클랫의
		// sort() 메서드 사용
		
		Collections.sort(persons, new PersonComparator()); // 알파뱃 순서대로, 오름차순으로 정렬
		//사용자 정의 클래스를 사용한 리스트는 기본적으로 정렬할 수 없음!
		//comparable 인터페이스 구현 or comparator 클래스를 정의 (Comparator 인터페이스를 구현)
		// - 비교 기준이 없으므로 사용자 정의 클래스에 비교 기준을 만들어줘야 한다.
		
		
		System.out.println(persons);
		
		Collections.sort(persons, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name)*-1;
			}});
		
		System.out.println(persons);
		
		Collections.sort(persons, (Person o1, Person o2)->{
			return o2.age - o1.age;
		});
		
		System.out.println(persons);
	}
}
