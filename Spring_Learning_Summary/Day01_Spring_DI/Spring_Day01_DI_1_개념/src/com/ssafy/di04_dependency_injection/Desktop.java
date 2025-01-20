package com.ssafy.di04_dependency_injection;

public class Desktop implements Computer{
	// 멤버 필드 작성~~!
//	private String CPU;
//	private String RAM;
// ... 작성을 할 수 있다. 오늘은 필요 없어!
	
	public String getInfo() {
		return "데스크톱";
	}
	
}
