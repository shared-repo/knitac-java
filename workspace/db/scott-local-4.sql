-- 서브 쿼리 : SQL 내부에 다른 SQL이 있는 경우

-- 1. JONES 직원보다 급여가 많은 직원 조회
select sal
from emp
where ename = 'JONES'; -- JONES 직원의 급여가 2975임을 확인

select *
from emp
where sal > 2975; -- 위 조회의 결과를 조건으로 사용

select *
from emp
where sal > ( select sal
              from emp
              where ename = 'JONES' );
              
-- CLARK 직원보다 늦게 입사한 직원 조회
select *
from emp
where hiredate > ( select hiredate
                   from emp
                   where ename = 'CLARK' );
                   
-- "NEW YORK" 또는 "CHICAGO"에서 근무하는 직원 조회
select deptno
from dept 
where loc = 'NEW YORK' or loc = 'CHICAGO';

select *
from emp
-- where deptno = 10 or deptno = 30;
-- where deptno in (10, 30);
where deptno in ( select deptno
                  from dept 
                  where loc = 'NEW YORK' or loc = 'CHICAGO' );
                  
-- 직원 평균 급여보다 급여가 많은 직원 조회
select emp.*, round((select avg(sal) from emp), 2) salavg
from emp
where sal > ( select avg(sal)
              from emp );
              
-- Book, Orders, Customer 테이블 사용해서 SQL 작성
-- 1. 가장 비싼 도서의 이름을 보이시오
select  *
from book
where price = ( select max(price) from book );
-- 2. 도서를 구매한 적이 있는 고객의 이름을 검색하시오
select distinct custid from orders; -- 주문한 고객 아이디
select name
from customer
where custid in ( select distinct custid 
                  from orders );
                  
select distinct c.name
from customer c, orders o
where c.custid = o.custid;

-- 3. 대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오
select name
from customer
where custid in ( select distinct custid
                  from orders 
                  where bookid in ( select bookid
                                    from book 
                                    where publisher = '대한미디어' ) );

select c.name
from customer c, orders o, book b
where c.custid = o.custid and 
      o.bookid = b.bookid and 
      b.publisher = '대한미디어';
      
-- 4. 출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오.
select b1.*
from book b1 -- b1.publisher = '이상미디어'
where b1.price > ( select avg(b2.price)
                   from book b2
                   where b2.publisher = b1.publisher
                   group by b2.publisher );
                   
select b2.publisher, avg(b2.price)
from book b2
-- where b2.publisher = '대한미디어'
group by b2.publisher;
                   
-- 
                   
                   
                   