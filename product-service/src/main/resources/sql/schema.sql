BEGIN;

create table if not exists product(
    id bigserial primary key,
    name text not null,
    price bigint,
    manufacture_cost real not null,
    unit_of_measure text,
    creation_date timestamp not null
);

create table if not exists person(
    id bigserial primary key,
    name text not null,
    birthday timestamp,
    passport_id text not null,
    product_id bigint references product(id)
);

create table if not exists coordinates(
    id bigserial primary key,
    x int not null check(x > -642),
    y int not null check(y <= 643),
    product_id bigint references product(id)
);

COMMIT;