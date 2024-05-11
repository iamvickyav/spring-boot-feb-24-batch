create table student (id varchar(36), name varchar(100), dept varchar(10), email_address varchar(30), created TIMESTAMP, updated TIMESTAMP, primary key(id));

create table staff (id varchar(36) primary key, name varchar(100), role ENUM ('ADMIN','PROFESSOR','ASSISTANTS', 'IT_SUPPORT'), email_address varchar(100), password varchar(100), created TIMESTAMP, updated TIMESTAMP);

insert into staff values ('5e9d2fe5-ee3a-4041-967f-7b22fceb00b1', 'ADMIN', 'ADMIN', 'admin@centrallib.org', 'root123', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
