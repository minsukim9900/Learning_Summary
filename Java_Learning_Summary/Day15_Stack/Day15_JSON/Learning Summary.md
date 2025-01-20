# JAVA PJT - JSON

## JSON (JavaScript Object Notation)

### JSON

- 자바스크립트를 토대로 개발된 데이터 포맷
- 자바스크립트 객체를 문자열로 나타낸 것(이진 데이터가 아닌 텍스트 데이터)
- 여러 프로그래밍 언어에서 사용할 수 있는 독립형 데이터 형식
- 웹 클라이언트와 웹 서버 간 데이터 교환에 사용
- 웹 브라우저 비동기 처리에 사용되는 AJAX의 데이터 교환 형식으로 널리 알려짐
    - **A**synchronous **J**avaScript **A**nd **X**ML
- IETF RFC 7159, ECMA-404 표준으로 제정
    
    ```java
    {
    	"name" : "Alice",
    	"age" : 30
    }
    ```
    

### 자바스크립트의 객체

- ES6(ECMA2015)부터 클래스가 도입되었으나,
- 자바스크립트에서는 일반적으로 객체 리터럴을 이용해서 객체를 생성
- 중괄호 { } 안에 key - value 쌍을 나열하여 객체를 정의
- key : 속성의 이름, value : 속성의 값
- value에 메서드(함수)가 올 수 있음(자바스크립트에서 함수는 일급 객체)

```java
const person = { 
	name : 'Alice',
	age : 30,
	greet : function() {
		console.log('Hello, my name is ${this.name});
	}
}
```

### JSON 사용 이유

- 주요 프론트엔드 프레임워크에 의해서 지원
- 공식 포맷이기 때문에 개발자 사이에 데이터 통신을 할 수 있다
- 텍스트로 이루어져 있어 읽고 쓰기 쉽다.
- XML에 비해 용량이 적고 이해하기 쉽다.
- 언어와 플랫폼에 독립적이므로, 서로 다른 시스템간에 데이터 교환에 좋다.

### JSON은 key, value의 쌍으로 표현

```java
{ "key" : value, ... }
```

Key는 “ “로 묶어서 표현

Value는 String일 경우 “ “로 묶어서 사용

- object
- array
- number
- string
- true
- false
- null