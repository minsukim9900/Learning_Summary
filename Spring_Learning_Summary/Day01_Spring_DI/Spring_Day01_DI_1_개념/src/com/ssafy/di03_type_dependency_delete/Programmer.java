package com.ssafy.di03_type_dependency_delete;

//컴퓨터 필요해
public class Programmer {
	private Computer computer;

	// 객체 생성 의존성을 제거
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발울 합니다.");
	}
}
