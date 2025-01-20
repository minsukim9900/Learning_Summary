package test01_String;

public class String_Initalization {
	
	public static void main(String[] args) {
		
		// 문자열의 초기화
		
		String lstr1 = "Hello";
		String lstr2 = "Hello";
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		System.out.println(lstr1 == lstr2);
		System.out.println(str1 == str2);
	}
	
}
