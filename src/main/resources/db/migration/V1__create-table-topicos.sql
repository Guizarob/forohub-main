create table topicos(

    id bigint not null auto_increment,
    titulo varchar(120) not null unique,
    mensaje varchar(120) not null unique,
    fecha_Creacion datetime not null,
    status tinyint,
    autor varchar(120) not null,
    curso varchar(120) not null,

    primary key(id)

);