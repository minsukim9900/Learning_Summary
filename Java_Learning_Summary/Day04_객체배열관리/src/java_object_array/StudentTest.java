package java_object_array;

import java.util.Scanner;

//StudentManager
//Student
// 두 개의 클래스를 이요해서
// CRUD 구현하기

public class StudentTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentManager sm = StudentManager.getInstance();
		
		int sel;
		do {
			System.out.println("번호를 입력하세요~~!");
			System.out.println("1. 학생 추가 ");
			System.out.println("2. 학생 조회(이름으로...) ");
			System.out.println("3. 전공 변경 ");
			System.out.println("0. 종료 ");
			
			sel = sc.nextInt();
			if(sel == 1) {
				System.out.println("학생을 추가합니다");
				System.out.println("이름 : ");
				String name = sc.next();
				System.out.println("나이 : ");
				int age = sc.nextInt();
				System.out.println("전공 : ");
				String major = sc.next();
				Student st = new Student(name, age, major);
				sm.addStudent(st);
			}else if(sel == 2) {
				System.out.println("학생을 조회합니다.");
				System.out.println("이름 : ");
				String name = sc.next();
				Student st = sm.getStudent(name);
				System.out.println(st.getName());
				System.out.println(st.getAge());
				System.out.println(st.getMajor());
			}else if(sel == 3) {
				System.out.println("전공을 변경합니다");
				System.out.println("이름 : " );
				String name = sc.next();
				System.out.println("전공 : ");
				String major = sc.next();
				sm.changeMajor(name, major);
			}
		}while(sel != 0);
		
	}
	
}
