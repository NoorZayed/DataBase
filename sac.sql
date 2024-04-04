CREATE DATABASE IF NOT EXISTS sac;
USE sac;
CREATE TABLE customer (
    custid VARCHAR(7) PRIMARY KEY,
    custname VARCHAR(32),
    custphone VARCHAR(10),
    custpassword VARCHAR(32),
    address VARCHAR(32)
);
CREATE TABLE buys (
    serialnum VARCHAR(32) ,
    custid VARCHAR(32),
    sellid VARCHAR(32),
    PRIMARY KEY (serialnum, custid, sellid)
);
CREATE TABLE shop (
    shopname VARCHAR(32) PRIMARY KEY,
    shopphone VARCHAR(32),
    shopaddress VARCHAR(32)
);
CREATE TABLE service (
    repid VARCHAR(32),
    custid VARCHAR(32),
    serialnum VARCHAR(32),
    PRIMARY KEY (serialnum, custid, repid)
);
CREATE TABLE repemp (
    repid VARCHAR(32) PRIMARY KEY,
    empname VARCHAR(32),
    empemail VARCHAR(32),
    empphone VARCHAR(32),
    empaddress VARCHAR(32),
    empgender VARCHAR(32),
    shopname VARCHAR(32),
    empage INT,
    FOREIGN KEY (shopname) REFERENCES shop(shopname)
);

CREATE TABLE sellemp (
    sellid VARCHAR(32) PRIMARY KEY,
    empname VARCHAR(32),
    empemail VARCHAR(32),
    empphone VARCHAR(32),
    empaddress VARCHAR(32),
    empgender VARCHAR(32),
    shopname VARCHAR(32),
    empage INT,
    FOREIGN KEY (shopname) REFERENCES shop(shopname)
);
CREATE TABLE Computer (
    serialnum VARCHAR(32) PRIMARY KEY,
    compcolor VARCHAR(32),
    cputype VARCHAR(32),
    compmodel VARCHAR(32),
    compram INT,
    compstorage INT,
    isbuy INT,
    isrepair INT,
    compprice DOUBLE
);
describe sac.repemp;
describe sac.Computer;
Select * from Computer;
Select * from repemp;
Select * from sellemp;
Select * from customer;
Select * from service;
Select * from shop;
