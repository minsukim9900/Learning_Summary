# Q1. ssafydb 데이터 베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;

-- 테이블 생성
CREATE TABLE ssafy_user (
	user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_email VARCHAR(30),
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 테이블 정보 확인
DESC ssafy_user;

SELECT * FROM ssafy_user;

# Q3. INSERT 쿼리를 사용해보자
-- 모든 컬럼 입력을 하겠다.
INSERT INTO ssafy_user
VALUES (10, "minst01", "김민수", "1234", "visang96@naver.com", now());

-- 원하는 컬럼만 작성 (데이터타입이 다를 수 있으므로 맞춰서 작성
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("minst01", "김민수","1q2w3e4r");

-- 여러 행을 동시에 입력해보자.
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("minst01", "김민수","1q2w3e4r"),
	   ("minst02", "김민수","1q2w3e4r"),
       ("minst03", "김민수","1q2w3e4r"),
       ("minst04", "김민수","1q2w3e4r");

# Q4. 데이터를 수정해보자
-- UPDATE ssafy_user
-- SET user_name = "anonymous";

UPDATE ssafy_user
SET user_password = "ssafy"
WHERE user_num = 3;

# Q5. 데이터를 삭제해보자
DELETE FROM ssafy_user
WHERE user_num = 14;
       