--- File: schools.sql
--- Date: 2019/04/02
--- Name: Ian Carlos
--- Description: This SQL file will generate a schools table from the .csv file given.

DROP TABLE IF EXISTS schools CASCADE;

CREATE TABLE schools(
	schoolCode varchar(2) PRIMARY KEY,
	schoolDescription varchar(30) NOT NULL
); 


ALTER TABLE schools OWNER TO webd4201_admin;

INSERT INTO schools VALUES ('SV','Center for Food');
INSERT INTO schools VALUES ('SH','School of Hlth & Comm Services');
INSERT INTO schools VALUES ('SX','School of Bus, IT & Management');
INSERT INTO schools VALUES ('SM','School of Media, Art & Design');
INSERT INTO schools VALUES ('SQ','Sch of Science & Engineer Tech');
INSERT INTO schools VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
INSERT INTO schools VALUES ('SB','School of Business');
INSERT INTO schools VALUES ('SO','School College Work Initiative');
INSERT INTO schools VALUES ('SK','School of Justice & Emerg Serv');
INSERT INTO schools VALUES ('SY','Sch Interdisciplinary Studies');
