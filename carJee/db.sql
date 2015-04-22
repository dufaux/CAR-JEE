create table author(
	name varchar(255) not null,
	firstname varchar(255) not null,
	constraint author_pk primary key (name,firstname)
);

create table book(
	title varchar(255) not null,
	parution_year int not null,
	author_name varchar(255) not null,
	author_firstname varchar(255) not null,
	constraint book_pk primary key (title),
	constraint author_fk 
	foreign key(author_name,author_firstname)
	references author(name,firstname)
);

create table client(
	username varchar(255) not null,
	password varchar(255) not null,
	mail varchar(255) not null,
	constraint client_pk primary key (username)
);

create table command(
	command_id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	client_username varchar(255),
	constraint command_pk primary key (command_id),
	constraint client_fk
	foreign key (client_username)
	references client
);

create table book_join_command(
	title varchar(255) not null,
	command_number int not null,
        constraint bkj_pk primary key (title,command_number),
	constraint book_fk foreign key (title) references book,
        constraint command_fk foreign key (command_number) references command
);

insert into author values('Hugo','Victor');
insert into author values('Hemingway','Ernest');
insert into author values('Boulet','');
insert into author values('Houellebecq','Michel');
