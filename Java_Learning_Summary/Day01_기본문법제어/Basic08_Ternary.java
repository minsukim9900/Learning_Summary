package Java_Basic01;

public class Basic08_Ternary {
	
	public static void main(String[] args) {
		// 삼항 연산자
		// 조건식? 식1(참) : 식2(거짓)
		
		//랜덤 숫자 발생기
		int num = (int) (Math.random()*10) + 1;
		
		// Math.random() => 0 <= x < 1 
		
		// num이 홀수인지 짝수인지.
		System.out.println(num);
		System.out.println(num % 2 == 0 ? "짝" : "홀");
	}

}
