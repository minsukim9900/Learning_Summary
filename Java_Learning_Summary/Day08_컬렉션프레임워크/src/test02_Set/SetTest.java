package test02_Set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		//Set
		// - 순서도 없고, 중복도 허용하지 않은 자료 구조
		// - 집합을 나타내는 자료구조
		// - 구현체로 HashSet을 사용
		// - 중복을 허용하지 않으므로 => 동일성 판단
		// - 동일성 판단 : hashcode & equals 메서드
		
		Set<String> names = new HashSet<>();
		
		names.add("luna");
		names.add("max");
		names.add("luna");
		names.add("daisy");
		names.add("luna");
		
		System.out.println(names);
	}
}
