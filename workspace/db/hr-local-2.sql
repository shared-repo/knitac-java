-- 테이블 목록 조회
select table_name from user_tables;

-- 테이블 정보 보기
desc employees;
desc departments;
desc jobs;

-- 1. employees 테이블의 모든 컬럼 조회
select * 
from employees;

-- 2. employees 테이블에서 employee_id, first_name, last_name, 
--                        hire_date, salary 컬럼 조회
select employee_id, first_name, last_name, hire_date, salary
from employees;
-- 오라클에서 문자열 결합(+)는 || 연산자 사용
-- 오라클에서 문자열은 작은따옴표를 사용해서 표시
select employee_id, first_name || ' ' || last_name name, hire_date, salary
from employees;

-- 3. employees 테이블에서 모든 컬럼을 hire_date 순으로 정렬해서 조회
select *
from employees
order by hire_date desc;
-- 3. employees 테이블에서 모든 컬럼을 salary 순으로 정렬해서 조회
select *
from employees
order by salary desc;
-- 4. employees 테이블에서 employee_id, first_name, last_name, 
--                        annsal (salary * 12) 조회
select employee_id, first_name, last_name, salary * 12 as annsal
from employees;
