# 문제 4
-- Q1.
-- 다음 논리ERD와 물리ERD를 참고하여,
-- 아래 조건을 만족하는 테이블을 생성하는 DDL 구문을 작성하세요.
-- **- 조건 -**
-- 1) TEAM_INFO 테이블의 PRIMARY KEY와 MEMBER_INFO 테이블의 PRIMARY KEY는
-- AUTO_INCREMENT 설정을 해 값이 자동 채번되도록 한다.
-- 2) TEAM_INFO 테이블의 USE_YN 컬럼의 기본값은 ‘Y’이며,
-- ‘Y’또는 ‘N’의 데이터만 삽입할 수 있다.
-- 3) MEMBER_INFO 테이블의 ACTIVE_STATUS 컬럼의 기본값은 ‘Y’이며,
-- 활동 중을 의미하는 ‘Y’, 휴식 중을 의미하는 ‘N’, 잠정적 활동 상태인 ‘H’만 삽입할 수 있다.

-- TEAM_INFO 생성
CREATE TABLE IF NOT EXISTS TEAM_INFO(
	TEAM_CODE INT AUTO_INCREMENT PRIMARY KEY,
    TEAM_NAME VARCHAR(100) NOT NULL,
    TEAM_DETAIL VARCHAR(500),
    USE_YN CHAR(2) CHECK(USE_YN IN('Y','N')) DEFAULT ('Y') NOT NULL
)ENGINE=INNODB;

SELECT * FROM TEAM_INFO;

-- MEMBER_INFO 생성
CREATE TABLE IF NOT EXISTS MEMBER_INFO(
	MEMBER_CODE INT AUTO_INCREMENT PRIMARY KEY,
    MEMBER_NAME VARCHAR(70) NOT NULL,
    BIRTH_DATE DATE,
    DIVISION_CODE CHAR(2),
    DETAIL_INFO VARCHAR(500),
    CONTACT VARCHAR(50) NOT NULL,
    TEAM_CODE INT NOT NULL,
    FOREIGN KEY(TEAM_CODE) REFERENCES TEAM_INFO(TEAM_CODE),
    ACTIVE_STATUS CHAR(2) CHECK(ACTIVE_STATUS IN('Y', 'N', 'H')) DEFAULT('Y')
)ENGINE=INNODB;

SELECT * FROM MEMBER_INFO;


-- Q2.
-- Q1에서 생성한 TEAM_INFO 테이블과 MEMBER_INFO 테이블에 아래와 같이
-- 데이터를 INSERT하는 쿼리를 작성하세요.
-- 단, 삽입 대상 컬럼명은 반드시 명시해야 합니다.

-- TEAM_INFO INSERT 구문
INSERT INTO TEAM_INFO VALUES
	(null, '음악감상부', '클래식 및 재즈 음악을 감상하는 사람들의 모임', 'Y'),
    (null, '맛집탐방부', '맛집을 찾아다니는 사람들의 모임', 'N'),
    (null, '태진아', null, 'Y');

-- MEMBER_INFO INSERT 구문
INSERT INTO MEMBER_INFO VALUES
	(null, '송가인', '1990-01-30', 1, '안녕하세요 송가인입니다~','010-9494-9494',1,'H'),
	(null, '임영웅', '1992-05-03', null, '국민아들 임영움입니다~', 'hero@trot.com', 1, 'Y'),
    (null, '태진아', null, null, null, '(1급 기밀)', 3, 'Y');

-- Q3.
-- 단합을 위한 사내 체육대회를 위하여 팀을 꾸리는 중입니다.
-- 기술지원부의 대리, 인사관리부의 사원, 영업부(팀명에 ‘영업’이 포함되면 영업부로 봄)의 부장을
-- 한 팀으로 묶으려고 합니다. 이때, 이 팀의 팀원 수를 출력하세요.
-- 단, UNION과 SUBQUERY를 활용하여 출력하세요.
-- 1) 기술지원부의 대리
-- (employee(EMP_NAME, DEPT_CODE)
-- (department(DEPT_ID,DEPT_TITLE)
-- (job(JOB_CODE, JOB_NAME)
-- 2) 인사관리부의 사원
-- 3) 영업부의 부장
-- 4) 이 팀의 팀원 수(COUNT())
-- 1~3을 UNION으로 묶어서 SUBQUERY로 팀원수에 넣음

