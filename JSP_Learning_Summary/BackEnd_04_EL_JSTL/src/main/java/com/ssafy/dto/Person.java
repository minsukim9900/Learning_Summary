package com.ssafy.dto;

import java.io.Serializable;
import java.util.Arrays;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	// 직렬화를 해야한다.
	private String name;
	private int age;
	private String gender;
	private String[] hobbies;
	
	// 기본생성자를 만들어야 한다.
	public Person() {
	}

	private Person(String name, int age, String gender, String[] hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", hobbies=" + Arrays.toString(hobbies)
				+ "]";
	}
	
	

}
