CREATE TYPE account_type AS ENUM ('DEFAULT', 'SHOPKEEPER');

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    user_id bigint NOT NULL,
    type account_type NOT NULL,
    balance decimal(12,2) DEFAULT 0,
    constraint fk_users_accounts
         foreign key (user_id)
         REFERENCES users (id),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    from_account_id bigint NOT NULL,
    to_account_id bigint NOT NULL,
  	FOREIGN KEY (from_account_id) REFERENCES accounts (id),
  	FOREIGN KEY (to_account_id) REFERENCES accounts (id),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

--just to simulate users
insert into users (name, cpf, email) values ('Ada', '1111111111' ,'ada@bank.com');
insert into users (name, cpf, email) values ('Grace', '22222222222' ,'Grace@bank.com');
insert into users (name, cpf, email) values ('Margaret', '333333333333' ,'Margaret@bank.com');

insert into accounts (user_id, type, balance) values (
  (select id from users where cpf = '1111111111'),
  'DEFAULT',
  50.00
);

insert into accounts (user_id, type, balance) values (
  (select id from users where cpf = '22222222222'),
  'DEFAULT',
  50.00
);

insert into accounts (user_id, type) values (
  (select id from users where cpf = '333333333333'),
  'SHOPKEEPER'
);

