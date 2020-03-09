Create Table user (
id BIGINT NOT NULL AUTO_INCREMENT,
login varchar(50),
password varchar (50),
email varchar(50),
CONSTRAINT user_pk PRIMARY KEY (id)
);