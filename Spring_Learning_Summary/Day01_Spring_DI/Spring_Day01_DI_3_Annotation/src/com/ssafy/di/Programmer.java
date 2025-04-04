package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//컴퓨터 필요해

@Component(value = "p")
public class Programmer {
	private Computer computer;
	
	public Programmer() {
	}
	
	//생성자 주입
	@Autowired
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	// 설정자를 입력해서 주입할 수 있어
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	//메서드 주입 (여러개를 동시에 주입할 수 있음)
	public void init(Computer computer) {
		
	}



	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발울 합니다.");
	}
}
