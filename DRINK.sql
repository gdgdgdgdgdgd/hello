create user c##voter identified by 1234;
grant connect, resource, unlimited tablespace to c##voter;

create table "VOTE"(
"NUMBER" number primary key,
"NAME" varchar2(100) not null,
"VOTE" number
);

create sequence "SEQ_VOTE" start with 1 increment by 1 nocache;