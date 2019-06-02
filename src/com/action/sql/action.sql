create schema if not exists price_action;

use price_action;

create table administrateur(
	id bigint primary key auto_increment,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null
);

create table bourse(
	id bigint primary key auto_increment,
	name varchar(255) not null
);

create table action(
	id bigint primary key auto_increment,
	name varchar(255) not null unique,
	opening_amount double not null,
	closing_amount double not null,
	date timestamp default now(),
	variation double not null,
	bourse_id bigint not null,
	foreign key(bourse_id) references bourse(id) ON DELETE CASCADE
);

