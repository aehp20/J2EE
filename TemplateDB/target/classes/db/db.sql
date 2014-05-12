CREATE SEQUENCE seq_users;

CREATE TABLE Users
(
  id integer NOT NULL DEFAULT nextval('seq_users'::regclass),
  firstName character varying(255) NOT NULL,
  lastName character varying(255) NOT NULL,
  email character varying(255) NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);