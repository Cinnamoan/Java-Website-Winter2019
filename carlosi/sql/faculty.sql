--- File: faculty.sql
--- Date: 2019/01/27
--- Name: Ian Carlos
--- Description: This SQL file will be used to store and retrieve data for the Faculty.java class.

DROP TABLE IF EXISTS faculty CASCADE;

CREATE TABLE faculty(
	id BIGINT PRIMARY KEY REFERENCES users(id),
	schoolCode CHAR(5) NOT NULL,
	schoolDesc VARCHAR(70) NOT NULL,
	office VARCHAR(6) NOT NULL,
	extension INT NOT NULL
);

ALTER TABLE faculty OWNER TO webd4201_admin;

INSERT INTO faculty(id, schoolCode, schoolDesc, office, extension) values (
	100123456,
	'BITM',
	'School of Business, IT & Management',
	'C-315',
	2044
);

INSERT INTO faculty(id, schoolCode, schoolDesc, office, extension) values (
	100789012,
	'BITM',
	'School of Business, IT & Management',
	'H-216',
	2646
);

INSERT INTO faculty(id, schoolCode, schoolDesc, office, extension) values (
	100678321,
	'BITM',
	'School of Business, IT & Management',
	'C-307',
	1234
);