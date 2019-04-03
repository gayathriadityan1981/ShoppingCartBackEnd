/**
 Author: Mrin
 Model : NorthWind
**/

DROP SCHEMA IF EXISTS mydb;

CREATE SCHEMA mydb;
USE mydb;

/* Table: user (Application Users) */
CREATE TABLE user (
    user_id     NVARCHAR(20) NOT NULL,
    password    NVARCHAR(20) NOT NULL,
    first_name  NVARCHAR(50) ,
    last_name   NVARCHAR(50) ,
    email       NVARCHAR(70) ,
    security_provider_id INT ,
    default_customer_id  INT ,
    company     NVARCHAR(50) ,
    phone       NVARCHAR(20) ,
    address1    NVARCHAR(100),
    address2    NVARCHAR(100),
    country     NVARCHAR(20) ,
    postal      NVARCHAR(20) ,
    role        NVARCHAR(20) ,
    other_roles NVARCHAR(80) ,
    is_active   boolean  ,
    is_blocked  boolean  ,
    secret_question     NVARCHAR(100),
    secret_answer       NVARCHAR(100),
    enable_beta_testing boolean,
    enable_renewal      boolean,
    CONSTRAINT user_id PRIMARY KEY(user_id)
);
