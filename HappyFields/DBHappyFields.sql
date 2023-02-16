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
    preferenza varchar(255) references Sport.nome_s
    ON UPDATE CASCADE,
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

create table evento(
	titolo varchar(255) not null,
    sport varchar(255) references sport.nome_s
    ON UPDATE CASCADE,
    campo varchar(255) references campo.nome_c
    ON UPDATE CASCADE,
    data_e date not null,
    ora double not null,
    primary key (titolo, campo)
);

create table campo(
	nome_c varchar(255) primary key,
    numero_giocatori int not null,
    provincia varchar(255) not null,
    citta varchar(255) not null,
    via varchar(255) not null,
    costo double not null,
    lunghezza double not null,
    larghezza double not null
);

create table prenotazione(
	numero_prenotazione int primary key auto_increment,
    admin_prenotazione varchar(255) references utente.username
    ON UPDATE CASCADE,
    evento varchar(255) references evento.titolo
);

create table gestisce(
	gestore varchar(255) references gestore.username_g
    ON UPDATE CASCADE,
    campo varchar(255) references campo.nome_c
    ON UPDATE CASCADE,
    primary key (gestore, campo)
);

create table partecipa(
	username varchar(255) references utente.username
    ON UPDATE CASCADE,
    nomeEvento varchar(255) references evento.titolo
    ON UPDATE CASCADE,
    primary key (username, nomeEvento)
);

create table attesa(
	titolo varchar(255) not null,
    sport varchar(255) references sport.nome_s
    ON UPDATE CASCADE,
    campo varchar(255) references campo.nome_c
    ON UPDATE CASCADE,
    data_e date not null,
    ora double not null,
    primary key (titolo, campo)
);

