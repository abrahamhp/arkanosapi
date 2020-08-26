create table person
(
   id numeric(5) not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   age integer not null,
   profesion varchar(255),
   email varchar(255),
   weight decimal(4,1) not null,
   primary key(id)
);