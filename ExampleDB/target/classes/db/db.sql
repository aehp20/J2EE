CREATE SEQUENCE seq_customer;

CREATE TABLE customer
(
  CUST_ID integer NOT NULL DEFAULT nextval('seq_customer'),
  NAME character varying(100) NOT NULL,
  AGE integer NOT NULL,
  CONSTRAINT pkey_customer PRIMARY KEY (CUST_ID)
);