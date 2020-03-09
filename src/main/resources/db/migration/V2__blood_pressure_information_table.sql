Create Table blood_pressure (
id BIGINT NOT NULL AUTO_INCREMENT,
systolicPulse INTEGER NOT NULL,
diastolicPulse INTEGER NOT NULL,
pulse INTEGER,
description varchar(250),
CONSTRAINT blood_pressure_pk PRIMARY KEY (id)
);