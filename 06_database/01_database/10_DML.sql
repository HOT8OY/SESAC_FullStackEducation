-- USE menudb;
/* DML(Date Manipulation Language) */

-- INSERT, UPDATE, DELETE, SELECT(DQL)

## INSERT
-- 새로운 행을 추가하는 구문이다.(테이블의 행의 수가 증가한다)

-- 테이블의 컬럼 순서에 맞춰 모든 값을 순서대로 제공
INSERT INTO tbl_menu VALUES(null, '바나나해장국', 8500, 4, 'Y');

-- INSERT 하고싶은 데이터 컬럼을 지정해서 INSERT 가능하다.
-- 테이블 이름 뒤에 넣을 컬럼들을 명시(VALUES(넣을 값))한다.
-- 테이블의 순서와 관계 없이 내가 명시한 순서에 맞춰야 한다.
-- 테이블 순서 : A, B, C, D
-- INSERT INTO tbl_menu(D, A, C, B)
-- VALUES (D, A, C, B)
INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
VALUES ('초콜릿죽', 6500, 7, 'Y');

-- 한번에 여러 행 추가하기
INSERT INTO
	tbl_menu
VALUES
	(NULL, '참치맛아이스크림', 1700, 12, 'Y'),
    (NULL, '멸치맛아이스크림', 1500, 11, 'Y'),
    (NULL, '소시지맛커피', 2500, 8, 'Y');
    
SELECT * FROM tbl_menu;

# UPDATE
-- 테이블에 이미 존재하는 행의 컬럼의 값을 수정하는 구문이다.

-- 1단계: 내가 바꾸려는 대상이 맞는지 SELECT로 확인
SELECT
	menu_code,
    category_code
FROM
	tbl_menu
WHERE
	menu_name = '바나나해장국';
    
-- 2단계: 확인된 대상을 WHERE 절에 넣고 UPDATE 실행!
UPDATE tbl_menu
SET
	category_code = 7 -- 바꿀 내용
WHERE
	menu_code = 22;	-- 바꿀 대상

# DELETE
-- 테이블에서 특정 행을 삭제하는 구문이다.

-- 1단계: 내가 삭제할 대상을 확인!(중요)
SELECT * FROM tbl_menu WHERE menu_code = 22; -- '바나나해장국'

-- 2단계 : 확인된 대상을 WHERE 절에 넣고 DELETE 실행!!
DELETE
FROM
	tbl_menu
WHERE
	menu_code = 22;

# REPLACE
-- INSERT시 PRIMARY KEY 또는 UNIQUE KEY가 충돌이 발생할 수 있다면
-- REPLACE를 통해 중복 된 테이터를 덮어 쓸 수 있다.

-- 존재하는 PRIMARY KEY값에 중복 데이터를 넣으면 충돌 -> 에러 발생
INSERT INTO tbl_menu VALUES(17, '참기름소주', 5000, 10, 'Y');
-- REPLACE
-- 해당 키의 데이터가 있으면 -> 기존 데이터를 삭제(DELETE)하고, 새로운 데이터로 INSERT 한다.
REPLACE INTO tbl_menu VALUES(17, '참기름소주', 5000, 10, 'Y');



