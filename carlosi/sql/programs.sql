﻿--- File: programs.sql
--- Date: 2019/04/02
--- Name: Ian Carlos
--- Description: This SQL file will generate a schools table from the .csv file given.

DROP TABLE IF EXISTS programs CASCADE;

CREATE TABLE programs(
	programCode char(4),
	programDescription varchar(30) NOT NULL,
	schoolCode VARCHAR(2) REFERENCES schools,
	DiplomaCode VARCHAR(10) NOT NULL,
	PRIMARY KEY (programCode, schoolCode)
); 

ALTER TABLE programs OWNER TO webd4201_admin;

INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('AAGR','Food and Farming','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ACAR','Animal Care','SH','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ACCT','Business - Accounting','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ACGR','Activation Coor in Gerontology','SH','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ACPA','Accounting and Payroll','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ACTU','Bus Acct - UOIT Transfer','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADA','Animation - Digital Arts','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADFL','Advanced Filmmaking','SM','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADIG','Animation - Digital','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADMH','Addictions and Mental Health','SH','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADMM','Advert-Digital Media Managemen','SM','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ADP','Animation - Digital Production','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ARHC','Architectural Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ARHY','Architectural Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('AVMC','Advertising and Marketing Comm','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BACT','Bus Admin - Accounting','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BDCT','Building Const Technician','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BESB','Entrepreneurship & Small Bus','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BETU','Entre Small Bus UOIT Transfer','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BFNC','Bus Admin - Finance','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BFND','Business Fundamentals','SX','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BGEN','Bus Admin - General','SB','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BHRM','Bus Admin - Human Resources','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BITY','Biotechnology - Advanced','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BMKG','Bus Admin - Marketing','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BMOP','Bus Admin-Materials and Oper M','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BMTY','Biomedical Eng. Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BMYF','Biomedical Eng Technology FT','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BRCM','Broad-Radio and Contemp Media','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BSOC','Bus Admin-Sup Chain & Op Ma Co','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BSOM','Bus Admin-Sup Chain and Op Ma','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('BTYF','Biotechnology - Fast track','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CCH','Reg Nurse Critical Care Nrsg','SH','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CCSF','Comm Ser and Child Stud Found','SH','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CCST','Constr Carpentry - Sustainable','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CDA','Communicative Disorders Assist','SH','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CETC','Civil Engineering Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CETY','Civil Engineering Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CFND','Computer Foundations','SX','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CHEM','Chemical Eng. Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CHLF','Chemical Lab Tech - Fast Track','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CHLT','Chemical Lab Technologist','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CHMF','Chemical Eng Tech - Fast track','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CICE','Community Integration Coop Ed','SH','CERT2');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CLBT','Chemical Laboratory Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CMGT','Culinary Management','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('COHT','Constr and Hoisting Techniques','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CORC','Crane Oper, Rigg and Const Tec','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CPA','Computer Programmer Analyst','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CPGM','Computer Programmer','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CSK','Culinary Skills','SV','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CSTC','Computer Systems Technician','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CSTU','Computer System Tech - UOIT','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CSTY','Computer Systems Technology','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTA','Paralegal','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTAP','Para legal Grad Cert','SK','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTCC','Civil Eng Technician Co-op','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTMG','Cosmetic Techniques and Mgmt','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTSS','Court Support Services','SK','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CTYC','Civil Eng Technology Co-op','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CWBD','Contemporary Web Design','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CYCA','Child and Youth Care','SH','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('CYCB','Child and Youth Care - Brock','SH','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DAII','Dental Assisting (Levels I&II)','SH','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DATA','Data Analytics for Bus Dec Mak','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DCSB','Durham Catholic School Board','SO','NOCERT');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DDSB','Durham District School Board','SO','NOCERT');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DENT','Dental Hygiene','SH','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DGPH','Digital Photography','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DGVP','Digital Video Production','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DRA','Dental Reception and Admin','SH','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('DSWK','Developmental Services Worker','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ECE','Early Childhood Education','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('EETN','Electrical Engineer Technician','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ELEC','Electrical Techniques','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ELTC','Electronics Eng. Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ELTY','Electronics Eng. Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ELYF','Electronics Eng. Tech - Fast T','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('EMCC','9-1-1 Emerg & Call Centre Comm','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('EMSF','Emergency Services Fundamental','SK','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('EMTY','Electro-Mechanical Engin Tech','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ENVF','Environmental Tech -Fast track','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ENVT','Environmental Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ESMG','Esthetician - Spa Management','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FAD','Foundations in Art and Design','SM','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FINC','Business - Finance','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FINE','Fine Arts - Advanced','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FIT','Fitness and Health Promotion','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FLSC','Fire & Life Safety Sys Tech Co','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('FLST','Fire and Life Safety Sys Tech','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GART','Game - Art','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASA','General Arts & Science - Trent','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASB','General Arts & Science - Bus','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASC','General Arts & Science','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASF','Gen Art & Sci - UOIT Foren Psy','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASK','Gen Art & Sci - Sci & Eng Coll','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASS','Gen Art & Sci - Student Succes','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GAST','Gen Art & Sci - UOIT Lib Arts','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GASZ','Gen Art & Sci - UOIT Sci & Eng','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GDES','Graphic Design','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GDEV','Game Development','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('GFIT','Gas Technician 2','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HORT','Horticulture Technician','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HRM','Business - Human Resources','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HROC','Hosp-Hotel+Rest Op Mgmt Co-Op','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HROM','Hosp-Hotl and Rest Oper Manage','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HRTU','Business-Human Res UOIT Tran','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HSKL','Hospitality Skills','SV','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HURM','Human Resources Management','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('HVAC','Heat Vent & Air Cond Tech','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('IMDE','Interactive Media Design','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('INTB','International Business Managem','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('ISCN','Info Sys Security-Comp&Network','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('JOBM','Journal-Broad and Elect Media','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('JOMM','Journalism - Mass Media','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('KPRB','Kawartha Pineridge Sch Board','SO','NOCERT');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('LAW','Adv Law Enforce and Invest','SK','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('LCAD','Law Clerk Advanced','SK','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('LCAF','Law Clerk Adv - Fast Track','SK','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('LIBT','Library and Infor Technician','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MADR','Mediation/Alt Dispute Resolut','SK','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MAST','Massage Therapy','SH','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MBAD','Music Business Administration','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MBUS','Music Business Management','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('METC','Mechanical Eng. Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('METY','Mechanical Eng. Technology','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MFUN','Media Fundamentals','SM','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MKTU','Business - Marketing UOIT Tran','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MPLU','Mechanical Tech - Plumbing','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MPTN','Motive Power Techn Service&Mgt','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MRKG','Business - Marketing','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MTED','Mech Tech - Elevating Devices','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('MTMW','Mechanical Tec -Millwright','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('NDE','Mechanical Eng. Techn. - NDE','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('NDEF','Mec Eng Non-Dest Fast Track','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFAD','Office Administration','SX','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFCC','Office Admin - Legal Co-Op','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFEX','Office Admin - Executive','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFHF','Office Ad -Health (Fast Track)','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFHS','Office Admin - Health Services','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFLG','Office Admin - Legal','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OFRE','Office Admin. - Real Estate','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OPER','Business - Operations','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('OTPA','Occ Ther Assist&Physio Assist','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PADV','Paramedic - Advanced Care','SK','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PETN','Power Engineering Techn - 4th','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PFET','Pre-serv Firefighter - Ed & Tr','SK','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHGR','Photography','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHMF','Pharm & Food Sci - Fast track','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHRM','Pharmaceutical & Food Sci Tech','SQ','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHSC','Pre-Health Science - College','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHSO','Pre-Health Science - Online','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PHSU','Pre-Health Science-University','SY','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PNFL','Practical Nursing - Flex','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PNIE','Practical Nurse -Intl Educated','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PNII','Practical Nursing','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('POFD','Police Foundations','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PPC','Paramedic','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PROM','Project Management','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PSI','Protection, Sec and Investigat','SK','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PSWK','Personal Support Worker','SH','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PUBL','Public Relations','SM','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('PVNC','Peterborough Catholic School B','SO','NOCERT');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('RECL','Recreation and Leisure Service','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SBMT','Sport Business Management','SX','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SCOP','Bus-Supply Chain and Operation','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SCTU','Bus-Sup Chain and Oper- UOIT','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SEMC','Special Events Mgmt Co-Op','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SEMT','Special Events Management','SV','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SPAD','Sport Administration','SX','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SPMN','Sport Management','SX','3YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('SSWK','Social Service Worker','SH','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('TRDE','Trades Fundamentals','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('VICT','Victimology','SK','GRADC');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('VIPR','Video Production','SM','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('WATR','Water Quality Technician','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('WELD','Welding Techniques','SN','1YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('WETC','Welding Eng Technician Co-op','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('WETN','Welding Engineering Technician','SN','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('WTRC','Water Quality Technician Co-op','SQ','2YR');
INSERT INTO programs(ProgramCode, ProgramDescription, SchoolCode, DiplomaCode) VALUES('YJI','Youth Justice and Intervention','SK','GRADC');

SELECT * FROM programs;
