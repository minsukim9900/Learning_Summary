package java_singleton;

public class ScoreTest {
	
	public static void main(String[] args) {
		//ScoreManager sm = new ScoreManager();
		// 생성자를 private으로 막아놨기 떄문에 객체를 생성해서 쓸 수 없음
	
	
		// 객체는 getInstance static 메서드르 이용해서 가져온다.
		ScoreManager sm1 = ScoreManager.getInstance();
		ScoreManager sm2 = ScoreManager.getInstance();
		ScoreManager sm3 = ScoreManager.getInstance();
		ScoreManager sm4 = ScoreManager.getInstance();
		System.out.println(sm1 == sm2);
	
	}
	
}
