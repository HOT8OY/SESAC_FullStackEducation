# Transaction (트랜잭션)
-- ALL or Nothing
-- 모두 성공하거나, 모두 실패해야 하는 하나의 작업 묶음

-- MYSQL은 기본적으로 autocommit 모드가 켜져있다.
-- 조절하고 싶다면 설정을 바꿔줘야 한다.
-- autocommit 끄는 방법
SET autocommit = OFF; -- 키는건 ON

-- 지금부터 트랜잭션을 시작(수동 커밋 모드로 전환)
START TRANSACTION;
SELECT * FROM tbl_menu;
-- 임시 작업
INSERT INTO tbl_menu VALUES(null, '바나나해장국', 8500, 4, 'Y');
UPDATE tbl_menu SET menu_name = '수정 메뉴' WHERE menu_code = 5;
DELETE FROM tbl_menu WHERE menu_code = 7; -- 7번 삭제
-- START TRANSACTION 시점 이후에 수행했던 모든 작업을 '전부 취소'하고 트랜잭션 시작 전의 상태로 되돌림
ROLLBACK;	-- COMMIT 이후에는 ROLLBACK 불가
-- TRANSACTION의 작업이 올바르다고 판단되면 최종 저장을 명령한다.
COMMIT;
