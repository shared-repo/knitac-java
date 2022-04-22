-- 테스트용 테이블 만들기

create table dept_temp
as select * from dept;

select table_name from user_tables;

-- 신규 데이터 삽입
select * from dept_temp;

insert into dept_temp (deptno, dname, loc)
values (50, 'DEVELOPMENT', 'LA');

select * from dept_temp;

insert into dept_temp -- 모든 컬럼에 데이터를 저장하는 경우 컬럼 목록 생략 가능
values (60, 'MARKETING', 'SEATLE');

select * from dept_temp;

insert into dept_temp (deptno, dname)
values (70, 'MANUFACTURING');

select * from dept_temp;

-- rollback; -- 마지막 commit 또는 rollback 이후의 모든 작업을 취소하는 명령
commit; -- 마지막 commit 또는 rollback 이후의 모든 작업을 확정하는 명령

select * from dept_temp;

-- 신규 데이터 삽입 2
select * from emp;

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (9901, 'JOHN', 'CLERK', 7839, '2022-04-22', 790, NULL, 20);

select * from emp order by empno desc;

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (9902, 'JANE', 'ANALYST', 7839, SYSDATE, 1100, NULL, 20);

select * from emp order by empno desc;

commit; -- 이전 작업 확정

-- 기존 데이터 수정

update emp
set sal = 10000;

select * from emp;

rollback;

-- 데이터 수정 
select * from dept_temp;
update dept_temp
set loc = 'ULSAN'
where deptno = 70;

select * from dept_temp;

-- 데이터 수정
update dept_temp
set dname = 'CRM', loc = 'SEOUL'
where deptno = 60;

select * from dept_temp;

commit; -- 작업 확정





