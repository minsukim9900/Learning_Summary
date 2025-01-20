package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 스프링컨테이너 맛보기!
// 의존 관계 역전의 맛보기!
public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Programmer p = context.getBean("p", Programmer.class); 
		
		p.coding();
	}
}
