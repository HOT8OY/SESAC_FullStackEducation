# DISTINCT(중복 제거)
-- 중복된 값을 제거하고 유니크한(고유한) 값들의 목록만 보고싶을때 사용
-- 특정 컬럼에 어떤 값들이 '종류별로'있는지 확인할 때 유용
SELECT
	DISTINCT category_code
FROM
	tbl_menu
ORDER BY
	category_code;
    
-- NULL값을 포함한 열의 DISTINCT
-- DISTINCT는 NULL값도 고유한 값으로 인지하여 중복을 제거해줌.
SELECT
	DISTINCT ref_category_code
FROM
	tbl_category;

-- 열이 여러 개인 DISTINCT
-- 지정된 모든 열의 조합이 똑같을 때만 중복으로 간주하여 제거
-- 
SELECT DISTINCT
	category_code,
    orderable_status
FROM
	tbl_menu;