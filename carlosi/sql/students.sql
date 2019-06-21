--- File: students.sql
--- Date: 2019/01/27
--- Name: Ian Carlos
--- Description: This SQL file will be used to store and retrieve data for the Student.java class.

DROP TABLE IF EXISTS students CASCADE;

CREATE TABLE students(
	id BIGINT PRIMARY KEY REFERENCES users(id),
	programCode CHAR(4) NOT NULL,
	programDesc VARCHAR(50) NOT NULL,
	year CHAR(1) NOT NULL
);

ALTER TABLE students OWNER TO webd4201_admin;

INSERT INTO students(id, programCode, programDesc, year) values (
	100111111,
	'CSTY',
	'Computer System Technology',
	3
);

INSERT INTO students(id, programCode, programDesc, year) values (
	100683221,
	'CPGM',
	'Computer Programmer',
	2
);

INSERT INTO students(id, programCode, programDesc, year) values (
	100221683,
	'BACT',
	'Accounting – Business Administration',
	1
);
