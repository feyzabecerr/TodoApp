create sequence hibernate_sequence start with 1 increment by 1;

    create table task (
       id bigint not null,
        date date,
        description varchar(255),
        is_active boolean not null,
        primary key (id)
    );

    create table user (
       id bigint generated by default as identity,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    );
create sequence hibernate_sequence start with 1 increment by 1;

    create table task (
       id bigint not null,
        date date,
        description varchar(255),
        is_active boolean not null,
        primary key (id)
    );

    create table user (
       id bigint generated by default as identity,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    );
create sequence hibernate_sequence start with 1 increment by 1;

    create table task (
       id bigint not null,
        date date,
        description varchar(255),
        is_active boolean not null,
        primary key (id)
    );

    create table user (
       id bigint generated by default as identity,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    );
create sequence hibernate_sequence start with 1 increment by 1;

    create table task (
       id bigint not null,
        date date,
        description varchar(255),
        is_active boolean not null,
        primary key (id)
    );

    create table user (
       id bigint generated by default as identity,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    );