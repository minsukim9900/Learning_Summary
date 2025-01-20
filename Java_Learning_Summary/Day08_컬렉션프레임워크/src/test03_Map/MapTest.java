package test03_Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		// Map
		// - 사전과 같은 자료구조
		// - 키 & 값의 쌍으로 구성되어 있음
		// - 키는 구별이 되어야 함(중복 허용하지 않음, 순서도 없음)
		// - 값은 중복될 수 있음.
		
		//Map의 키 자료형으로 사용자 정의 클래스가 온다면?
		//Set의 경우와 마찬가지로 hashCode(), equals() 메서드를 오버라이드 해줘야 함.
		
		Map<String, String> map = new HashMap<>();
		
		map.put("luna", "cat");
		map.put("max", "dog");
		map.put("daisy", "cow");
		map.put("toby", "cat");
		
		// 키는 중복이 되지 않고, 만약에 똑같은 키에 새로운 값을 넣으면
//		// 새로운 값으로 수정된다.
//		System.out.println(map);
//		
//		System.out.println(map.get("daisy"));
//		System.out.println(map.containsKey("max"));
//		
//		// 값이 있는지 확인
//		System.out.println(map.containsValue("dog"));
		
		//맵의 순회
		// 1. keySet();
		for(String key : map.keySet()) {
			System.out.printf("%s : %s\n", key, map.get(key));
		}
		
		// 2. entrySet() => Entry : 키-값의 쌍
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
		}
	}
}
