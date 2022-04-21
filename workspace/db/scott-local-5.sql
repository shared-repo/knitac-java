-- group by 복습
select * from book;
select sum(price), count(price), avg(price) from book;

select publisher, count(price), avg(price) 
from book
group by publisher;

select * from orders;

-- 고객별 주문 통계
select c.custid, c.name, count(saleprice), round( avg(saleprice), 2 )
from orders o, customer c
where o.custid = c.custid
group by c.custid, c.name;

-- subquery 복습
-- 평균 주문 가격보다 높은 주문 조회
select avg(saleprice) from orders; -- 11800
select *
from orders
where saleprice > 11800; -- 위의 결과를 사용해서 조회

select *
from orders
where saleprice > ( select avg(saleprice) from orders );

-- 주문 실적이 있는 고객 조회
select *
from customer 
-- where custid IN ( select distinct custid from orders );
where custid NOT IN ( select distinct custid from orders ); -- 주문 실적이 없는 고객

-- 급여가 가장 많은 직원 조회 (EMP)
select * from emp where sal = ( select max(sal) from emp );

select rownum, empno, ename, sal -- rownum : 조회한 데이터의 순서번호
from emp;

select rownum, empno, ename, sal -- rownum : 조회한 데이터의 순서번호
from emp
order by sal desc;

select rownum, empno, ename, sal -- rownum : 조회한 데이터의 순서번호
from
(
    select empno, ename, sal
    from emp
    order by sal desc
) a
where rownum = 1;

-- scalar 부속 질의
select 
    (select avg(saleprice) from orders) 평균판매가격,
    (select avg(price) from book) 평균도서가격
from dual; -- dual : 명시적인 테이블을 지정할 수 없을 경우 사용하는 임시테이블

select * from salgrade;
select empno, ename, sal,
       ( select grade 
         from salgrade 
         where e.sal between losal and hisal ) grade
from emp e;

-- /////////////////////////////////////////////////

-- (5) 박지성이 구매한 도서의 출판사 수
select count(distinct publisher) 출판사수
from customer c, orders o, book b
where c.custid = o.custid and 
      o.bookid = b.bookid and
      c.name = '박지성';

select count(distinct publisher) 출판사수
from customer c
inner join orders o
on c.custid = o.custid
inner join book b
on o.bookid = b.bookid 
where c.name = '박지성';

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select b.bookname 도서명, b.price 정가, b.price - o.saleprice 할인액
from customer c, orders o, book b
where c.custid = o.custid and 
      o.bookid = b.bookid and
      c.name = '박지성';
      
-- (7) 박지성이 구매하지 않은 도서의 이름
select b.bookname
from book b
where b.bookid not in ( select o.bookid
                        from orders o, customer c
                        where o.custid = c.custid and
                              c.name = '박지성' );

-- (9) 주문 금액의 총액과 주문의 평균 금액
select sum(saleprice) "주문 총액", avg(saleprice) "주문 평균액"
from orders;

-- (10) 고객의 이름과 고객별 구매액
select c.name, nvl(sum(o.saleprice), 0) "주문총액"
from customer c, orders o
where c.custid = o.custid(+)
group by c.name;

-- (11) 고객의 이름과 고객이 구매한 도서 목록
select c.name, b.*
from customer c, orders o, book b
where c.custid = o.custid and o.bookid = b.bookid;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select rownum, a.*
from 
(
    select o.*, b.price - o.saleprice discount
    from book b, orders o
    where b.bookid = o.bookid
    order by discount desc
) a
where rownum = 1;

select o.*, b.price
from book b, orders o
where b.bookid = o.bookid
      and
      (b.price - o.saleprice) = ( select max(b2.price - o2.saleprice)
                                  from book b2, orders o2
                                  where b2.bookid = o2.bookid );

-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select c.custid, c.name, round(avg(o.saleprice), 2) "구매액 평균"
from customer c, orders o
where c.custid = o.custid
group by c.custid, c.name
having avg(o.saleprice) > ( select avg(saleprice) from orders );










