# SW문제해결응용 - 그래프 응용

## 위상 정렬(Topological Sorting)

### 위상 정렬이란

- 순서가 있는 작업을 차례로 진행해야 할 때 순서를 결정 해주기 위해 사용하는 알고리즘
- 사이클 없는 방향 그래프의 모든 노드를 주어진 방향성에 어긋나지 않게 순서를 나열하는 것
- ex) 대학 선수 과목, 공장의 작업 순서, 요리 순서, … 등

### 사전 지식

- DAG(Directed Acyclic Graph : 유향 비사이클 그래프)
- 진입 차수 : 특정 노드로 들어오는 간선의 개수
    - 선행 조건의 유무
- 진출 차수 : 특정 노드에서 나가는 간선의 개수

## 위상 정렬(Queue 구현)

### 위상 정렬 방법(Queue 사용)

1. 진입 차수가 0인 모든 노드를 Queue에 삽입
2. Queue가 공백상태가 될 때까지 반복 수행
    1. Queue에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거
    2. 새롭게 진입 차수가 0이 된 노드를 Queue에 삽입한다.
- Queue에서 꺼내지는 순서(Queue에 들어오는 순서)가 정렬을 수행한 결과

## 위상 정렬(Stack 구현)

### 위상 정렬 방법(Stack 사용)

1. 진입 차수가 0인 모든 노드에서 DFS 탐색 수행
2. DFS 수행
    1. 해당 노드를 방문 표시
    2. 인접하면서 방문하지 않은 노드가 있다면 DFS 재귀 호출
    3. 함수 리턴 하기 전 Stack에 현재 노드 저장
3. Stack이 공백 상태가 될 때까지 pop
- Stack에서 꺼내지는 순서를 뒤집으면 위상 정렬을 수행한 결과이다.

### 위상 정렬 특징

- 모든 정점을 방문하기 전에 Queue가 공백 상태가 되면 사이클이 존재하는 것이다.
    
    (사이클이 존재하면 진입 차수가 0이 될 수 없음)
    
- 그래프 유형은 DAG
- 여러 해답이 존재할 수 있다.
    
    (진입 차수가 0인 값이 동시에 생성이 된다면 작성한 코드 방법에 따라 답이 달라진다.
    
- 시간 복잡도 O(V+E)