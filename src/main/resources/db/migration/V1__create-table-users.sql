CREATE TYPE user_type AS ENUM ('DEFAULT', 'SHOPKEEPER');

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    type user_type
);

--just to imulate users
insert into users (name, cpf, email, type) values ('Ada', '1111111111' ,'ada@bank.com', 'DEFAULT');
insert into users (name, cpf, email, type) values ('Grace', '22222222222' ,'Grace@bank.com', 'DEFAULT');
insert into users (name, cpf, email, type) values ('Margaret', '333333333333' ,'Margaret@bank.com', 'SHOPKEEPER');