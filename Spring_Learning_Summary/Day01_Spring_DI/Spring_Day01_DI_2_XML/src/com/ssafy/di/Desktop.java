package com.ssafy.di;

public class Desktop implements Computer{
	// 멤버 필드 작성~~!
//	private String CPU;
//	private String RAM;
// ... 작성을 할 수 있다. 오늘은 필요 없어!
	
	public Desktop() {
		System.out.println("생성이 되었습니다.");
	}
	
	public String getInfo() {
		return "데스크톱";
	}
	
}
