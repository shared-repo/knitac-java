desc emp;
select * from emp;
select *
from emp
where hiredate = '1980-12-17'; -- 날짜를 표시할 때 '사용

-- (1) 도서번호가 1인 도서의 이름 ( book table)
select * from book;
select bookname
from book
where bookid = 1;

-- (2) 가격이 20,000원 이상인 도서의 이름
select bookname
from book
where price >= 20000;

-- (3) 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
--     sum : 데이터의 합계를 계산하는 집계함수 
select custid from customer where name = '박지성';
select sum(saleprice) 구매액
from orders
where custid = 1;

-- (4) 박지성이 구매한 도서의 수(박지성의 고객번호는 1번으로 놓고 작성)
--     count : 데이터의 갯수(행의 갯수)를 알려주는 집계함수
select count( bookid ) 도서수
from orders
where custid = 1;

-- (1) 마당서점 도서의 총 개수
select count(*) 도서개수
from book;

-- (2)마당서점에 도서를 출고하는 출판사의 총 개수
-- select distinct publisher
select count(distinct publisher) 출판사개수
from book;

-- (3)모든 고객의 이름, 주소
desc customer;
select name, address
from customer;

-- (4)2020년 7월 4일~7월 7일 사이에 주문 받은 도서의 주문번호
select *
from orders
where orderdate between '2020-7-4' and '2020-7-7' ;

-- (5) 2020년 7월 4일~7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
select *
from orders
where orderdate not between '2020-7-4' and '2020-7-7' ;

select *
from orders
minus
select *
from orders
where orderdate between '2020-7-4' and '2020-7-7' ;

-- (6) 성이 ‘김’ 씨인 고객의 이름과 주소
select *
from customer
where name like '김%';

-- (7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
select *
from customer
where name like '김%아';






