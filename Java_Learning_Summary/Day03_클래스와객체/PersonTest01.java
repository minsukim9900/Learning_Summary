
public class PersonTest01 {
	public static void main(String[] args) {
		String yang_name = "Yang";
		int yang_age = 45;
		String yang_hooby = "YouTube";
		
		String hong_name = "Hong";
		int hong_age = 25;
		String hong_hobby = "Golf";
		
		//----- 변수가 너무 많다. => 배열로!
		
		int Size = 2;
		String[] names = new String[Size];
		int[] ages = new int[Size];
		String[] hobbies = new String[Size];
		
		names[0] = "Yang"; // index - 사람의 정보가 사실은 연관성이 없다.
		names[1] = "Hong"; // 임의로 관계를 맺어줘야 한다.
		ages[0] = 45;
		ages[1] =25;
		hobbies[0] = "Youtube";
		hobbies[1] = "Golf";
	}
}
