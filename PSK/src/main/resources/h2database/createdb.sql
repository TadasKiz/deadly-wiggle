CREATE TABLE IF NOT EXISTS COMPANY
(
	ID INTEGER NOT NULL IDENTITY,
	TITLE            VARCHAR(50),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS EMPLOYEE
(
	ID INTEGER NOT NULL IDENTITY,
	FIRST_NAME       VARCHAR(20),
	LAST_NAME        VARCHAR(20),
	COMPANY_ID       INTEGER,
	REGISTRATION_NO  VARCHAR(20),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID),
	FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY (ID)
);

CREATE TABLE IF NOT EXISTS DEED
(
	ID INTEGER NOT NULL IDENTITY,
	NAME             VARCHAR(50),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS EMPLOYEE_DEED
(
	EMPLOYEE_ID      INTEGER,
	DEED_ID       INTEGER,
	PRIMARY KEY (EMPLOYEE_ID, DEED_ID),
	FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID),
	FOREIGN KEY (DEED_ID) REFERENCES DEED (ID)
);
