--- File: marks.sql
--- Date: 2019/04/02
--- Name: Ian Carlos
--- Description: This SQL file will generate a marks table from the .sql file given.

DROP TABLE IF EXISTS Marks;
CREATE TABLE Marks
(
     CourseCode         VARCHAR(10) NOT NULL REFERENCES Courses(CourseCode),
     Id        			BIGINT NOT NULL REFERENCES Students(Id),
     Result         	SMALLINT NOT NULL DEFAULT 0,
	 PRIMARY KEY (CourseCode, Id, Result)
);
ALTER TABLE Marks OWNER TO webd4201_admin;

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('COMM3201', 100111110, 75);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DBAS1201', 100111110, 83);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MATH1100', 100111110, 58);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('PROG2201', 100111110, 74);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DCOM1100', 100111110, 68);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('COPS1104', 100111110, 61);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('CSYS1122', 100111110, 72);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEBD2201', 100111110, 83);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('OOP2200', 100111110, 94);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('SYDE2203', 100111110, 85);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('NETD2202', 100111110, 76);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('COMM4201', 100111110, 71);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('NETD3202', 100111110, 72);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('OOP3200', 100111110, 82);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('SYDE3203', 100111110, 81);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('SYSA3204', 100111110, 87);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEDE3201', 100111110, 87);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DBAS5206', 100111110, 61);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MAFD4202', 100111110, 67);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MODE4201', 100111110, 71);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('OOP4200', 100111110, 82);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEDJ4203', 100111110, 87);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DBAS6206', 100111110, 60);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('ITBU5200', 100111110, 63);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MAFD5202', 100111110, 72);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('SYDE5203', 100111110, 78);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEBF5201', 100111110, 76);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('CAPR6203', 100111110, 75);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('FWKI6203', 100111110, 60);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('FWKI6204', 100111110, 70);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('ITBU6200', 100111110, 73);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MAFD5202', 100111110, 63);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('TECH6200', 100111110, 85);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEBC6201', 100111110, 79);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('COMM3201', 100111111, 85);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DBAS1201', 100111111, 63);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('MATH1100', 100111111, 88);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('PROG2201', 100111111, 77);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DCOM1100', 100111111, 61);

INSERT INTO Marks(CourseCode, Id, Result) VALUES ('COPS1104', 100111111, 74);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('CSYS1122', 100111111, 79);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('WEBD2201', 100111111, 84);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('OOP2200', 100111111, 89);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('VIRT2200', 100111111, 94);
INSERT INTO Marks(CourseCode, Id, Result) VALUES ('DCOM2100', 100111111, 66);



--Show content
SELECT * FROM Marks;

--Table join with Courses table
SELECT Marks.Id, Courses.CourseCode, CourseTitle, Result FROM Courses, Marks WHERE Courses.CourseCode = Marks.CourseCode;
/*
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);
INSERT INTO Marks(CourseCode, Id, Result) VALUES (,100111110, XX);

*/

/*

'COMM4201'
'NETD3202'
'OOP3200'
'SYDE3203'
'SYSA3204'
'WEBD3201'
'DBAS5206'
'MAFD4202'
'MODE4201'
'OOP4200'
'WEBD4203'
'DBAS6206'
'ITBU5200'
'MAFD5202'
'SYDE5203'
'WEBF5201'
'CAPR6203'
'FWKI6203'
'FWKI6204'
'ITBU6200'
'MAFD6202'
'TECH6200'
'WEBC6201'
'CSYS2122'
'DCOM3100'
'NETW4102'
'PROG3103'
'PROJ6101'
'CLNT1100'
'DCOM4100'
'NETW5100'
'PROG4103'
'CLNT1101'
'DCOM5100'
'NETW6100'
'FWKC5101'
'SECR1100'
'CLNT2101'
'FWKC6101'
'NETW7100'
'NETW8100'
'VOIP2100'

*/

