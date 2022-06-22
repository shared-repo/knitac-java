create database demoweb;

create user knit@localhost identified by "mysql";
create user knit@"%" identified by "mysql"

grant all privileges on demoweb.* to knit@localhost;
grant all privileges on demoweb.* to knit@"%";

flush privileges;

USE demoweb;

CREATE TABLE member 
(
    memberid VARCHAR (20) PRIMARY KEY
    , passwd VARCHAR (100) NOT NULL
    , email VARCHAR (50) NOT NULL
    , usertype VARCHAR (50) DEFAULT ('user') CHECK ( usertype IN ('user', 'admin'))
    , regdate DATE DEFAULT (NOW())
    , active BOOLEAN DEFAULT (TRUE)
);

CREATE TABLE board
(
    boardno INT PRIMARY KEY AUTO_INCREMENT
    , title VARCHAR(100) NOT NULL
    , writer VARCHAR (20) NOT NULL
    , content VARCHAR (4000) NOT NULL
    , regdate DATE DEFAULT (NOW())
    , readcount INT DEFAULT (0)
    , deleted BOOLEAN DEFAULT (FALSE)

    , CONSTRAINT fk_board_to_member FOREIGN KEY (writer) REFERENCES member (memberid)
);

CREATE TABLE boardattach
(
    attachno INT PRIMARY KEY AUTO_INCREMENT
    , boardno INT NOT NULL
    , userfilename VARCHAR (100) NOT NULL
    , savedfilename VARCHAR (100) NOT NULL
    , downloadcount INT DEFAULT (0)

    , CONSTRAINT fk_boardattach_to_board FOREIGN KEY (boardno) REFERENCES board (boardno)
);

CREATE TABLE boardcomment
(
    commentno INT PRIMARY KEY AUTO_INCREMENT
    , boardno INT NOT NULL
    , writer VARCHAR (20) NOT NULL
    , content VARCHAR (1000) NOT NULL
    , regdate DATE DEFAULT (NOW())
    , deleted BOOLEAN DEFAULT (FALSE)

    , groupno INT NOT NULL
    , step INT NOT NULL
    , depth INT NOT NULL

    , CONSTRAINT fk_boardcomment_to_board FOREIGN KEY (boardno) REFERENCES board (boardno)
    , CONSTRAINT fk_boardcomment_to_member FOREIGN KEY (writer) REFERENCES member (memberid)
);

