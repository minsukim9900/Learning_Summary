package test01_String;

import java.util.Arrays;

public class String_Swap {
	
	public static void main(String[] args) {
		String str = "Hello minsu";
		char[] charArr = new char[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		System.out.println(Arrays.toString(charArr));
		
		// 1. 새로운 배열을 만들어서 뒤집기
		char[] nextArr = new char[charArr.length];
		
		// 원본 배열을 정방향 순회
		for(int i = 0; i < charArr.length; i++) {
			nextArr[charArr.length-1-i] = charArr[i];
		}
		
		System.out.println(Arrays.toString(nextArr));
		
		// 2. 원본 배열의 swap
		
		char[] charArr2 = str.toCharArray();
		// 문자열을 문자 하나하나 배열에 저장.
		System.out.println(Arrays.toString(charArr2));
		
		for (int i = 0; i<charArr2.length/2; i++) {
			char tmp = charArr2[i];
			charArr2[i] = charArr2[charArr2.length-1-i];
			charArr2[charArr2.length-1-i] = tmp;
		}
		
		System.out.println(Arrays.toString(charArr2));
	}
	
}
