package test04_filter_stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));	
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		
		
		
		
		// System.in => 표준 입력 - 키보드 - ByteStream
		// InputStreamRader => byte -> character
		// BufferedReader => buffer 기능 추가
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			
		}
		System.out.println(Arrays.toString(nums));
	
	}
}
