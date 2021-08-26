DROP TABLE Grupa CASCADE CONSTRAINTS;
DROP TABLE Nauczyciel CASCADE CONSTRAINTS;
DROP TABLE Przedmiot CASCADE CONSTRAINTS;
DROP TABLE Pos CASCADE CONSTRAINTS;
DROP TABLE Student CASCADE CONSTRAINTS;
DROP TABLE Ocena CASCADE CONSTRAINTS;

DROP SEQUENCE GrupaSeq;
DROP SEQUENCE NauczycielSeq;
DROP SEQUENCE PrzedmiotSeq;
DROP SEQUENCE StudentSeq;
DROP SEQUENCE OcenaSeq;
DROP SEQUENCE PosSeq;

CREATE TABLE Grupa (
  idGrupa INTEGER PRIMARY KEY,
  Nazwa_grupy VARCHAR(255) NOT NULL
);

CREATE TABLE Nauczyciel (
  idNauczyciel INTEGER PRIMARY KEY,
  Imie VARCHAR(255)NOT NULL,
  Nazwisko VARCHAR(255)NOT NULL,
  Stopien VARCHAR(255)NOT NULL,
  Login VARCHAR(255)UNIQUE NOT NULL,
  Haslo VARCHAR(255)NOT NULL
);


CREATE TABLE Przedmiot (
  idPrzedmiot INTEGER PRIMARY KEY,
  Nazwa VARCHAR(255) NOT NULL,
  Typ VARCHAR(255) NOT NULL
);

CREATE TABLE Pos(
  idPos INTEGER PRIMARY KEY,
  idNauczyciel INTEGER, 
  idPrzedmiot INTEGER, 	 
  FOREIGN KEY(idNauczyciel) References Nauczyciel(idNauczyciel),
  FOREIGN KEY(idPrzedmiot) References Przedmiot(idPrzedmiot)
);

CREATE TABLE Student (
  idStudent INTEGER Primary KEY,
  idGrupa INTEGER,
  Imie VARCHAR(255) NOT NULL,
  Nazwisko VARCHAR(255) NOT NULL,
  Pesel VARCHAR(255) NOT NULL,
  Login VARCHAR(255) UNIQUE NOT NULL,
  Haslo VARCHAR(255) NOT NULL,
  FOREIGN KEY(idGrupa) References Grupa(idGrupa)
);


CREATE TABLE Ocena (
  idOcena INTEGER PRIMARY KEY,
  idPos INTEGER, 
  idStudent INTEGER, 
  Waga INTEGER NOT NULL,
  Ocena FLOAT NOT NULL,
  FOREIGN KEY(idPos)References Pos(idPos),
  FOREIGN KEY(idStudent)References Student(idStudent)
);

Create sequence GrupaSeq
INCREMENT BY 1
START WITH 1;

Create sequence NauczycielSeq
INCREMENT BY 1
START WITH 1;

Create sequence PrzedmiotSeq
INCREMENT BY 1
START WITH 1;

Create sequence StudentSeq
INCREMENT BY 1
START WITH 1;

Create sequence OcenaSeq
INCREMENT BY 1
START WITH 1;

Create sequence PosSeq
INCREMENT BY 1
START WITH 1;
