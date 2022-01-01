create table if not exists ingredient
(
    id   varchar(20) not null
        primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists taco
(
    id int auto_increment,
    name varchar(50) not null,
    created datetime not null,
    constraint taco_pk
        primary key (id)
);

create table if not exists taco_ingredients
(
    taco_id       int not null,
    ingredient_id int not null,
    primary key (taco_id, ingredient_id)
);

create table if not exists taco_order
(
    id identity,
    deliveryName   varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity   varchar(50) not null,
    deliveryState  varchar(2)  not null,
    deliveryZip    varchar(10) not null,
    ccNumber       varchar(16) not null,
    ccExpiration   varchar(5)  not null,
    ccCVV          varchar(3)  not null,
    placedAt       timestamp   not null
);

create table if not exists taco_order_tacos
(
    taco_order bigint not null,
    taco      bigint not null
);