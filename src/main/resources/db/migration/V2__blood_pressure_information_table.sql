Create Table blood_pressure (
id BIGINT NOT NULL AUTO_INCREMENT,
systolic_pulse INTEGER NOT NULL,
diastolic_pulse INTEGER NOT NULL,
pulse INTEGER,
description varchar(250),
CONSTRAINT blood_pressure_pk PRIMARY KEY (id)
);