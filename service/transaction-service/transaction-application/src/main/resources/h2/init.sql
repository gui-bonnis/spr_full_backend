create table accounts (
    id bigint auto_increment,
    name varchar(50),
    balance bigint,
    primary key (id)
);

create table account_transaction (
    id bigint auto_increment,
    description varchar(50),
    amount bigint,
    dateTime TIMESTAMP,
    subCategory bigint,
    accountId bigint,
    status varchar(50),
    transactionDate TIMESTAMP,
    primary key (id),
    foreign key (accountId) references accounts(id)
);
