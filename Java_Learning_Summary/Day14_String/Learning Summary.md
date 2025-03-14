# SW문제해결기본 - String

## 문자열(String)

### 문자의 표현

컴퓨터에서의 문자표현

- 컴퓨터는 문자 ‘A’를 메모리에 어떻게 저장할까?
- 컴퓨터는 모든 데이터를 비트 단위(2진수)로 저장하므로 문자를 직접 저장할 수 없다.
- 정수의 형태로 문자와 짝지어진 수를 저장하도록 한다.
- 영어 알파벳은 대소문자를 합쳐서 52개 이므로 6비트면 모든 알파벳을 표현할 수 있다.이를 코드체계라고 한다.
    - 000000 → ‘a’
    - 000001 → ‘b’
    - 001100 → ‘z’

과거 미국에서는 지역마다 코드체계가 달랐다.

인터넷이 발전한 후 다른 지역 간 정보를 주고 받으면서 해석하는 내용이 서로 달라지게 되는 문제가 생겼다.

코드 체계가 달라 발생하는 혼동을 막기 위해 코드 체계의 표준안을 만들었다.

1967년, 미국에서 ASCII(American Standard Code for Information Interchange)라는 문자 인코딩 표준이 제정되었다.

ASCII는 7bit 인코딩으로 128종류의 문자를 표현하며 33개의 출력 불가능한 제어 문자들과 공백을 비롯한 95개 출력 가능한 문자들로 이루어져 있다.

확장 아스키는 표준 문자 이외의 악센트 문자, 도형 문자, 특수 문자, 특수 기호 등 부가적인 문자를 128개 추가할 수 있게 하는 부호이다.

- 확장 아스키는 1Byte 내의 8bit를 모두 사용함으로써 추가적인 문자를 표현할 수 있다.
- 컴퓨터 생산자와 소프트웨어 개발자가 여러 가지 다양한 문자를 할당할 수 있도록 하고 있다. 이렇게 할당된 확장 부호는 표준 아스키와 같이 서로 다른 프로그램이나 컴퓨터 사이에 교환되지 못한다.
- 표준 아스키는 마이크로컴퓨터 하드웨어 및 소프트웨어 사이에서 세계적으로 통용되는 데 비해, 확장 아스키는 프로그램이나 컴퓨터 또는 프린터가 그것을 해독할 수 있도록 설계되어 있어야만 올바르게 해독될 수 있다. ⇒ 통역과 필요

오늘날 대부분의 컴퓨터는 ASCII형식의 코드 체계를 사용한다.

컴퓨터가 발전하면서 미국 뿐 아니라 세계적으로 컴퓨터가 발전했으며 각 국가들은 자국의 문자를 표현하기 위하여 코드체계를 만들어서 사용하게 되었다.

- 우리나라도 한글 코드 체계를 만들어 사용했고 조합형, 완성형 두 종류를 가지고 있다.

인터넷이 전 세계로 발전하면서 ASCII를 만들었을 때의 문제와 같은 문제가 국가간에 정보를 주고 받을 때 발생했다.

자국의 코드체계를 타 국가가 가지고 있지 않으면 정보를 잘못 해석할 수 밖에 없었다.

그래서 다국어 처리를 위해 표준을 마련했다. 이를 유니코드라고 한다.

유니코드도 다시 Character Set으로 분류된다.

- 유니코드를 저장하는 변수의 크기를 정의
- 그러나, 바이트 순서에 대해서 표준화하지 못했다.
- 다시 말해 파일을 인식 시 이 파일이 UCS-2, UCS-4인지 인식하고 각 경우를 구분해서 모두 다르게 구현해야 하는 문제 발생
- 그래서 유니 코드의 적당한 외부 인코딩이 필요하게 되었다.

유니코드 인코딩(UTF : Unicod Transformation Format)

- UTF-8 (in web)
- UTF-16(in windows, java)
- UTF-32(in unix)

### 문자열

일련의 문자(character)를 담을 수 있는 자료구조

Java에서는 String class로 구현되어 있다.

문자열을 선언하는 두 가지 방법

```java
// 리터럴(literal) 표기 방식
String a = "Hello";
// new 연산자 사용 방식
String b = new String("Hello");
```

리터럴 표기 방식과 new 연산자 사용 방식의 차이

리터럴 표기로 선언하게 되면 문자열 상수 풀에 생성됨

### 문자열 뒤집기

- 문자열 자기 자신 내에서 뒤집는 방법, 새로운 빈 문자열을 만들어 뒤에서부터 쓰는 방법
- 자기 문자열을 이용할 경우 swap을 위한 임시 변수 필요, 반복 수행을 문자열 길이의 반만 수행
- Java에서는 StringBuffer 클래스의 reverse() 메소드를 이용하면 된다.

### 문자열 상수 풀

문자열을 리터럴 상수 방식으로 선언하게 되면 해당 객체는 JVM 메모리 힙 영역 안의 문자열 상수 풀에 저장된다.

문자열을 리터럴 상수 방식으로 선언할 때마다 문자열 상수풀에 같은 문자열이 있는지 확인하여 문자열이 같다면 같은 객체를 가리키도록 한다.

## 패턴 매칭

패턴 매칭에 사용되는 알고리즘들

- 고지식한 패턴 검색 알고리즘
- 카프-라빈 알고리즘
- KMP 알고리즘
- 보이어-무어 알고리즘

**고지식한 알고리즘(Brute Force)**

- 본문 문자열을 처음부터 끝까지 차례대로 순회하면서 패턴 내의 문자들을 일일이 비교하는 방식으로 동작

### 보이어 무어 알고리즘

- 오른쪽에서 왼쪽으로 비교
- 대부분의 상용 소프트웨어에서 채택하고 있는 알고리즘
- 보이어-무어 알고리즘은 패턴에 오른쪽 끝에 있는 문자가 불일치 하고 이 문자가 패턴 내에 존재하지 않는 경우, 이동 거리는 무려 패턴의 길이 만큼이 된다.