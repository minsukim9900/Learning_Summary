# SW문제해결기본 - Array3

## 2차원 배열

### 2차원 배열

2차원 배열의 선언

- 2차원 배열의 선언 : 세로 길이(행의 개수), 가로 길이(열의 개수)를 필요로 함
    - 행 : 1차원 배열의 갯수,
    - 열 : 1차원 배열의 크기
- 배열 : 동일한 자료형의 data를 여러 개 담을 수 있는 자료 구조
- 배열은 참조 자료형, 객체이다. 객체는 heap 영역에 구현이 된다.
- 2차원 배열 : “1차원 배열”들을 담을 수 있는 배열

```java
int[][] twoDimArr = new int[2][4];
int[][] twoDimArr = new int[2][]; // 행은 필수
```

### 2차원 배열의 접근

**배열 순회**

- n x m 배열의 n * m 개의 모든 원소를 빠짐 없이 조사하는 방법

```java
public class Array3_TwoDImArr_Circuit {

	public static void main(String[] args) {

		// n X m 배열의 n * m 개의 모든 원소를 빠짐 없이 조사하는 방법
		int N = 3;
		int M = 3;
		int[][] twoDimArr = new int[N][M];

		// 정방향 행 우선 순회
		int num = 1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				twoDimArr[r][c] = num++;
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 역방향 행 우선 순회
		
		for (int r = 0; r<N; r++) {
			for(int c= twoDimArr[r].length-1; c>=0; c--) {
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 열 우선 순회
		
		for (int c = 0; c < M; c++) {
			for (int r = 0; r < N; r++) {
				System.out.print(twoDimArr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 지그제그 순회
		
		for (int r = 0; r < N; r++) {
			if (r % 2 == 0) {
				for (int c = 0; c < M; c++) {
					System.out.print(twoDimArr[r][c] + " ");
				}
			} else {
				for (int c = M - 1; c >= 0; c--) {
					System.out.print(twoDimArr[r][c] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
```

**델타를 이용한 2차원 배열 탐색**

델타 : 변화량

델타 배열 : 이동 후의 좌표차이를 저장해둔 배열

```java
public class Array3_DeltaQuest {
	// 상, 하, 좌, 우 각 대각선
	private static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {

		int[][] arr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
		}

		// 델타를 이용한 2차원 배열 탐색

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				deltaquest(arr, r, c);
				System.out.println();
			}
		}
	}

	public static void deltaquest(int[][] arr, int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[r].length) {
				System.out.printf("%d방향, 값: %d, ", i, arr[nr][nc]);
			}
		}
	}

}
```

**전치 행렬**

```java
public class Array3_TransposedMatrix {

	// 전치행렬
	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		
		for (int r = 0; r < arr.length; r++) {
			
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
			
		}
		System.out.println(Arrays.deepToString(arr));
		
		// 전치행렬 구현
		for (int r = 0; r < arr.length; r++) {
			
			for (int c = 0; c < arr[r].length; c++) {
				if(r < c) {
					int tmp = arr[r][c];
					arr[r][c] = arr[c][r];
					arr[c][r] = tmp;
				}
			}
			
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		for(int r = 0; r<arr.length; r++) {
			
			for (int c = r+1; c<arr[r].length; c++) {
				int tmp = arr[r][c];
				arr[r][c] = arr[c][r];
				arr[c][r] = tmp;
			}
			
		}
		
		System.out.println(Arrays.deepToString(arr));

	}

}
```

**2차원 배열의 회전**

```java
public class Array3_Rotate {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[3][3];
		int[][] rotateArr = new int[3][3];

		int num = 1;
		// 배열 값 정의
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
		}
		
		for(int r = 0; r<arr.length; r++) {
			for(int c = 0; c<arr[r].length; c++) {
				rotateArr[r][c] = arr[arr[r].length-1-c][r];
			}
		}
		System.out.println(Arrays.deepToString(rotateArr));
	}
	
}

```

## 다차원 배열

### 2차원 이상의 배열 선언

- 다차원 배열은 차원 수 만큼의 index를 필요로 한다.
- N차원 배열은 ‘(N-1)차원 배열’의 배열

```java
int[][][] ThreeDimArr= new int[3][2][3];
// 2행 3열의 2차원 배열 3래를 담을 수 있는 배열 
```