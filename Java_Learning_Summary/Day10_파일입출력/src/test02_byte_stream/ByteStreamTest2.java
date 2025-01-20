package test02_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest2 {
	public static void main(String[] args) {
		// try with resources

		try (FileInputStream fis = new FileInputStream("human.png");
			FileOutputStream fos = new FileOutputStream("human-copy-2.png");) {
			
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
			System.out.println("끝.");
			
		} catch (IOException e) {
			
		}
		System.out.println("스트림은 알아서 닫혔습니다.");
	}
}
