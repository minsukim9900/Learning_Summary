package com.ssafy.di04_dependency_injection;

import java.util.Scanner;

// 스프링컨테이너 맛보기!
// 의존 관계 역전의 맛보기!
public class Test {
	public static void main(String[] args) {

		Desktop dt = new Desktop();
		Laptop lt = new Laptop();

		// 프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
//		Programmer pg = new Programmer(lt);
		
		Programmer pg = new Programmer();
		pg.setComputer(dt);
		
		// => 다형성

//		pg.coding();
		
		Scanner sc = new Scanner(System.in);
		
		Programmer p = new Programmer();
		while(true) {
			p.setComputer(ComputerFactory.getComputer(sc.next()));
			p.coding();
		}

	}
}
