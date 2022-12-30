drop schema if exists HappyFields;
create schema HappyFields;
use HappyFields;
create table utente(
	username varchar(255) not null,
    pass varchar(255) not null,
    provincia varchar(2) not null,
    citta varchar(255) not null,
    via varchar(255) not null,
    telefono long not null,
    iban varchar(27),
    preferenza varchar(255) references Sport.nome_s,
    primary key(username, pass)
);

create table gestore(
	username_g varchar(255) not null,
    pass_g varchar(255) not null,
    nome varchar(255) not null,
    cognome varchar(255) not null,
    provincia varchar(255) not null,
    citta varchar(255) not null,
    via varchar(255) not null,
    iban_g varchar(255) not null,
    telefono_g varchar(255) not null,
    primary key (username_g, pass_g)
    # vanno aggiunti i campi ma devo pensare a come fare
);

create table sport(
	nome_s varchar(255) primary key
);