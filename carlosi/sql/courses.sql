--- File: courses.sql
--- Date: 2019/04/02
--- Name: Ian Carlos
--- Description: This SQL file will generate a courses table from the .sql file given.

DROP TABLE IF EXISTS Courses;
CREATE TABLE Courses
(
     CourseCode           VARCHAR(8) PRIMARY KEY,
     CourseTitle          VARCHAR(64) NOT NULL,
     GPAWeighting         FLOAT4 NOT NULL
);
ALTER TABLE Courses OWNER TO webd4201_admin;

--Semester 1 Common
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('COMM3201', 'Communications I for IT ', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DBAS1201', 'Intro to Databases ', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DCOM1100', 'Data Communications & Networking I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('GNED0000', 'General Education Elective ', 3);  
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('MATH1100', 'Mathematics for IT', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('PROG2201', 'Intro to Programming ', 4);

--Semester 2 Common
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('COPS1104', 'Computer Operating Systems', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CSYS1122', 'Computer Systems I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('WEBD2201', 'Web Development - Fundamentals', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('OOP2200', 'OOP I', 4);

--Semester 2 CP/CPA
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('SYDE2203', 'Systems Development I', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETD2202', '.Net Development I', 3);

--Semester 2 CSTC/CSTY
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('VIRT2200', 'Intro to Cloud Computing & Virtualization', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DCOM2100', 'Data Communications & Networking II', 4);

--Semester 3 Common
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('COMM4201', 'Communications II for IT ', 3);

--Semester 3 CP/CPA
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETD3202', '.Net Development II', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('OOP3200', 'OOP II', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('SYDE3203', 'Systems Development II', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('SYSA3204', 'System Support & Automation', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('WEDE3201', 'Web Development - Intermediate', 4);

--Semester 4 CP/CPA
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DBAS5206', 'Database Development I', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('MAFD4202', 'Mainframe Development I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('MODE4201', 'Mobile Development', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('OOP4200', 'OOP III', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('WEDJ4203', 'Web Development - Java', 4);

--Semester 5 CP/CPA
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DBAS6206', 'Database Development II', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('ITBU5200', 'IT for Business I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('MAFD5202', 'Mainframe Development II', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('SYDE5203', 'Systems Development III', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('WEBF5201', 'Web Development - Frameworks', 4);

--Semester 6 CP/CPA
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CAPR6203', 'Capstone Project', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('FWKI6203', 'Field Placement Seminar - CPA', 1);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('FWKI6204', 'Field Placement - CPA', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('ITBU6200', 'IT for Business I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('MAFD6202', 'Mainframe Development III', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('TECH6200', 'Emerging Technologies', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('WEBC6201', 'Web Development - Client Side Scripting', 4);

--Semester 3 CSTC/CSTY
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CSYS2122', 'Computer Systems II', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DCOM3100', 'Data Communications & Networking III', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETW4102', 'Network Administration I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('PROG3103', 'Scripting & Automation I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('PROJ6101', 'Project Management', 3);

--Semester 4 CSTC/CSTY
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CLNT1100', 'Intro to Linux', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DCOM4100', 'Data Communications & Networking IV', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETW5100', 'Network Administration II', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('PROG4103', 'Scripting & Automation II', 4);

--Semester 5 CSTC/CSTY
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CLNT1101', 'Client/Server Computing I', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('DCOM5100', 'Data Communications & Networking V', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETW6100', 'Network Administration III', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('FWKC5101', 'Field Placement Seminar - CSTY', 1);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('SECR1100', 'CCNA Security', 1);

--Semester 6 CSTC/CSTY
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('CLNT2101', 'Client/Server Computing II', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('FWKC6101', 'Field Placement - CSTY', 3);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETW7100', 'Network Administration IV', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('NETW8100', 'Network Administration V', 4);
INSERT INTO Courses(CourseCode,CourseTitle,GPAWeighting)VALUES('VOIP2100', 'Unified Communications', 4);

--Show content
SELECT * FROM Courses;