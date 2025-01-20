# DB - DDL, DML

## Data Type

### 숫자 자료형(Numeric Data Types)

### 문자 자료형(String Data Types)

### 날짜 자료형(Date and Time Data Types)

### BINARY 타입

### BLOB 타입

## DDL (Data Definition Language)

### 데이터베이스 생성하기

- CREATE DATABSE 명령문은 새 데이터 베이스를 생성하는데 사용
- 데이터 베이스는 여러 테이블을 포함
- 데이터 베이스 생성 시 관리자 권한으로 생성해야 한다.
- SHOW DATABASES → 데이터베이스 목록 확인 가능
    
    ```sql
    CREATE DATABASE ssafy;
    SHOW DATABASES;
    ```
    

### 데이터베이스 삭제

- 데이터베이스의 모든 테이블을 삭제하고 데이터베이스를 삭제
- 삭제 시, DROP DATABASE 권한 필요
- DROP SCHEMA는 DROP DATABASE와 동의어
- IF EXISTS는 데이터베이스가 없을 시 발생할 수 있는 에러를 방지
    
    ```sql
    DROP DATABASE ssafy;
    ```
    

### 데이터베이스 사용

- 데이터베이스가 있는 경우 USE 명령어를 이용하여 사용
    
    ```sql
    USE ssafy;
    ```
    

### 데이터베이스 문자 집합(Character set) 설정

- 데이터 베이스 생성 시 설정 또는 생성 후 수정 가능
- 문자집합은 각 문자가 컴퓨터에 저장될 때 어떠한 ‘코드’로 저장되는지 규칙을 지정한 집합이다.
- Collation은 특정 문자 집합에 의해 데이터베이스에 저장된 값들을 비교, 검색, 정렬 등의 작업을 수행할 때 사용하는 비교 규칙 집합이다.

### 테이블(Table) 생성하기

- CREATE 명령어를 통해 TABLE을 생성할 수 있음
- 컬럼명과 데이터 타입을 지정하고, 몇 가지 옵션(제약조건)을 추가 할 수 있음.

### 제약 조건(CONSTRAINT)

- 컬럼에 저장될 데이터의 조건을 설정
- 제약조건에 위배되는 데이터는 저장 불가
- 테이블 생성 시 컬럼에 지정하거나, constraint로 지정 가능
(ALTER 를 이용하여 설정가능)


### 테이블(Table) 스키마

- 스키마(Schema) : 테이블에 저장 될 데이터의 구조와 형식
- 테이블 스키마 확인하기
    - DESCRIBE 또는 DESC 명령어를 이용하여 생성된 테이블 스키마 확인
    
    ```sql
    DESC ssafy_user;
    ```
    

## DML (Data Manipulation Language)

### DML

- 데이터베이스에 데이터를 삽입, 조회, 수정, 삭제 할 때 사용  

### INSERT 문

- 생성 시 작성한 모든 컬럼에 입력 값이 주어지면 컬럼이름 생략 가능
- 컬럼 이름과 입력 값의 순서가 일치하도록 작성
    - (NULL, DEFAULT, AUTO INCREMENT 설정 필드 생략 가능)

### UPDATE 문

- 기존 레코드를 수정한다.
- WHERE 절을 이용해 하나의 레코드 또는 다수의 레코드를 한 번에 수정할 수 있다.
- WHERE 절을 생략하면 테이블의 모든 행이 수정
- (Safe Mode) 체크 시 작동 X

### DELETE 문

- 기존 레코드를 삭제한다.
- WHERE 절을 이용해 하나의 레코드 또는 다수의 레코드를 한 번에 삭제할 수 있다.

## MySQL Functions

### MySQL 내장 함수

- MySQL은 많은 내장함수를 가지고 있다.
- 문자열, 숫자, 날짜, 그 외 에 대해서 다양한 함수를 제공한다.
    - 숫자 관련 함수
    - 문자 관련 함수
    - 날짜 관련 함수
    - 논리 관련 함수
    - 그룹 함수

## Transaction

### 트랜잭션

- 커밋(Commit) 하거나 롤백(Rollback)할 수 있는 가장 작은 작업 단위
- 커밋(Commit) : 트랜잭션을 종료하여 변경사항에 대해서 영구적으로 저장하는 SQL
- 롤백(Rollback) : 트랜잭션에 의해 수행된 모든 변경사항을 실행 취소하는 SQL
- MySQL에서는 기본이 Auto Commit 상태(오류가 없으면 자동 Commit)