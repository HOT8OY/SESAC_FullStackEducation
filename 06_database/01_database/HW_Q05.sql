# 문제 5
### Q1.
-- 전화번호가 010으로 시작하는 직원의 직원명과 전화번호를 다음과 같이 출력하세요.
-- 출력한 결과집합 헤더의 명칭은 각각 ‘EMP_NAME’, ‘PHONE’이어야 함
-- 전화번호는 ‘010-0000-0000’ 형식으로 출력해야 함

SELECT
	EMP_NAME,
    CONCAT(SUBSTRING(PHONE,1,3), '-',SUBSTRING(PHONE,4,4),'-',SUBSTRING(PHONE,8,4)) AS PHONE
FROM
	employee
WHERE
	PHONE LIKE '010%';
    
### Q2.
-- 근속 일수가 20년 이상인 직원의 직원명, 입사일, 급여를 다음과 같이 출력하세요.
-- 단, 입사한 순서대로 출력하고 입사일이 같으면 급여가 높은 순서로 출력되도록 하세요.

SELECT
	EMP_NAME AS 직원명,
    CONCAT(YEAR(HIRE_DATE),'년 ',MONTH(HIRE_DATE),'월 ',DAY(HIRE_DATE),'일') AS 입사일,
    FORMAT(SALARY,0) AS 급여
FROM
	employee
ORDER BY HIRE_DATE, SALARY DESC;

### Q3.
-- 모든 직원의 직원명, 급여, 보너스, 급여에 보너스를 더한 금액을 다음과 같이 출력하세요.
-- 단, 급여에 보너스를 더한 금액이 높은 순으로 출력되도록 하세요.
SELECT
	EMP_NAME,
    FORMAT(SALARY,0) AS SALARY,
	CONCAT(TRUNCATE(BONUS * 100,0), '%') AS BONUS,
    TRUNCATE(SALARY * (COALESCE(BONUS,0) + 1),0) AS TOTAL_SALARY
FROM
	employee
ORDER BY TOTAL_SALARY DESC;

### Q4.
-- 직원의 직원명과 이메일을 다음과 같이 출력하세요.
-- 출력한 결과집합 헤더의 명칭은 각각 ‘EMP_NAME’, ‘EMAIL’이어야 함
-- 이메일의 도메인 주소인 greedy.com 은 모두 동일하므로, 해당 문자열이 맞춰질 수 있도록
-- 이메일의 앞에 공백을 두고 출력해야 함
SELECT
	EMP_NAME,
    CONCAT(LPAD(SUBSTRING_INDEX(EMAIL,'@',1),7,' '),'@',RPAD(SUBSTRING_INDEX(EMAIL,'@',-1),20,' ')) AS EMAIL
FROM
	employee;
    
-- - +@ (심화)
-- 이메일의 도메인 주소가 모두 다르다고 가정할 때, @의 위치를 한 줄로 맞추고 싶은 경우에는 어떻게 수정할 수 있을까?
SELECT
    EMP_NAME,
    CONCAT(LPAD(SUBSTRING_INDEX(EMAIL, '@', 1),(SELECT MAX(LENGTH(SUBSTRING_INDEX(EMAIL, '@', 1))) FROM employee),' '),'@',SUBSTRING_INDEX(EMAIL, '@', -1)) AS EMAIL
FROM
    employee;
        
### Q5.

-- 사내 행사 준비를 위해 직원 목록을 출력하려고 합니다. 직원 목록을 다음과 같이 출력하세요.

-- 단, 관리자의 이름순으로 정렬하여 출력되도록 하세요.
-- 직원명, 직급명, 주민등록번호, 부서가 있는 국가, 부서명, 해당 직원의 관리자 직원명을 출력해야 함
-- 출력한 결과집합 헤더의 명칭은 각각 ‘NAME_TAG’, ‘EMP_NO’, ‘BELONG’, ‘MANAGER_NAME’이어야 하며 출력 형식은 각각 아래와 같아야 함
    -- NAME_TAG : (직원명) (직급명)님
    -- EMP_NO : (생년월일6자리)-(뒷자리 한 자리를 제외하고는 *로 표시)
    -- BELONG : (부서의 국가)지사 (부서명) 소속

SELECT
	CONCAT(emp.EMP_NAME,' ',jb.JOB_NAME,'님') AS NAME_TAG,
    CONCAT(substring(emp.EMP_NO,1,8),'******') AS EMP_NO,
    CONCAT(nt.NATIONAL_NAME,'지사 ',dpt.DEPT_TITLE,' 소속') AS BELONG,
	emp1.EMP_NAME AS MANAGER_NAME
FROM
	employee emp
    JOIN department dpt ON emp.DEPT_CODE = dpt.DEPT_ID
    JOIN job jb ON emp.JOB_CODE = jb.JOB_CODE
    JOIN location lc ON dpt.LOCATION_ID = lc.LOCAL_CODE
    JOIN nation nt ON lc.NATIONAL_CODE = nt.NATIONAL_CODE
    LEFT JOIN employee emp1 ON emp.MANAGER_ID = emp1.EMP_ID
ORDER BY
	MANAGER_NAME;


