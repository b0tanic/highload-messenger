-- liquibase formatted sql

-- changeset AAvalyan:init_database
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE DOMAIN gender CHAR(1)
    CHECK (value IN ( 'F' , 'M' ));

CREATE TABLE users (
    id CHAR(36) PRIMARY KEY,
    first_name VARCHAR,
    second_name VARCHAR,
    birth_date DATE,
    sex gender,
    biography VARCHAR,
    city VARCHAR
);


CREATE TABLE passwords (
    val VARCHAR,
    user_id CHAR(36) REFERENCES users (id)
);