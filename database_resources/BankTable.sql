create table users(
	userID int,
	fullName varchar(20),
	username varchar(20),
	passwrd varchar(20),
    PRIMARY KEY (userID)
);

create table customers(
    customerID int,
    userID int,
    PRIMARY KEY (customerID),
    foreign key (userID) references users (userID)
);

create table employees(
    employeeID int,
    userID int,
    PRIMARY KEY (employeeID),
    foreign key (userID) references users (userID)
);

CREATE TABLE accounts(
    accountID int,
    customerID int,
    PRIMARY KEY (accountID),
    foreign key (customerID) references customers (customerID)
);

CREATE TABLE checkings(
    typeID int,
    checkBalance decimal,
    PRIMARY KEY (typeID),
    foreign key (typeID) references accounts (accountID)
);

CREATE TABLE savings(
    typeID int,
    saveBalance decimal,
    PRIMARY KEY (typeID),
    foreign key (typeID) references accounts (accountID)
);