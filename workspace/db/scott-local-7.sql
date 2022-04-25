-- 테이블 만들기 1
create table my_emp
(
--  컬럼이름    자료형                 NULL?       DEFAULT
    empno      number(4, 0)          NOT NULL,
    ename      varchar2(20 BYTE)     NOT NULL,
    job        varchar2(20 CHAR)     NULL,
    mgr        number(4, 0)          NULL,
    hiredate   date                               DEFAULT (SYSDATE),
    sal        number(7, 2)          NULL,
    comm       number(7, 2)          NULL,
    deptno     number(2,0)           NOT NULL
);
desc my_emp;

-- 테이블 제거
drop table my_emp;

-- 테이블 만들기 2
create table my_emp
(
--  컬럼이름    자료형                 NULL?       DEFAULT
    empno      number(4, 0)          NOT NULL,
    ename      varchar2(20 BYTE)     NOT NULL,
    job        varchar2(20 CHAR)     NULL,
    mgr        number(4, 0)          NULL,
    hiredate   date                               DEFAULT (SYSDATE),
    sal        number(7, 2)          NULL,
    comm       number(7, 2)          NULL,
    deptno     number(2,0)           NOT NULL,
    -- primary key (empno), -- 기본키 지정
    constraint pk_my_emp primary key (empno), -- 기본키 지정
    -- foreign key (deptno) references dept(deptno) -- 외래키 지정
    constraint fk_dept_my_emp foreign key (deptno) references dept(deptno) -- 외래키 지정
);
desc my_emp;

-- 테이블 제거
drop table my_emp;

-- 테이블 수정

select * from my_emp;

-- 컬럼 추가
alter table my_emp
add mobile varchar2(15) null;
-- 컬럼 이름 변경
alter table my_emp
rename column mobile to phone;
-- 컬럼 자료형 변경
alter table my_emp
modify empno number(6);
-- 컬럼 제거
alter table my_emp
drop column phone;

-- 테이블 이름 변경
rename my_emp to emp2;

-- 테이블 만들기 1
-- 이름 : 회원 (Member)
-- 컬럼 : 회원아이디(memberid), 비밀번호(passwd), 이메일(email), 
--       상태(active, char(1) ), 가입일자(regdate)
-- 제약조거 : 회원아이디 : pk
--           비밀번호 : not null
--           상태 : 기본값 '1', 가입일자 : default 현재
create table member
(
    memberid varchar2(20) primary key,
    passwd varchar2(100) not null,
    email varchar2(50) null,
    active char(1) default ('1'),
    regdate date default (sysdate)
);

-- 테이블 만들기 2
-- 이름 : 게시판 (Board)
-- 컬럼 : 글번호(boardno), 제목(title), 작성자(writer), 내용(content),
--        작성일자(writedate), 수정일자(modifydate), 조회수 (readcount)
-- 제약조건 : 글번호 : pk / 제목, 작성자 : not null
--           작성일자, 수정일자 : default 현재, 조회수 : default 0

create table board
(
    boardno number not null,
    title varchar2(100 char) not null,
    writer varchar2(20) not null,
    content varchar2(4000 char) null,
    writerdate date default(sysdate),
    modifydate date default(sysdate),
    readcount number(7) default (0),
    constraint pk_board primary key (boardno),
    constraint fk_board_member 
    foreign key (writer) references member(memberid)
);

-- 자동 증가 번호를 생산하는 도구
create sequence board_sequence nocache;

-- 자동 증가 번호 추출기에서 번호 뽑기 (뽑은 다음 번호 증가)
select board_sequence.nextval 다음번호 from dual;
-- 자동 증가 번호 추출기에서 번호 뽑기 (뽑은 다음 번호 유지) 
select board_sequence.currval 다음번호 from dual;

-- member 테이블과 board 테이블에 데이터 insert하는 구문 작성
-- board 테이블에 insert할 때에는 sequence 사용







