select * from unittree;

delete from unittree where id='test1';

SET SQL_SAFE_UPDATES = 0;

insert into unittree(id, name, pid) values('0001', 'test1', '0001');
insert into unittree(id, name, pid) values('0002', 'test2', '0002');
insert into unittree(id, name, pid) values('0003', 'test3', '0003');