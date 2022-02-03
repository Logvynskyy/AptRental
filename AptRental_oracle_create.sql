CREATE TABLE Users (
	ID NUMBER(10, 0) NOT NULL,
	Name VARCHAR2(30) UNIQUE NOT NULL,
	Password VARCHAR2(255) NOT NULL,
	Phone_number VARCHAR2(30) NOT NULL,
	constraint USERS_PK PRIMARY KEY (ID));

CREATE sequence USERS_ID_SEQ;

CREATE trigger BI_USERS_ID
  before insert on Users
  for each row
begin
  select USERS_ID_SEQ.nextval into :NEW.ID from dual;
end;

/
CREATE TABLE Apartments (
	ID NUMBER(10, 0) NOT NULL,
	Name VARCHAR2(30) NOT NULL,
	Description VARCHAR2(4000),
	Price FLOAT NOT NULL,
	OwnerID NUMBER(10, 0) NOT NULL,
	constraint APARTMENTS_PK PRIMARY KEY (ID));

CREATE sequence APARTMENTS_ID_SEQ;

CREATE trigger BI_APARTMENTS_ID
  before insert on Apartments
  for each row
begin
  select APARTMENTS_ID_SEQ.nextval into :NEW.ID from dual;
end;

/
CREATE TABLE Images (
	ID NUMBER(10, 0) NOT NULL,
	Image VARCHAR2(4000),
	AptID NUMBER(10, 0) NOT NULL,
	constraint IMAGES_PK PRIMARY KEY (ID));

CREATE sequence IMAGES_ID_SEQ;

CREATE trigger BI_IMAGES_ID
  before insert on Images
  for each row
begin
  select IMAGES_ID_SEQ.nextval into :NEW.ID from dual;
end;

/
CREATE TABLE Keywords (
	ID NUMBER(10, 0) NOT NULL,
	Keyword VARCHAR2(30),
	AptID NUMBER(10, 0) NOT NULL,
	constraint KEYWORDS_PK PRIMARY KEY (ID));

CREATE sequence KEYWORDS_ID_SEQ;

CREATE trigger BI_KEYWORDS_ID
  before insert on Keywords
  for each row
begin
  select KEYWORDS_ID_SEQ.nextval into :NEW.ID from dual;
end;

/
CREATE TABLE Favourites (
	ID NUMBER(10, 0) NOT NULL,
	AptID NUMBER(10, 0) NOT NULL,
	UserID NUMBER(10, 0) NOT NULL,
	constraint FAVOURITES_PK PRIMARY KEY (ID));

CREATE sequence FAVOURITES_ID_SEQ;

CREATE trigger BI_FAVOURITES_ID
  before insert on Favourites
  for each row
begin
  select FAVOURITES_ID_SEQ.nextval into :NEW.ID from dual;
end;

/

ALTER TABLE Apartments ADD CONSTRAINT Apartments_fk0 FOREIGN KEY (OwnerID) REFERENCES Users(ID);

ALTER TABLE Images ADD CONSTRAINT Images_fk0 FOREIGN KEY (AptID) REFERENCES Apartments(ID);

ALTER TABLE Keywords ADD CONSTRAINT Keywords_fk0 FOREIGN KEY (AptID) REFERENCES Apartments(ID);

ALTER TABLE Favourites ADD CONSTRAINT Favourites_fk0 FOREIGN KEY (AptID) REFERENCES Apartments(ID);
ALTER TABLE Favourites ADD CONSTRAINT Favourites_fk1 FOREIGN KEY (UserID) REFERENCES Users(ID);

