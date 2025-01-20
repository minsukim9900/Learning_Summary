# SW문제해결응용 - 그래프 탐색

## 그래프 탐색

### 모든 노드를 빠짐 없이 탐색하는 방법은 두 가지

1. 깊이 우선 탐색 (Depth First Search, DFS)
2. 너비 우선 탐색 (Breadth First Search, BFS)

## 깊이 우선 탐색 (DFS, Depth First Search)

### DFS

- 깊이 우선 탐색
- 시작 지점에서 출발하여 한 방향으로 탐색
- 진행 할 수 없다면 마지막에 만난 지점으로 돌아와 다른 방향 다시 탐색
- 후입 선출(LIFO : Last-In First-Out) 구조의 스택(Stack) 사용
- 재귀함수는 System Stack을 활용하므로 간단하게 구현 가능

### 트리 탐색

1. 루트 노드 → Stack Push
2. Stack → Empty가 될 때까지 반복 수행
    1. 현재 노드 → Stack.pop
    2. 현재 노드의 모든 자식 → Stack push

## 너비 우선 탐색 (BFS, Breadth First Search)

### BFS

- 너비 우선 탐색
- 시작 지점에 인접한 순으로 탐색을 시작
- 인접한 지점을 모두 방문하였다면 다음으로 인접한 지점을 방문함
- 선입 선출(FIFO, First-In First-Out) 구조의 Queue 자료구조를 사용
- 너비 우선 탐색은 시작 지점과 끝 지점이 주어졌을 때 최단 길이를 구할 수 있음