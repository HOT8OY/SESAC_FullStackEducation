# ORDER BY
-- SELECT문의 가장 마지막에 위치하며, 결과 집합을 하나의 열로 정의

-- 오름차순 정렬
SELECT
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu
ORDER BY
	-- menu_price ASC;	-- ASC(Ascending) : 오름차순
    menu_price;	-- (생략을 해도 기본적으로 오름차순으로 적용)
    
-- 내림차순 정렬
SELECT
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu
ORDER BY
	menu_price DESC, -- DESC(Descending) : 내림차순 --
	menu_name ASC; -- 2차 기준 : 가격이 같다면, 이름 오름차순으로 --
    
-- 연산 결과로 정렬(보통 별칭을 사용한다)
SELECT
	menu_code,
    menu_price,
    menu_code * menu_price AS calculated_value -- AS 로 해당 컬럼의 별칭을 만듬
FROM
	tbl_menu
ORDER BY
	calculated_value DESC;	-- 내림차순은 생략 불가
    
-- FIELD(컬럼, 첫번째, 두번째, ...) : 컬럼 값이 목록의 몇 번째에 있는지 숫자로 알려준다.
SELECT FIELD('B', 'A', 'B', 'C');


-- FIELD를 이용한 사용자 지정 순서
-- tbl_menu에서 ordeable_status의 'N'을 1순위, 'Y'를 2순위로 정렬
SELECT
	menu_name,
    orderable_status
FROM
	tbl_menu
ORDER BY FIELD(orderable_status, 'N', 'Y'); -- 'N'이면 숫자 1을 반환, 'Y'면 숫자 2를 반환. 이 결과를 기준으로 ASC 정렬을 함.


-- null 값이 있는 컬럼에 대한 정렬.
-- MySQL은 NULL(값 없음)값을 가장 작은 값으로 취급한다.
SELECT
	category_code,
    category_name,
    ref_category_code
FROM
	tbl_category
ORDER BY
	ref_category_code IS NULL;	-- NULL 이면 true(1), 아니면 false(0) 반환
								-- NULL이 아닌 값 (0)들이 먼저 정렬된 후, NULL인 값 (1)들이 나중에 정렬됩니다.

-- 내림차순 시 NULL을 처음으로 (IS NULL DESC)
SELECT
	category_code,
    category_name,
    ref_category_code
FROM
	tbl_category
ORDER BY
	ref_category_code IS NULL DESC,
    ref_category_code DESC;