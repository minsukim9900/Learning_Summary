package com.ssafy.di04_dependency_injection;

public class ComputerFactory {

	public static Computer getComputer(String type) {
		if (type.equals("D"))
			return new Desktop();
		else if (type.equals("L"))
			return new Laptop();
		return null;
	}
}
