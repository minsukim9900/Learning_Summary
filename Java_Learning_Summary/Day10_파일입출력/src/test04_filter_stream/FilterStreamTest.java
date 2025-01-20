package test04_filter_stream;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterStreamTest {
	public static void main(String[] args) {
		method1();

		method2();
	}

	

	private static void method1() {
		// 문자 스트림 : FileReader, FileWriter
		
		
		try (FileReader reader = new FileReader("input.txt"); FileWriter writer = new FileWriter("input4.txt");) {

			long start = System.nanoTime();
			int c; // 문자열 바구니
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			long end = System.nanoTime();
			System.out.println("복사 끝.");
			System.out.println(end-start);
		} catch (IOException e) {

		}
	}
	
	private static void method2() {
		// 문자 스트림 : FileReader, FileWriter
		// 버퍼 기능을 추가해보자 : BufferedReader, BufferedWriter

		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("input5.txt"));) {
			long start = System.nanoTime();

			String line;
			while((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			long end = System.nanoTime();
			System.out.println("복사 끝.");
			System.out.println(end-start);
		} catch (IOException e) {

		}
	}
}
