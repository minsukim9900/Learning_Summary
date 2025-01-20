
class Dog {
	String name;
	int age;
	
	
	// 생성자에도 매개변수가 올 수 있따.
	// 생성자: 멤버 필드를 초기화하는데 사용.
	//기본 생성자는 만드는게 좋다(상속)
	Dog(){
		
	}
	
	Dog(String n, int a){
		name = n;
		age = a;
	}
}
