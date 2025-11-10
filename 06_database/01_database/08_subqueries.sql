# SUBQUERISE(서브쿼리)

-- 민트 미역국이 포함된 카테고리에 속한 메뉴들의 이름을 찾고자 한다면~
-- 1단계 (서브 쿼리)
-- 민트미역국의 카테고리 코드를 알아낸다.
SELECT
	category_code
FROM
	tbl_menu
WHERE
	menu_name = '민트미역국';	-- 4
-- 2단계 (메인 쿼리)
-- '민트미역국'과 같은 카테고리의 메뉴 조회
SELECT
	menu_name,
    category_code
FROM
	tbl_menu
WHERE
	category_code = 4;

-- 1, 2 단계를 조합(서브 쿼리를 이용)
SELECT
	menu_name,
    category_code
FROM
	tbl_menu
WHERE
	category_code = (SELECT
						category_code
					FROM
						tbl_menu
					WHERE
						menu_name = '민트미역국');

-- FROM 절에 서브쿼리 사용
-- 즉석에서 만들어 쓰는 임시 테이블처럼 동작 -> 파생 테이블 이라고도 부른다.
-- "가장 많은 메뉴가 포함된 카테고리는 메뉴를 총 몇 개 가지고 있나요?"
-- 1단계 (서브쿼리): 각 카테고리별로 메뉴가 몇 개씩 있는지?(GROUP BY 사용)
SELECT
	COUNT(*) AS 'count'
FROM
	tbl_menu
GROUP BY
	category_code;
    
-- 2단계 (메인쿼리): 가장 많은 메뉴가 포함된 카테고리의 메뉴 수
SELECT
	MAX(count) AS '최대 메뉴 수'
FROM
	(SELECT
		COUNT(*) AS 'count'
	FROM
		tbl_menu
	GROUP BY
		category_code) AS count_table; -- 파생 테이블은 반드시 별칭이 있어야 한다

-- 상관 서브쿼리(심화)
-- 카테고리별 평균 가격보다 높은 가격의 메뉴 조회
-- 1. 카테고리별 평균 가격(서브쿼리)
SELECT
	AVG(menu_price)
FROM
	tbl_menu
WHERE
	category_code = 4;
-- 2. 평균 가격보다 높은 가격의 메뉴 조회(메인쿼리)
SELECT
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu a
WHERE menu_price > (SELECT
						AVG(menu_price)
					FROM
						tbl_menu
					WHERE
						category_code = a.category_code);
