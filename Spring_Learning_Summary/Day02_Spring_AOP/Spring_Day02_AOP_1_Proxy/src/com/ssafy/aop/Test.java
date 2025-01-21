package com.ssafy.aop;

public class Test {
	public static void main(String[] args) {
		
		Ssafy p = new Ssafy();
		
		PersonProxy px = new PersonProxy();
		px.setPerson(p);
		px.coding();
	}
}
