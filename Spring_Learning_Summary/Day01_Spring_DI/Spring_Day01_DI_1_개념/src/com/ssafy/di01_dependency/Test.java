  package com.ssafy.di01_dependency;

public class Test {
	public static void main(String[] args) {
		
		// 프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		Programmer pg = new Programmer();
		
		pg.coding();
		
	}
}
