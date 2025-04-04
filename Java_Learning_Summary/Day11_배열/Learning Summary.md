# SW문제해결기본 - Array 1

### Array

- 알고리즘 : 문제 해결하기 위한 절차
- 배열 : 알고리즘 문제 해결을 위한 도구
- 정렬 : 무작위로 나열된 데이터를 특정 기준으로 재배치하는 것
    - 버블 정렬(Bubble Sort)
</aside>

## 알고리즘

### 알고리즘

문제를 해결하기 위해 수행해야 하는 절차나 방법

- 컴퓨터 과학에서의 알고리즘 : 원하는 결과를 얻기 위해 프로그램이 수행해야 하는 절차

### APS ( Algorithm Problem Solving)

- 알고리즘 문제 : 주어진 문제에 따라 원하는 결과를 낼 수 있도록 프로그램을 작성하는 문제
- 프로그래밍 역량을 테스트하기 위한 문제 풀이

### APS를 해야하는 이유

1. 문제 해결 방법 그 자체를 아는 것에 의의
2. 구현 역량을 키울 수 있다.
3. 디버깅 경험을 쌓을 수 있다.
    1. 버그 : 개발자가 의도하지 않은 동작을 하는 코드
4. 채용 과정에서 중요하게 평가된다.
    1. 코딩 테스트

### APS 과정의 목표

다양한 알고리즘을 이해하고, 문제의 조건에 맞는 좋은 알고리즘을 선택할 수 있게 되는 것

### 무엇이 좋은 알고리즘인가?

1. 정확성 : 얼마나 정확하게 동작하는가? ⇒ 정확하기 않으면 문제 해결 x
2. 작업량 : 얼마나 적은 연산으로 원하는 결과를 얻어내는가 ⇒ 실행시간
3. 메모리 사용량 : 얼마나 적은 메모리를 사용하는가
4. 단순성 : 다른 사람이 이해하기 쉬운가 ⇒ 가독성 좋은 알고리즘
5. 최적성 : 더 이상 개선할 여지없이 최적화되었는가

### 실행시간 vs 메모리 사용량

: 메모리 사용량은 돈으로 살 수 있다. 실행시간은 돈으로 살 수 없다.

## 알고리즘 성능

알고리즘의 작업량을 표현할 때 시간복잡도로 표현한다.

시간 복잡도(Time Complexity)

- 실제 걸리는 시간을 측정 ⇒ cpu 성능에 따라 실행 시간이 다르다.
- 실행되는 명령문의 개수를 계산 ⇒ 현실적으로 어렵다.

### 시간 복잡도 = 빅-오 표기법

- 빅-오 표기법(Big-Oh Notation)
- 시간 복잡도 함수 중에서 가장 큰 영향력을 주는 n에 대한 항만을 표시
- 계수(Coefficient)는 생략하여 표시
- n개의 데이터를 입력 받아 저장한 후 각 데이터에 1씩 증가시킨 후 각 데이터를 화면에 출력하는 알고리즘의 시간복잡도는 어떻게 되나?
    - O(n)

## 배열

### 자료구조

자료구조: 데이터를 효율적으로 담는 방법을 정의한 것

- 데이터의 추가, 조회, 수정, 삭제 연산을 최적화 하는 구조

프로그램의 목적에 따라 활용할 수 있는 다양한 자료구조가 존재한다.

- Array, List, Stack, Queue, Tree…

효율적인 알고리즘을 구현하기 위해서는 효율적인 자료구조가 필수적

### 배열이란 무엇인가? (자료구조로서의 배열)

문제 해결을 위한 도구

- 동일한 자료형의 변수들을 하나의 변수에 담기 위한 자료구조

배열의 필요성

- 프로그램 내에서 여러 개의 데이터를 다뤄야 할 때, 별도의 변수를 선언하여 프로그래밍 하는 것은 비효율적.
- 배열을 사용하면 한 번의 선언을 통해서 여러 개의 데이터를 다룰 수 있다.

### APS 위한 5단계

1. 문제를 꼼꼼하게 읽고 입력 데이터의 범위를 확인한다.
2. 문제의 조건과 입력 데이터의 범위에 맞는 알고리즘을 선택한다.
3. 코드를 작성하기 전에 풀이를 구상한다.
    
    ⇒ 코드 작성 시간 < 설계 시간
    
4. 구상한 풀이를 코드로 작성한다.
5. 디버깅하고 검증한다.

## 정렬

2개 이상의 데이터를 특정 기준에 의해 작은 값부터 큰 값(오름차순 : asccending),
혹은 그 반대의 순서대로(내림차순 : descending) 재배열하는 것

키

- 자료를 정렬하는 기준이 되는 특정 값

대표적인 정렬 방식의 종류

- 버블 정렬 (Bubble Sort)
- 선택 정렬 (Selection Sort)
- 삽입 정렬 (Insertion Sort)
- 카운팅 정렬 (Counting Sort)
- 병합 정렬 (Merge Sort)
- 퀵 정렬 (Quick Sort)

### 버블 정렬 (Bubble Sort)

인접한 두 개의 원소를 비교한 후 교환하는 과정을 반복하여 데이터를 정렬하는 방식

정렬 과정

- 첫 번째 원소부터 인접한 원소와 비교하여 자리를 교환해가면서 마지막 자리까지 이동한다.
- 오름차순 정렬 기준한 사이클이 끝나면 가장 큰 원소가 마지막 자리로 위치한다.
- 교환하며 자리를 이동하는 모습이 물 위에 올라오는 거품 모양과 같다고 하여 버블 정렬이라고 한다.

시간 복잡도

- O(n^2)