# 문제 3
-- Q1.
-- 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
SELECT MAX(MAX_SAL)
FROM (
	SELECT
		SUM(emp.SALARY) AS MAX_SAL
	FROM employee AS emp
    JOIN department AS dpt ON emp.DEPT_CODE = dpt.DEPT_ID
	GROUP BY dpt.DEPT_TITLE) AS SAL_SUM;
-- Q2.
-- 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
-- 참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
SELECT
	emp1.EMP_ID,
    emp1.EMP_NAME,
    emp1.DEPT_CODE,
    emp1.SALARY
FROM employee emp1 JOIN department dpt1 ON emp1.DEPT_CODE = dpt1.DEPT_ID
WHERE dpt1.DEPT_TITLE IN (SELECT	-- 왜 '='이 아닌 'IN'을 사용했는가? =은 단일값, IN은 값들의 집합/목록임.
							DEPT_TITLE	-- '%영업%'이 포함되는 부서는 여러개 있음. 따라서 IN을 사용.
						FROM
							department
						WHERE
							DEPT_TITLE LIKE '%영업%')
ORDER BY DEPT_CODE;

-- Q3.
-- 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요
SELECT
	EMP_ID,
    EMP_NAME,
    dpt.DEPT_TITLE,
    SALARY
FROM employee emp JOIN department dpt ON emp.DEPT_CODE = dpt.DEPT_ID
WHERE DEPT_CODE IN (SELECT DEPT_ID
					FROM department
                    WHERE DEPT_TITLE LIKE '%영업%')
ORDER BY dpt.DEPT_TITLE;

-- Q4.
-- 1. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
SELECT
	DEPT_ID,
    DEPT_TITLE,
    loc.LOCAL_NAME,
    nat.NATIONAL_NAME
FROM department AS dpt JOIN location AS loc ON dpt.LOCATION_ID = loc.LOCAL_CODE
JOIN nation nat ON loc.NATIONAL_CODE = nat.NATIONAL_CODE;
-- 2. 위 1에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
SELECT
	EMP_ID,
    EMP_NAME,
    SALARY,
    subquery.DEPT_TITLE,
    subquery.NATIONAL_NAME
FROM employee AS emp1
JOIN (
	SELECT
		DEPT_ID,
		DEPT_TITLE,
		loc.LOCAL_NAME,
		nat.NATIONAL_NAME
	FROM department AS dpt JOIN location AS loc ON dpt.LOCATION_ID = loc.LOCAL_CODE
	JOIN nation nat ON loc.NATIONAL_CODE = nat.NATIONAL_CODE)
AS subquery ON emp1.DEPT_CODE = subquery.DEPT_ID;

-- Q.4
-- 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- Q4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
SELECT
	emp2.EMP_ID,
    emp2.EMP_NAME,
    emp2.SALARY,
    subsubquery.DEPT_TITLE,
    subsubquery.NATIONAL_NAME,
    (salg.MIN_SAL + emp2.SALARY) AS '위로금'
FROM employee AS emp2
JOIN (SELECT
		emp1.EMP_ID,
		emp1.EMP_NAME,
		emp1.SALARY,
		subquery.DEPT_TITLE,
		subquery.NATIONAL_NAME
	FROM employee AS emp1
		JOIN (SELECT
					DEPT_ID,
					DEPT_TITLE,
					loc.LOCAL_NAME,
					nat.NATIONAL_NAME
				FROM department AS dpt JOIN location AS loc ON dpt.LOCATION_ID = loc.LOCAL_CODE
				JOIN nation nat ON loc.NATIONAL_CODE = nat.NATIONAL_CODE)
		AS subquery ON emp1.DEPT_CODE = subquery.DEPT_ID) AS subsubquery ON emp2.EMP_ID = subsubquery.EMP_ID
	JOIN sal_grade AS salg ON emp2.SAL_LEVEL = salg.SAL_LEVEL
WHERE subsubquery.NATIONAL_NAME IN('러시아')
ORDER BY 위로금 DESC;


