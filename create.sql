CREATE TABLE unittree(
	opid INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id CHAR(40) UNIQUE,
	name CHAR(40) NOT NULL,
	pid CHAR(40) DEFAULT 'NULL'
)character set utf8 collate utf8_general_ci;

-- ALTER TABLE unittree ADD constraint chk_pid CHECK(pid in(select * from unittree));

drop table unittree;