package test01_file;

import java.io.File;

public class Filetest {
	public static void main(String[] args) {
		// File : 파일 & 디렉토리 관리하기 위한 클래스
		File f = new File("human.png"); // 상대 경로를 쓰고 있다.
		System.out.println(f.exists());
		System.out.println(f.isFile());
		System.out.println(f.isAbsolute());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.length() + "bytes.");
		
		
		File src = new File("src");
		System.out.println(src.exists());
		System.out.println(src.isDirectory());
		
		File folder = new File("folder");
		System.out.println(folder.exists());
		folder.mkdir();
	}
}
