# SET OPERATORS(집합 연산자)

-- UNION : 두 결과를 합치기(중복은 제거)
-- 카테고리 코드가 10번이 메뉴들
-- 가격이 9,000원 미만인 메뉴들
SELECT
	menu_name,
    menu_price,
    category_code
FROM
	tbl_menu
WHERE
	category_code = 10	-- 카테고리 코드가 10번이 메뉴들
UNION		-- 둘을 합친 것 중, 10번 미만이고, 9000원 미만인 메뉴들은 중복되니 하나만 출력된다.
SELECT
	menu_name,
    menu_price,
    category_code
FROM
	tbl_menu
WHERE
	menu_price < 9000;	-- 가격이 9,000원 미만인 메뉴들

-- UNION ALL : 두 결과를 그냥 다 합치기(중복 포함)
SELECT
	menu_name,
    menu_price,
    category_code
FROM
	tbl_menu
WHERE
	category_code = 10	-- 카테고리 코드가 10번이 메뉴들
UNION ALL		-- 둘 중 중복되는 결과(10번 미만,9000원 미만 결과)도 그대로 출력된다.
SELECT
	menu_name,
    menu_price,
    category_code
FROM
	tbl_menu
WHERE
	menu_price < 9000;	-- 가격이 9,000원 미만인 메뉴들


/* INTERSECT(교집합) */
-- MySQL은 INTERSECT를 제공하지 않는다. 하지만 INNER JOIN 또는 IN을 활용해서 구현하는 것은 가능하다.

-- 1) INNER JOIN 활용
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
INNER JOIN (SELECT 
		menu_code,
		menu_name,
		menu_price,
		category_code,
		orderable_status
	FROM
		tbl_menu 
	WHERE
		menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
    a.category_code = 10;
    
-- 2) IN 연산자 활용
SELECT 
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
    tbl_menu
WHERE
    category_code = 10 AND
    menu_code IN (SELECT 
					menu_code
				FROM
					tbl_menu 
				WHERE
					menu_price < 9000);

/* MINUS */
-- MySQL은 MINUS를 제공하지 않는다. 하지만 LEFT JOIN을 활용해서 구현하는 것은 가능하다.
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
LEFT JOIN (SELECT 
				menu_code,
				menu_name,
				menu_price,
				category_code,
				orderable_status
			FROM
				tbl_menu 
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
    a.category_code = 10 AND
    b.menu_code IS NULL;