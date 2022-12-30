drop schema if exists HappyFields;
create schema HappyFields;
use HappyFields;
create table utente(
	username varchar(255) not null,
    pass varchar(255) not null,
    tipo varchar(255) not null, #registrato o gestore
    primary key(username, pass)
);