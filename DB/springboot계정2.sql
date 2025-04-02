insert into board values(board_seq.nextval, DEFAULT, sysdate, sysdate ,'내용1', '제목1','user01');
commit;

insert into reply values(sysdate,1, reply_seq.nextval, sysdate, '댓글1', 'user2'); 
commit;

insert into board values(board_seq.nextval, DEFAULT, sysdate, sysdate ,'내용2', '제목2','user02');
commit;