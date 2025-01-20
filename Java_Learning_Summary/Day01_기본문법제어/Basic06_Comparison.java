package Java_Basic01;

public class Basic06_Comparison {
	public static void main(String[] args) {
		int a = 10;
		
		System.out.println(a > 10); // f
		System.out.println(a <= 10); // t
		System.out.println(a >= 10); // t
		System.out.println(a == 10); // t
		System.out.println(a != 10); // f
		
		//문자열은 어떻게 비교하는가?
		String c = "Hi";
		String d = "Hi";
		String e = new String("Hi");
		
		System.out.println(c == d); // t
		System.out.println(c == e); // f : 참조값(주소값)이 다르기 때문
		System.out.println(c.equals(e)); // t : 우리가 원하는 것은 주소 비교가 아니라 값 비교
		// 값 비교를 할 때는 equals를 쓴다.
		System.out.println(d.equals(e));
	
	}
}
