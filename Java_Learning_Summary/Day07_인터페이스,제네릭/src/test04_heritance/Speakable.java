package test04_heritance;

public interface Speakable {
	void eat();
	// 인터페이스 다중 상속 시, 시그니처(반환형, 메서드, (매개변수))이 겹쳐도
	// 상관 없다.
	// 어차피 구현부가 없기 때문에
	// => 클래스가 인터페이스를 구현하는 시점에 메서드 내용을 정의하면 된다.
	void speak();
	
	// 상수 (static)
}
