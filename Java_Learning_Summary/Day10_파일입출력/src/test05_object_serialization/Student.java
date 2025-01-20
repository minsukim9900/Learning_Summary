package test05_object_serialization;

public class Student extends Person {
	
	public Student() {
	}
	
	private String major;
	
	// 별말 없다면
	// 알아서 컴파일러가 Student 기본 생성자를 만드는데..
	// Student 기본 생성자는 내부적으로.. super(); 호출
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

	
}
