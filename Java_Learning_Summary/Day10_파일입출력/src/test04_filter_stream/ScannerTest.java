package test04_filter_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		method2();
		method3();

	}

	private static void method3() {

		try (Scanner sc = new Scanner(new FileInputStream("input.txt"))) {
			long start = System.nanoTime();

			while (sc.hasNext()) {
				int num = sc.nextInt();
			}
			long end = System.nanoTime();
			System.out.println("Scanner");
			System.out.println(end - start);

		} catch (IOException e) {

		}

	}

	// BufferedReader을 쓴 경우
	private static void method2() {
		// 문자 스트림 : FileReader, FileWriter
		// 버퍼 기능을 추가해보자 : BufferedReader, BufferedWriter

		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));) {
			long start = System.nanoTime();

			String line;
			while ((line = reader.readLine()) != null) {
				int num = Integer.parseInt(line);
			}
			long end = System.nanoTime();
			System.out.println(end - start);
		} catch (IOException e) {

		}
	}
}
