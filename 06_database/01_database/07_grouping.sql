# GROUP BY
-- 지정된 컬럼의 값이 같은 데이터들을 하나의 그룹으로 묶는 것.
SELECT
	category_code
FROM
	tbl_menu
GROUP BY
	category_code;
    
-- COUNT() : 각 그룹에 속한 행의 개수를 센다.
SELECT
	category_code,
    COUNT(*) AS '메뉴 개수'
FROM
	tbl_menu
GROUP BY
	category_code;

-- SELECT에는 GROUP BY절에서 사용한 컬럼과 집계 합수만 올 수 있다.
SELECT
	category_code,
   -- menu_code, -- 주의사항 : GROUP BY에 사용한 컬럼과 집계 함수만 올 수 있다.
    SUM(menu_price) AS '가격 총합',
    AVG(menu_price) AS '가격 평균'
FROM
	tbl_menu
GROUP BY
	category_code;

-- HAVING : 그룹에 대한 조건 필터링(WHERE는 그룹화 전!!)
SELECT
	category_code,
    COUNT(*) AS '메뉴 개수'
FROM
	tbl_menu
GROUP BY
	category_code
HAVING
	COUNT(*) >= 3;	-- 그룹화된 결과(메뉴 개수)가 3개 이상인 그룹만 필터링
    
-- 작성 순서 : FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY

-- ROLLUP(그룹별 집계 결과와 함께 그 그룹들의 소계와 총계를 보여줌)
SELECT
	category_code,
    SUM(menu_price)
FROM
	tbl_menu
GROUP BY
	category_code
WITH ROLLUP;

-- 가격대별, 그 안에서 카테고리별로 그룹화 하고 ROLLUP 적용
SELECT
	menu_price,
    category_code,
    SUM(menu_price)
FROM
	tbl_menu
GROUP BY
	menu_price,
    category_code
WITH ROLLUP;



