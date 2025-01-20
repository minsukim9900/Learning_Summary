# Q1. 숫자 관련 함수 사용
-- 2의 3제곱
SELECT pow(2, 3) AS "2**3"
FROM dual; -- 가짜 문법용 테이블

-- 8 나누기 3의 나머지

SELECT mod(8, 3) AS '8%3';

-- 최대값과, 최소값
SELECT greatest(10,20,30,40,50), least(10,20,30,40,50);

-- 반올림
SELECT round(3.41592), round(3.141592, 0), round(3.141592, 1), round(3.141592, 2);

# Q2. 문자 관련 함수
-- ASCII 코드 값 얻기
SELECT ascii('0'), ascii('a'), ascii('A');

-- concat 메서드를 써보자.
SELECT concat('3번 유저의 이름은 ', user_name ,' 입니다.')
FROM ssafy_user
WHERE user_num = 3;

-- 아이디 길이가 6글자인 사람의 정보를 가져오자
SELECT *
FROM ssafy_user
WHERE length(user_id) = 6;

-- 김싸피
SELECT length("김싸피"), char_length("김싸피");
SELECT length("🍕"), char_length("🍕");

-- 문자열 변경
SELECT replace ('Hello abs abs', 'abs', 'ssafy');

-- 문자열 인덱스 (db는 1부터 시작이다.)
SELECT instr("Hello SSAFY", "SSAFY");

-- 모든 직원의 이름 3자리 조회
SELECT substr(user_name, 1, 3)
FROM ssafy_user;

-- LPAD RPAD
SELECT lpad("SSAFY", 10, '*');
SELECT rpad("SSAFY", 10, '*');

-- REVERSE
SELECT reverse("수박이박수");
SELECT reverse("Hello SSAFY");
SELECT reverse("우영우역삼역기러기인도인별동별스위스");

# Q3. 날짜 관련 함수 

-- 2초 더하기
SELECT addtime("2024-09-26 10:47:50", "10");

-- 날짜차이
SELECT datediff("2024-12-31", "2024-12-17");

-- 오늘은?
SELECT yearweek(now());

# Q4. 트랜잭션 사용해보기
-- AutoCommit 해제
SET autocommit = 0;

USE ssafy;
CREATE TABLE test_table(
	val VARCHAR(2)
);

START TRANSACTION;
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('B');
INSERT INTO test_table VALUES ('C');
INSERT INTO test_table VALUES ('D');
INSERT INTO test_table VALUES ('E');

ROLLBACK;

SELECT * FROM test_table;

START TRANSACTION;
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('F');
INSERT INTO test_table VALUES ('Y');

COMMIT;
