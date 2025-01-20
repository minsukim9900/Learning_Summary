package test02_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest1 {
	public static void main(String[] args) {
		// byte stream을 이용해서 이미지를 입출력해보자!
		// stream => close() => finally
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("human.png");
			fos = new FileOutputStream("human-copy.png");
			
			int b; // byte 바구니
			
			while((b = fis.read()) !=-1) { // 허나의 바이트를 읽어와서, 있다면
				fos.write(b); // 하나의 바이트를 출력 스트림에 쓴다.
			}
			System.out.println("복사 끝.");
		} catch (IOException e) {
		
		} finally {
			try {
				if( fis != null)
				fis.close(); // null.close(); => 
				if( fos != null)
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
