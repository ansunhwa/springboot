create sequence seq_board NOCACHE;

create table boardtest(
    board number PRIMARY key,
    title VARCHAR2(100),
    writer VARCHAR2(20),
    content VARCHAR2(500)
);

INSERT into boardtest values(seq_board.nextval, '제목1', '더조은', '내용1');
INSERT into boardtest values(seq_board.nextval, '제목2', '더빛나', '내용2');
commit;