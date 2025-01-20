package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 스프링컨테이너 맛보기!
// 의존 관계 역전의 맛보기!
public class Test {
	public static void main(String[] args) {

		// ApplicationContext context = new
		// GenericXmlApplicationContext("applicationContext.xml");

//		System.out.println(1);
//		Programmer p = context.getBean("programmer", Programmer.class);
//		Desktop d = (Desktop) context.getBean("desktop");
//		
//		p.setComputer(d);
//		System.out.println(2);
//		
//		p.coding();
//		
//		Desktop d2 = context.getBean("desktop", Desktop.class);
//		
//		System.out.println(d == d2); // 기본적으로 싱글톤으로 관리
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		
		Programmer p = context.getBean("programmer", Programmer.class);
		
		p.coding();
		
	}
}
