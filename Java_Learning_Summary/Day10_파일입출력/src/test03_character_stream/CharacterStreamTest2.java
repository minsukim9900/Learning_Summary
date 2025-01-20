package test03_character_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest2 {
	public static void main(String[] args) {
		// 문자 스트림 : FileReader, FileWriter

		try (FileReader reader = new FileReader("input.txt");
				FileWriter writer = new FileWriter("input3.txt");) {

			int c; // 문자 버퍼를 채운 갯수
			char[] buffer = new char[10];
			while ((c = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, c);
			}
			System.out.println("복사 끝.");
		} catch (IOException e) {

		}
	}
}
