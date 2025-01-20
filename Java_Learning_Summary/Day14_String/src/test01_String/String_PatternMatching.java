package test01_String;

public class String_PatternMatching {

	public static void main(String[] args) {

		String text = "This iss a book";
		String pattern = "iss";
		
		System.out.println(bruteForce(text, pattern));

	}

	private static int bruteForce(String text, String pattern){
		int ti = 0;
		int pi = 0;

		while (ti < text.length() && pi < pattern.length()) {
			if (text.charAt(ti) != pattern.charAt(pi)) {
				ti -= pi;
				pi = -1;
				
			}
			ti++;
			pi++;
		}
		if(pi == pattern.length()) {
			// 찾았다
			return ti-pi;
			
		}else {
			// 못찾았다.
			return -1;
		}

	}
}
