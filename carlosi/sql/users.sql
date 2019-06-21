--- File: users.sql
--- Date: 2019/01/27
--- Name: Ian Carlos
--- Description: This SQL file will be used to store and retrieve data for the User.java class.

CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
	id BIGINT PRIMARY KEY,
	password VARCHAR(40) NOT NULL,
	firstName VARCHAR(128) NOT NULL,
	lastName VARCHAR(128) NOT NULL,
	emailAddress VARCHAR(255) NOT NULL,
	lastAccess DATE NOT NULL,
	enrolDate DATE NOT NULL,
	enabled BOOLEAN NOT NULL,
	type CHAR(1)
);

ALTER TABLE users OWNER TO webd4201_admin;

INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100111111,
	ENCODE(DIGEST('password','sha1'), 'hex'),
	'Mike',
	'Jones',
	'mike.jones@dcmail.ca',
	'2019-1-27',
	'2019-1-27',
	'true',
	's'
	);

INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100683221,
	ENCODE(DIGEST('password1','sha1'), 'hex'),
	'Ian',
	'Carlos',
	'ian.carlos@dcmail.ca',
	'2019-1-28',
	'2019-1-28',
	'true',
	's'
	);

INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100221683,
	ENCODE(DIGEST('password2','sha1'), 'hex'),
	'John',
	'Doe',
	'john.doe@dcmail.ca',
	'2019-1-29',
	'2019-1-29',
	'true',
	's'
	);
	
INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100111110,
	ENCODE(DIGEST('password','sha1'), 'hex'),
	'Jane',
	'Doe',
	'jane.doe@dcmail.ca',
	'2019-4-7',
	'2019-4-7',
	'true',
	's'
	);


INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100123456,
	ENCODE(DIGEST('password3','sha1'), 'hex'),
	'Darren',
	'Puffer',
	'darren.puffer@dcmail.ca',
	'2019-1-30',
	'2019-1-30',
	'true',
	'f'
	);

INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100789012,
	ENCODE(DIGEST('password4','sha1'), 'hex'),
	'Thom',
	'MacDonald',
	'thom.macdonald@dcmail.ca',
	'2019-1-31',
	'2019-1-31',
	'true',
	'f'
	);

INSERT INTO users(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, enabled, type) values (
	100678321,
	ENCODE(DIGEST('password4','sha1'), 'hex'),
	'Austin',
	'Garrod',
	'austin.garrod@dcmail.ca',
	'2019-2-1',
	'2019-2-1',
	'true',
	'f'
	);