package com.ssafy.aop;

import java.util.Random;

public class Programmer implements Person {
	// 필드는 생략!
	
	
	// 프로그래머의 일상
	public int coding() {
		System.out.println("열심히 코드를 작성한다.");
		
		// 아래와 같이 작성했다. (연습을 위함)
		if(new Random().nextBoolean()) {
			throw new OuchException();
		}
		
		return (int)(Math.random() * 100) + 1; // 실제로 코딩한 수 반환
	}
	
}
