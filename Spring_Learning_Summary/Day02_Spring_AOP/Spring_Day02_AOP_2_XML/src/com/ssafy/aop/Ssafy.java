package com.ssafy.aop;

import java.util.Random;

public class Ssafy implements Person {
	// 필드는 생략!

	// SSAFY 교육생의 일상
	public int coding() {
		System.out.println("열심히 공부를 한다."); // 핵심관심사항

		// 아래와 같이 작성했다. (연습을 위함)
		if (new Random().nextBoolean()) {
			throw new OuchException();
		}

		return (int)(Math.random() * 100) + 1; // 실제로 공부한 시간 반환
	}

}