SELECT
	COUNT(EMP_NAME) AS '대사부팀의 팀원 수'
FROM
	-- 1) 기술지원부의 대리
	(SELECT
		EMP_NAME
	FROM
		employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		dpt.DEPT_TITLE LIKE '%기술지원부%'
		AND jb.JOB_NAME LIKE '%대리%'
	UNION ALL
	-- 2) 인사관리부의 사원
	SELECT
		EMP_NAME
	FROM
		employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		dpt.DEPT_TITLE LIKE '%인사관리부%'
		AND jb.JOB_NAME LIKE '%사원%'
	UNION ALL
	-- 3) 영업부의 부장
	SELECT
		EMP_NAME
	FROM
		employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		dpt.DEPT_TITLE LIKE '%영업%'
		AND jb.JOB_NAME LIKE '%부장%') AS DSB;
	
-- Q4.
-- 1. 부서가 영업부가 아니면서(부서명에 ‘영업’이 포함되지 않음) 직급명이 ‘대리’ 혹은 ‘차장’인 직원의 목록과
--  급여가 200만원 이상 300만원 이하인 직원의 목록을 합쳐 출력합니다.
-- (이때, 직원의 사원번호, 직원명, 전화번호, 부서명, 직급명, 급여를 출력하도록 하세요.)
SELECT
	EMP_ID,
    EMP_NAME,
    PHONE,
    dpt.DEPT_TITLE,
    jb.JOB_NAME,
    SALARY
FROM employee emp
	JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
    JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
WHERE
	dpt.DEPT_TITLE NOT LIKE ("%영업%")
    AND jb.JOB_NAME IN ("대리", "차장")
UNION ALL
SELECT
	EMP_ID,
    EMP_NAME,
    PHONE,
    dpt.DEPT_TITLE,
    jb.JOB_NAME,
    SALARY
FROM employee emp
	JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
    JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
WHERE
    SALARY BETWEEN 2000000 and 3000000;
    
-- 2. 1에서 출력한 목록에서 직원의 이름과 급여를 기준으로 묶어 해당 직원이 몇 번 나오는지 카운트합니다.
--  (이때, 추출한 목록에는 직원명, 급여, 나온 횟수가 출력되도록 하세요.)
SELECT
	EMP_NAME,
    SALARY,
    COUNT(*) as 나온횟수
FROM(
	SELECT
		EMP_ID,
		EMP_NAME,
		PHONE,
		dpt.DEPT_TITLE,
		jb.JOB_NAME,
		SALARY
	FROM employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		dpt.DEPT_TITLE NOT LIKE ("%영업%")
		AND jb.JOB_NAME IN ("대리", "차장")
	UNION ALL
	SELECT
		EMP_ID,
		EMP_NAME,
		PHONE,
		dpt.DEPT_TITLE,
		jb.JOB_NAME,
		SALARY
	FROM employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		SALARY BETWEEN 2000000 and 3000000) as subquery
GROUP BY EMP_NAME, SALARY;

-- 3. 2에서 출력한 목록을 목록에 나온 횟수가 많은 순으로 정렬한 뒤에 급여가 많은 순으로 정렬하여
--  최상위 3명만 출력되도록 합니다.

SELECT
	EMP_NAME,
    SALARY,
    COUNT(*) as 나온횟수
FROM(
	SELECT
		EMP_ID,
		EMP_NAME,
		PHONE,
		dpt.DEPT_TITLE,
		jb.JOB_NAME,
		SALARY
	FROM employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		dpt.DEPT_TITLE NOT LIKE ("%영업%")
		AND jb.JOB_NAME IN ("대리", "차장")
	UNION ALL
	SELECT
		EMP_ID,
		EMP_NAME,
		PHONE,
		dpt.DEPT_TITLE,
		jb.JOB_NAME,
		SALARY
	FROM employee emp
		JOIN department dpt ON (emp.DEPT_CODE = dpt.DEPT_ID)
		JOIN job jb ON (emp.JOB_CODE = jb.JOB_CODE)
	WHERE
		SALARY BETWEEN 2000000 and 3000000) as subquery
GROUP BY EMP_NAME, SALARY
ORDER BY
	COUNT(*) DESC,
    SALARY DESC
LIMIT 3;
    


