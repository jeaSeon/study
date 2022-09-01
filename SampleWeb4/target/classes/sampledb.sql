select * from EMPLOYEES

drop table sample

create table sample(
id varchar2(12) primary key,
title varchar2(200),
reg_user varchar2(20),
content varchar2(2000),
reg_date date default sysdate
)

select * from sample;

insert into sample values('SAMPLE-00001','JAVA Programming','관리자','JAVA관련 글만 등록하세요',sysdate);

select max(id) from sample

create table ids(
	table_name varchar(16) primary key,
	next_id number(30) not null
);

insert into ids values('SAMPLE',2);

select * from ids;

delete sample;
select * from sample;

select id, title, reg_user, content, reg_date 
from sample 
where title like '%g%' 
order by reg_date desc;

select id, title, reg_user, content, reg_date 
from sample 
where content like '%h%' 
order by reg_date desc