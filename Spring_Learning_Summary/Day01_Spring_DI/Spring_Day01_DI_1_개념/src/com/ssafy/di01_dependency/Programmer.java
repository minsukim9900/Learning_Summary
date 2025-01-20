package com.ssafy.di01_dependency;

//컴퓨터 필요해
public class Programmer {
	private Desktop desktop;
	
	public Programmer() {
		// 프로그래머를 한명 고용했다면 묻지고 따지지 않고 컴퓨터를 한대 새로 사줌.
		this.desktop = new Desktop();
	}
	
	
	public void coding() {
		System.out.println(desktop.getInfo()+"으로 개발울 합니다.");
	}
}
