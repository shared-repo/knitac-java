CREATE TABLE member_tbl_02
(
    custno number(6) not null primary key,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2)
);

CREATE TABLE money_tbl_02
(
    custno number(6) not null,
    saleno number(8) not null,
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    constraint pk_money_tbl_02 primary key (custno, saleno),
    constraint fk_member_to_money foreign key (custno) references member_tbl_02(custno) 
);

create sequence member_tbl_02_sequence nocache;