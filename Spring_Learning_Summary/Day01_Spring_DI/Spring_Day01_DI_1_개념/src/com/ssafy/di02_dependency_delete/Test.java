package com.ssafy.di02_dependency_delete;

// 스프링컨테이너 맛보기!
// 의존 관계 역전의 맛보기!
public class Test {
	public static void main(String[] args) {

		Desktop dt = new Desktop();

		// 프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		Programmer pg = new Programmer(dt);

		pg.coding();

	}
}
