
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
    accountType varchar(20),
    balance decimal,
    PRIMARY KEY (accountID),
    foreign key (customerID) references customers (customerID)
);

CREATE TABLE pendingAccounts(
    pAccountID int,
    pCustomerID int,
    pAccountType varchar(20),
    pBalance decimal,
    PRIMARY KEY (pAccountID),
    foreign key (pCustomerID) references customers (customerID)
);

insert into users(userID,fullName,username,passwrd) values (123, 'Luke Morton','LMorton','password');

insert into users(userID,fullName,username,passwrd) values (456, 'Garinn Morton','GMorton','password2');
insert into customers(customerID,userID) values (444,456);
insert into accounts(accountID,customerID,accountType,balance) values (111,444,'Checking',1000.00);
insert into accounts(accountID,customerID,accountType,balance) values (222,444,'Saving',10000.00);

insert into users(userID,fullName,username,passwrd) values (789, 'Bryn Portella','BPortella','password3');
insert into employees(employeeID,userID) values (777,789);


insert into accounts(accountID,customerID,accountType,balance) values (123,333,'Checking',0.00);
insert into accounts(accountID,customerID,accountType,balance) values (124,333,'Saving',4500.00);

insert into pendingaccounts(paccountID,pcustomerID,paccountType,pbalance) values (124,333,'Checking',0.00);

insert into accounts(accountID,customerID,accountType,balance) values (121,111,'Checking',8000.00);
insert into accounts(accountID,customerID,accountType,balance) values (122,111,'Saving',15000.40);
insert into customers(customerID,userID) values (111,123);

drop table accounts;

select * from accounts;

update accounts 
set balance = nv.balance
from 
	(values
		(111,'Checking',7998),
		(111,'Saving',15001.40)
	) as nv (customerID, accountType,balance)
where accounts.customerID = nv.customerID and accounts.accounttype = nv.accountType;


select * from accounts where customerID = 111;

delete from accounts where customerID = 444;

truncate table pendingaccounts;
truncate table accounts;
truncate table employees;
truncate table customers,accounts,pendingaccounts;
truncate table users,customers,employees,accounts,pendingaccounts;


