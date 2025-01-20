package Java_Basic01;

public class Basic05_Arithmetic {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;

		System.out.println(a + b); // 16
		System.out.println(a - b); // 4
		System.out.println(a * b); // 60
		System.out.println(a / b); // 1
		System.out.println(a % b); // 4

		System.out.println((double) a / b);
		System.out.println(a / (double) b);
		System.out.println((double) (a / b));
		
		System.out.println(13.4f / 20L);
		
		double c = 2.3;
		
		System.out.println(a / c);
		System.out.println(a / (int) c);
	}
}
