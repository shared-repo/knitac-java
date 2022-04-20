-- 집계 함수 : AVG, SUM, COUNT, MIN, MAX
select sal from emp;
select 
    sum(sal) 총급여
    , count(sal) 직원수
    , round( avg(sal), 2 ) 평균급여
    , min(sal) 최소급여
    , max(sal) 최대급여
from emp;

-- 부서별 총급여, 직원수, 평균급여, 최소급여, 최대급여
select 
    deptno 부서
    -- , ename 이름 -- group by 에 명시된 컬럼만 조회 가능
    , sum(sal) 총급여
    , count(sal) 직원수
    , round( avg(sal), 2 ) 평균급여
    , min(sal) 최소급여
    , max(sal) 최대급여
from emp
group by deptno
order by deptno;

-- 평균급여가 2000 이상인 부서 조회
select 
    deptno 부서
    -- , ename 이름 -- group by 에 명시된 컬럼만 조회 가능
    , sum(sal) 총급여
    , count(sal) 직원수
    , round( avg(sal), 2 ) 평균급여
    , min(sal) 최소급여
    , max(sal) 최대급여
from emp
-- where avg(sal) > 2000
group by deptno
having avg(sal) > 2000; -- group by 이후에 실행하는 조건검사

-- 직원정보 조회
select * from emp; -- 부서 번호는 부서 이름 정보는 없습니다.
select * from dept; -- 부서 이름 정보는 dept 테이블에 있습니다.

-- 1. 직원정보 조회 (부서 이름도 함께 조회) - join
-- 1-1.
select *
from emp, dept; -- 두 테이블의 데이터로 조합 가능한 모든 조합을 조회

-- 1-2. 부서번호가 일치하는 데이터만 조회
select *
from emp, dept
where emp.deptno = dept.deptno;

-- 1-3. 컬럼명 명시 (테이블 이름 같이 표시)
-- select empno, ename, job, dept.deptno, dname
select emp.empno, emp.ename, emp.job, dept.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno;

-- 1-4. 테이블 이름 별칭 사용
select e.empno, e.ename, e.job, d.deptno, d.dname
from emp e, dept d -- sql문에서 e는 emp를 d는 dept를 의미하는 설정
where e.deptno = d.deptno
order by e.deptno;

-- 1-5. 표준 Join 구문
select e.empno, e.ename, e.job, d.deptno, d.dname
from emp e
inner join dept d
on e.deptno = d.deptno -- join에 대한 조건 (where)
order by e.deptno;

-- 2-1. 부서코드, 부서명, 직원이름 조회
select d.deptno, d.dname, e.ename
from dept d
inner join emp e
on e.deptno = d.deptno -- join에 대한 조건 (where)
order by d.deptno, e.ename;

-- 2-1의 문제 상황 확인
select * from dept; -- 40번 부서에 대한 정보가 조회되지 않은 것을 확인

-- 2-2. 부서코드, 부서명, 직원이름 조회
select d.deptno, d.dname, e.ename
from dept d
left outer join emp e -- outer join : 지정된 테이블의 데이터는 모두 조회
on e.deptno = d.deptno -- join에 대한 조건 (where)
order by d.deptno, e.ename;

-- 오라클의 outer join
select d.deptno, d.dname, e.ename
from dept d, emp e
where d.deptno = e.deptno(+)
order by d.deptno, e.ename;

-- 3-1. empno, empname, job, mgr, mgr의 ename 조회
select * from emp;

select e1.empno, e1.ename, e1.job, e1.mgr, e2.ename mgrname
from emp e1, emp e2
where e1.mgr = e2.empno(+);

select e1.empno, e1.ename, e1.job, e1.mgr, e2.ename mgrname
from emp e1
left outer join emp e2
on e1.mgr = e2.empno;




