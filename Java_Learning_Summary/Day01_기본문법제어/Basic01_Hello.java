package Java_Basic01;

public class Basic01_Hello {
	// 자바는 자동완성을 적극적으로 활용!!
	// ctrl + spacebar
	// main + ctrl + spacebar
	
	public static void main(String[] args) {
		
		//sysout + ctrl + spacebar
		
		System.out.println("Hello World");
		
		/*
		 여러줄 주석입니다.
		 */
		/**
		 문서화 주석입니다.
		 */
		
		// \n을 사용하면 줄이 바뀐다.
		System.out.println("Hello World!!");
		System.out.println("Hello World!!");
		
		System.out.println("\\");
		System.out.println("\"");
		
		System.out.printf("%d\n", 10); // 정수 (10진수)
		System.out.printf("%o\n", 10); // 정수 (8진수)
		System.out.printf("%x\n", 10); // 정수 (16진수 소문자)
		System.out.printf("%X\n", 10); // 정수 (16진수 대문자)
		
		System.out.printf("%4d\n", 10); //4칸을 확보한 후 오른쪽부터 차지
		System.out.printf("%-4d\n", 10); //4칸을 확보한 후 왼쪽부터 차지
		System.out.printf("%04d\n", 10); //4칸을 확보한 후 오른쪽부터 차지 (빈칸은 0)
		
		System.out.printf("%f\n", 10.12345); //실수
		System.out.printf("%.2f\n", 10.12345); //실수(소수점 둘째자리까지 반올림)
		
		System.out.printf("%s\n", "싸피"); //문자열
		System.out.printf("%c\n", 'A'); //문자
		System.out.printf("%d\n", (int)'A'); //문자를 정수로 출력
		
	}
}
