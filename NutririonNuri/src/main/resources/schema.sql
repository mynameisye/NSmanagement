DROP SEQUENCE DiseaseId;

CREATE SEQUENCE DiseaseId
	INCREMENT BY 1
	START WITH 1;

DROP SEQUENCE MemId;

CREATE SEQUENCE MemId
	INCREMENT BY 1
	START WITH 1;

DROP SEQUENCE ReviewId;

CREATE SEQUENCE ReviewId
	INCREMENT BY 1
	START WITH 1;

DROP SEQUENCE SupId;

CREATE SEQUENCE SupId
	INCREMENT BY 1
	START WITH 1;

DROP TABLE Disease CASCADE CONSTRAINTS PURGE;

DROP TABLE TakingSupplement CASCADE CONSTRAINTS PURGE;

DROP TABLE MemberInfo CASCADE CONSTRAINTS PURGE;

DROP TABLE Review CASCADE CONSTRAINTS PURGE;

DROP TABLE Supplement CASCADE CONSTRAINTS PURGE;

DROP TABLE Memeber CASCADE CONSTRAINTS PURGE;

CREATE TABLE Memeber
(
	MemId                integer  NOT NULL ,
	Name                 VARCHAR2(15)  NOT NULL ,
	Gender               char(1)  NULL ,
	Phone                CHAR(18)  NULL ,
	Email                VARCHAR2(15)  NULL ,
	Id                   VARCHAR2(15)  NOT NULL ,
	Pwd                  VARCHAR2(15)  NOT NULL 
);

CREATE UNIQUE INDEX XPKMemeber ON Memeber
(MemId   ASC);

ALTER TABLE Memeber
	ADD CONSTRAINT  XPKMemeber PRIMARY KEY (MemId);

CREATE TABLE MemberInfo
(
	Height               float  NULL ,
	Weight               float  NULL ,
	Smoke                VARCHAR2(1)  NULL ,
	Alchol               VARCHAR2(1)  NULL ,
	Pregnant             VARCHAR2(1)  NULL ,
	Medicine             VARCHAR2(15)  NULL ,
	Supplement           VARCHAR2(15)  NULL ,
	PrefIngredient       VARCHAR2(15)  NULL ,
	MemId                integer  NOT NULL 
);

CREATE UNIQUE INDEX XPKMemberInfo ON MemberInfo
(MemId   ASC);

ALTER TABLE MemberInfo
	ADD CONSTRAINT  XPKMemberInfo PRIMARY KEY (MemId);

CREATE TABLE Supplement
(
	SupId                integer  NOT NULL ,
	Name                 VARCHAR2(15)  NOT NULL ,
	Effect               VARCHAR2(30)  NULL ,
	Ingredient           VARCHAR2(15)  NULL ,
	Manufacturer         VARCHAR2(15)  NULL ,
	Precaution           VARCHAR2(30)  NULL ,
	Rate                 float  NOT NULL 
);

CREATE UNIQUE INDEX XPKSupplement ON Supplement
(SupId   ASC);

ALTER TABLE Supplement
	ADD CONSTRAINT  XPKSupplement PRIMARY KEY (SupId);

CREATE TABLE TakingSupplement
(
	SupId                integer  NOT NULL ,
	PreCaution           VARCHAR2(30)  NULL ,
	IntakeTime           TIMESTAMP  NULL ,
	IntakeAmount         integer  NULL ,
	IntakeInform         integer  NOT NULL ,
	Rate                 float  NULL ,
	MemId                integer  NOT NULL 
);

CREATE UNIQUE INDEX XPKMemberInfo_Supplement ON TakingSupplement
(IntakeInform   ASC,MemId   ASC);

ALTER TABLE TakingSupplement
	ADD CONSTRAINT  XPKMemberInfo_Supplement PRIMARY KEY (IntakeInform,MemId);

CREATE TABLE Review
(
	Title                VARCHAR2(15)  NOT NULL ,
	Posted               date  NULL ,
	ReviewId             CHAR(18)  NOT NULL ,
	SupId                integer  NOT NULL ,
	MemId                integer  NOT NULL 
);

CREATE UNIQUE INDEX XPKReview ON Review
(ReviewId   ASC);

ALTER TABLE Review
	ADD CONSTRAINT  XPKReview PRIMARY KEY (ReviewId);

CREATE TABLE Disease
(
	DiseaseId            integer  NOT NULL ,
	DiseaseName          CHAR(18)  NULL ,
	MemId                integer  NOT NULL 
);

CREATE UNIQUE INDEX XPKDisease ON Disease
(DiseaseId   ASC,MemId   ASC);

ALTER TABLE Disease
	ADD CONSTRAINT  XPKDisease PRIMARY KEY (DiseaseId,MemId);

ALTER TABLE MemberInfo
	ADD (
CONSTRAINT R_1 FOREIGN KEY (MemId) REFERENCES Memeber (MemId));

ALTER TABLE TakingSupplement
	ADD (
CONSTRAINT R_8 FOREIGN KEY (SupId) REFERENCES Supplement (SupId));

ALTER TABLE TakingSupplement
	ADD (
CONSTRAINT R_10 FOREIGN KEY (MemId) REFERENCES Memeber (MemId));

ALTER TABLE TakingSupplement
	ADD (
CONSTRAINT R_7 FOREIGN KEY (MemId) REFERENCES MemberInfo (MemId));

ALTER TABLE Review
	ADD (
CONSTRAINT R_3 FOREIGN KEY (MemId) REFERENCES Memeber (MemId));

ALTER TABLE Review
	ADD (
CONSTRAINT R_5 FOREIGN KEY (SupId) REFERENCES Supplement (SupId));

ALTER TABLE Disease
	ADD (
CONSTRAINT R_12 FOREIGN KEY (MemId) REFERENCES MemberInfo (MemId));

COMMIT;