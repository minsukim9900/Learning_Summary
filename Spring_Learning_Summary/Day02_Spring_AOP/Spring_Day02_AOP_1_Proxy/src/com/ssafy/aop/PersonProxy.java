package com.ssafy.aop;

import java.util.Random;

public class PersonProxy implements Person {

	// 프록시 객체에 주입한 인간
	private Person person;

	// 설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 수행해야 할 기능

		try {
			
			 person.coding();
			 
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}

			System.out.println("Git에 Commit한다."); // 정상 마무리
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴를 한다."); // 비정상 마무리
		} finally {
			System.out.println("침대와 한 몸이 된다."); // 모든것이 마무리 되었을 때!
		}
	}

}
