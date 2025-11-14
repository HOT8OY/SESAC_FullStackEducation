/* CONSTRAINTS(제약 조건) */

# NOT NULL
-- NULL값 허용하지 않음
CREATE TABLE IF NOT EXISTS user_notnull(
	user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3)
)ENGINE=INNODB;
-- NULL이 없는 데이터는 잘 추가된다.
INSERT INTO user_notnull VALUES(1, 'user01', 'pass01', '남');
SELECT * FROM user_notnull; -- 테이블 확인

-- NULL이 들어가면 해당 데이터가 추가되지 않는다.
INSERT INTO user_notnull VALUES(2, 'user02', NULL, '여');


# UNIQUE
-- 중복값 허용하지 않음
CREATE TABLE IF NOT EXISTS user_unique(
	user_no INT NOT NULL UNIQUE,	-- 회원번호는 중복될 수 없다(컬럼 레벨 선언 방식)
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    UNIQUE (user_id) -- id도 중복될 수 없다(테이블 레벨 선언 방식)
)ENGINE=INNODB;

-- 문제 없이 들어감
INSERT INTO user_unique VALUES(1, 'user01', 'pass01', '남');
 -- 중복값(user_no)때문에 에러 발생
INSERT INTO user_unique VALUES(1, 'user02', 'pass02', '여');
-- 중복값(user_id)때문에 에러 발생
INSERT INTO user_unique VALUES(2, 'user01', 'pass02', '남');
-- UNIQUE가 걸리지 않은 것은 중복 가능
INSERT INTO user_unique VALUES(3, 'user03', 'pass01', '남');

# PRIMARY KEY
-- 테이블에서 한 행의 정보를 찾기 위해 사용 할 컬럼을 의미한다.
-- 테이블에 대한 식별자 역할을 한다 (한 행씩 구분하는 역할)
-- NOT NULL + UNIQUE 제약조건의 의미를 가짐
CREATE TABLE IF NOT EXISTS user_primarykey(
	-- user_no INT PRIMARY KEY, -- 이 컬럼이 이 테이블의 대표 식별자 | 컬럼 레벨 설정
    user_no INT,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    PRIMARY KEY (user_no) -- 테이블 레벨 설정 가능
)ENGINE=INNODB;

-- 1. NULL 값 시도 (NOT NULL 위반)
INSERT INTO user_primarykey VALUES(NULL, 'user01', 'pass01', '남'); -- error1048

-- 2. 중복 값 시도 (UNIQUE 위반)
INSERT INTO user_primarykey VALUES(1, 'user01', 'pass01', '남');
INSERT INTO user_primarykey VALUES(1, 'user02', 'pass02', '여'); -- error1062


# FOREIGN KEY
-- 참조된 다른 테이블에서 제공하는 값만 사용할 수 있다.
-- 두 테이블을 연결하고 관계를 맺어준다.
-- 제공되는 값 외에는 NULL을 사용할 수 있음.

-- 테이블 1 참조되는 테이블
CREATE TABLE IF NOT EXISTS user_grade (
	grade_code INT PRIMARY KEY,
    grade_name VARCHAR(255) NOT NULL
) ENGINE=INNODB;

INSERT INTO user_grade VALUES (10, '일반회원'), (20, '우수회원'), (30, '특별회원');

SELECT * FROM user_grade;

-- 테이블 2 - 참조하는 테이블
CREATE TABLE IF NOT EXISTS user_foreignkey1 (
	user_no INT PRIMARY KEY,
    grade_code INT,
    -- 이 테이블의 grade_code 는 user_grade 테이블의 grade_code를 참조한다
    FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
)ENGINE=INNODB;

-- 참조 컬럼에 있는 값 적용
INSERT INTO user_foreignkey1 VALUES (1, 10); -- 10은 user_grade에 있는값이기에 잘 삽입됨
-- 참조 컬럼에 없는 값을 적용 -> 에러 발생
INSERT INTO user_foreignkey1 VALUES (2, 50); -- 50은 user_grade에 없는값이기에 삽입불가


# ON UPDATE / ON DELETE 옵션
-- SET NULL : 부모(user_grade)가 바뀌거나 사라지면, 해당 값을 NULL로 바꾼다.
-- CASCADE : 부모가 바뀌면 자식도 따라 바뀌고, 부모가 사라지면 자식도 함께 사라진다.
CREATE TABLE IF NOT EXISTS user_foreignkey2 (
	user_no INT PRIMARY KEY,
    grade_code INT,
    -- 이 테이블의 grade_code 는 user_grade 테이블의 grade_code를 참조한다
    FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
    ON UPDATE SET NULL -- 부모가 UPDATE 되면 NULL로 바꾼다
    ON DELETE SET NULL -- 부모가 DELETE 되면 NULL로 바꾼다
)ENGINE=INNODB;

-- DATA 입력
INSERT INTO user_foreignkey2 VALUES(1,10), (2, 20), (3,30);
SELECT * FROM user_foreignkey2;

-- 일단 ON UPDATE, ON DELETE가 적용되지 않은 foreignkey1을 DROP
DROP TABLE IF EXISTS user_foreignkey1;

-- 부모 테이블의 grade_code 수정
UPDATE user_grade
SET grade_code = 40
WHERE grade_code = 10;
SELECT * FROM user_foreignkey2; -- 부모의 10을 40으로 바꾸면 참조하고 있는 값이 NULL로 바뀐다.

# CHECK
-- 들어올 수 있는 값의 범위나 조건을 직접 지정
CREATE TABLE IF NOT EXISTS user_check(
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3) CHECK (gender IN ('남','여')), -- '남','여'만 받을 수 있게
    age INT CHECK (age >= 19) -- 19 이상의 정수만 들어오게
)ENGINE=INNODB;

INSERT INTO user_check VALUES(null, '홍길동', '남', 25);

SELECT * FROM user_check;

-- CHECK 제약조건 위반
INSERT INTO user_check VALUES(null, '유관순', '여성', 25); -- ERROR
INSERT INTO user_check VALUES(null, '판다', '여', 5); -- ERROR


# DEFAULT
-- INSERT시 특정 칼럼에 값을 주지 않으면, 자동으로 채워질 기본값을 지정한다.
CREATE TABLE IF NOT EXISTS tbl_country (
	country_code INT AUTO_INCREMENT PRIMARY KEY,
    conutry_name VARCHAR(255) DEFAULT '한국', -- conutry_name 오타있음
    add_day DATE DEFAULT (CURRENT_DATE),
    add_time DATETIME DEFAULT (CURRENT_TIME)
)ENGINE=INNODB;

INSERT INTO tbl_country VALUES(null, default, default, default);
-- INSERT시 생략한 컬럼도 자동으로 default 값으로 설정 된다
INSERT INTO tbl_country (country_code, conutry_name) VALUES (null, '미국');

SELECT * FROM tbl_country;
