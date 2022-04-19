-- 테이블 목록 조회
select table_name from user_tables;

-- 테이블 정보 보기
desc emp;
desc dept;
desc salgrade;
desc bonus;

-- EMP 테이블의 모든 컬럼의 데이터 조회 1
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp;

-- EMP 테이블의 모든 컬럼의 데이터 조회 2
select *
from emp;

-- emp 테이블에서 empno, ename, deptno 컬럼의 데이터 조회
select empno, ename, deptno
from emp;

-- emp 테이블의 조회를 통해 어떤 부서가 있는지 확인
select distinct deptno -- distinct : 중복 제거
from emp;

-- emp 테이블에서 ename, 연봉, comm 컬럼 조회 1
select ename, sal * 12 + comm, comm
from emp;

-- emp 테이블에서 ename, 연봉, comm 컬럼 조회 2
-- .... nvl(컬럼, 기본값) : 컬럼의 값이 null이면 기본값 사용
select ename, sal * 12 + nvl(comm, 0), comm
from emp;

-- emp 테이블에서 ename, 연봉, comm 컬럼 조회 3
-- ... as : 별칭을 붙일 때 사용 (생략가능)
select ename, sal * 12 + nvl(comm, 0) as annsal, comm
from emp;

-- emp 테이블에서 ename과 sal 컬럼을 sal 순으로 조회
select ename, sal
from emp
order by sal asc;

-- emp 테이블에서 ename과 sal 컬럼을 sal 순으로 조회 2
select ename, sal
from emp
order by sal desc;

-- emp 테이블에서 ename과 sal과 deptno 컬럼을 부서별 sal 순으로 조회
select ename, sal, deptno
from emp
order by deptno asc, sal desc;

-- emp 테이블에서 부서가 30인 직원 조회
select *
from emp
where deptno = 30;

-- emp 테이블에서 부서가 30이면서 job이 salesman인 직원 조회
select *
from emp
where deptno = 30 AND job = 'SALESMAN';

-- emp 테이블에서 급여가 3000 이상인 직원 조회
select *
from emp
-- where sal >= 3000; -- >, <, >=, <=, =, <> 
-- where sal = 3000;
where sal <> 3000;

-- emp 테이블에서 job이 'SALESMAN', 'MANAGER', 'CLERK' 인 직원 조회 1
select *
from emp
-- where job = 'SALESMAN' OR job = 'MANAGER' OR job = 'CLERK';
where job != 'SALESMAN' AND job != 'MANAGER' AND job != 'CLERK';

-- emp 테이블에서 job이 'SALESMAN', 'MANAGER', 'CLERK' 인 직원 조회
select *
from emp
-- where job IN ('SALESMAN', 'MANAGER', 'CLERK');
where job NOT IN ('SALESMAN', 'MANAGER', 'CLERK'); -- NOT -> !

-- emp 테이블에서 급여가 2000 ~ 3000인 직원 조회 1
select *
from emp
where sal >= 2000 AND sal <= 3000;

-- emp 테이블에서 급여가 2000 ~ 3000인 직원 조회 2
select *
from emp
where sal BETWEEN 2000 AND 3000;

-- emp 테이블에서 급여가 2000 보다 작거나 3000보다 큰 직원 조회
select *
from emp
where sal NOT BETWEEN 2000 AND 3000;

-- 이름이 S로 시작하는 직원 조회
select *
from emp
where ename like 'S%'; -- '%' : 0개 이상의 문자, _ : 1개의 문자

-- 이름에 'AM'이 포함되지 않은 직원 조회
select *
from emp
where ename not like '%AM%';

-- job이 SALESMAN이 아닌 직원 조회 ( COMM 컬럼 사용해서 조건 구성 )
select *
from emp
-- where comm = null; -- null은 연산자로 비교할 수 없는 값
-- where comm is null; -- null을 비교할 경우 is null 사용
where comm is not null;

-- 부서가 10 또는 20인 직원 조회
select *
from emp
where deptno in (10, 20);

select *
from emp
where deptno = 10
union -- 두 조회 결과를 병합
select *
from emp
where deptno = 20;

select *
from emp
minus -- 앞의 조회 결과에서 뒤의 조회 결과를 뺀 나머지 조회
select *
from emp
where deptno = 30;

-- deptno가 20인 직원
select *
from emp
where deptno in (20, 30)
intersect -- 두 조회결과에 공통인 결과만 조회
select *
from emp
where deptno in (10, 20);




