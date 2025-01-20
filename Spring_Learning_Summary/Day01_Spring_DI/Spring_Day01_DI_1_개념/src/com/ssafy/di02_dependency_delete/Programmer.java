package com.ssafy.di02_dependency_delete;

//컴퓨터 필요해
public class Programmer {
	private Desktop desktop;
	
	//객체 생성 의존성을 제거
	public Programmer(Desktop desktop) {
		// 가지고 있는 데스크탑 하나 줘!
		this.desktop = desktop;
	}
	
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발울 합니다.");
	}
}
