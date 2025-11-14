/* DDL(Data Definition Language) */
-- 데이터 정의 언어 (CREATE, ALTER, DROP)

# CREATE
-- 테이블 생성을 위한 구문
/*
CREATE TABLE 테이블명(
	컬럼명 데이터타입(길이) [제약조건],
	컬럼명 데이터타입(길이) [제약조건],
    ...
*/
-- IF NOT EXISTS : 존재하지 않을때만 생성하기 위한 구문
CREATE TABLE IF NOT EXISTS tb1( -- tb1은 테이블명
	pk INT PRIMARY KEY, -- 컬럼명 데이터타입(길이) [제약조건]
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N')) -- 'Y', 'N'만 들어갈 수 있게 하는 제약조건
)ENGINE=INNODB;

## DESCRIBE	: 테이블의 구조를 확인 가능
DESCRIBE tb1;

-- 값 넣어보기
INSERT INTO tb1 VALUES(1, 10, 'Y');

SELECT * FROM tb1;

-- ## AUTO_INCREMENT
-- INSERT시 PRIMARY KEY에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있다.

-- tb2 생성
CREATE TABLE IF NOT EXISTS tb2(
	pk INT AUTO_INCREMENT PRIMARY KEY, -- PRIMARY KEY 앞에 AUTO_INCREMENT
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

DESCRIBE tb2;

-- pk값에 NULL을 주면 자동으로 번호가 채워진다.
INSERT INTO tb2 VALUES(NULL, 10, 'Y');
INSERT INTO tb2 VALUES(NULL, 20, 'N');

SELECT * FROM tb2;

# ALTER
-- 테이블에 열을 추가/변경/수정/삭제하는 모든 것은 ALTER 명령어를 사용하여 적용한다.

## ADD(추가)
-- tb2 테이블에 'col2' 정수형 컬럼 추가
ALTER TABLE tb2
ADD	col2 INT NOT NULL;	-- ADD 컬럼명 데이터타입(길이) [제약조건]

DESCRIBE tb2;

## DROP(삭제)
ALTER TABLE tb2
DROP COLUMN col2;

## CHANGE(변경)
-- 'fk' 컬럼 이름과 데이터 형식, 제약조건 바꾸기
ALTER TABLE tb2
CHANGE COLUMN fk change_fk INT NOT NULL;

## MODIFY
-- 컬럼의 정의 변경
-- PRIMARY KEY 제거 시도
ALTER TABLE tb2
DROP PRIMARY KEY; -- 에러 발생(auto increment 걸려있기 때문)
-- MODIFY
ALTER TABLE tb2
MODIFY pk INT;	-- 속성을 INT로만 바꿈. PRIMARY KEY 속성 제거됨.

DESCRIBE tb2;	-- PRIMARY KEY 속성 사라진 것 확인 가능.

-- 이제 PRIMARY KEY 삭제 가능
ALTER TABLE tb2
DROP PRIMARY KEY;

-- 다시 제약조건 추가
ALTER TABLE tb2 ADD PRIMARY KEY(pk);

DESCRIBE tb2;

# 테이블 조작

## DROP
-- 테이블의 구조와 데이터를 영구적으로 삭제(되돌릴 수 없다)
-- tb3 생성
CREATE TABLE IF NOT EXISTS tb3(
	pk INT AUTO_INCREMENT PRIMARY KEY, -- PRIMARY KEY 앞에 AUTO_INCREMENT
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

-- tb3 삭제. IF EXISTS를 붙이면 테이블이 없어도 에러가 나지 않음
DROP TABLE IF EXISTS tb3; -- 콤마를 이용하여 여러 테이블도 삭제 가능(DROP TABLE table1, table2;)

## TRUNCATE
-- 테이블 내용물만 비우고 초기화하기(구조는 남겨두고, 데이터만 깨끗하게 비우고 싶을 떄 사용하면 효율적)
-- tb4 생성
CREATE TABLE IF NOT EXISTS tb4(
	pk INT AUTO_INCREMENT PRIMARY KEY, -- PRIMARY KEY 앞에 AUTO_INCREMENT
	fk INT,
	col1 VARCHAR(255),
	CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;
-- 데이터 넣기
INSERT INTO tb4 VALUES(NULL, 10, 'Y'), (NULL, 20, 'N');

SELECT * FROM tb4;

-- 테이블 초기화
TRUNCATE tb4;

-- 다시 데이터를 넣으면 pk(PRIMARY_KEY)가 1부터 시작한다.
INSERT INTO tb4 VALUES(NULL, 10, 'Y'), (NULL, 20, 'N');



