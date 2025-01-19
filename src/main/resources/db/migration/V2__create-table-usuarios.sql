create table usuarios(

    id bigint not null auto_increment,
    login varchar(120) not null,
    clave varchar(250) not null,

    primary key(id)

);