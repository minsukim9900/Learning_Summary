package test08_comparable;


// 사용자 정의 클래스가 정렬되기 위해서는
// 비교 기준이 필요
// 1. Comparable 인터페이스 구현
// -> 제네릭: 타입 매개변수에 비교하고자 하는 클래스 타입을 집어 넣어준다.
public class Person implements Comparable<Person>{
	
	String name;
	int age;
	
	@Override
	public int hashCode() {
		// 일반적으로 String은 같은 문자열에 대해서 같은 해시코드가 나온다.
		
		return name.hashCode();
	}
	
	
	// 매개변수가 같으면 true, 아니면 false
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) { // 비교하고자 하는 obj가 Person 타입이라면
			Person p = (Person) obj;
			return this.age == p.age;
		}
		// Person이 아니라면
		return super.equals(obj);
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	//
	@Override
	public int compareTo(Person o) {
		// 나이를 기준으로 비교해보자.
		// 양수 : 자리 바꿈
		// 음수 : 자리 유지
		// 0   : 동일 위치
//		return o.age - this.age;
		
//		return this.name.compareTo(o.name);
		// 기본적으로 나이순 -> 나이가 같다면 이름 순
		if(this.age == o.age) {
			return this.name.compareTo(o.name) * -1;
		}
		return this.age-o.age;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
