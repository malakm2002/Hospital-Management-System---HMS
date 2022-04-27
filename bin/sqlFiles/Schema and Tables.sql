CREATE SCHEMA IF NOT EXISTS HMS; -- Hospital Management System

USE HMS;

CREATE TABLE IF NOT EXISTS STAFF (
	staffID INT NOT NULL AUTO_INCREMENT,
    jobType VARCHAR(50) NOT NULL,
    supervisorID INT,
    PRIMARY KEY (staffID),
    FOREIGN KEY (supervisorID) REFERENCES STAFF (staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS NURSE (
	nurseID INT NOT NULL,
    PRIMARY KEY (nurseID),
    FOREIGN KEY (nurseID) REFERENCES STAFF (staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS JANITOR (
	janitorID INT NOT NULL,
    PRIMARY KEY (janitorID),
    FOREIGN KEY (janitorID) REFERENCES STAFF (staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS CASHIER (
	cashierID INT NOT NULL,
    PRIMARY KEY (cashierID),
    FOREIGN KEY (cashierID) REFERENCES STAFF (staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS DOCTOR (
	doctorID INT NOT NULL,
    specialty VARCHAR(20) NOT NULL,
    PRIMARY KEY (doctorID),
    FOREIGN KEY (doctorID) REFERENCES STAFF (staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ROOM (
	roomID INT NOT NULL AUTO_INCREMENT,
    roomType VARCHAR(20) NOT NULL,
    nurseID INT NOT NULL,
    janitorID INT NOT NULL,
    PRIMARY KEY (roomID),
    FOREIGN KEY (nurseID) REFERENCES NURSE (nurseID) ON DELETE CASCADE,
    FOREIGN KEY (janitorID) REFERENCES JANITOR (janitorID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS BILL (
	billID INT NOT NULL AUTO_INCREMENT,
    billStatus VARCHAR(20) NOT NULL,
    field VARCHAR(20) NOT NULL,
    charge INT NOT NULL,
    cashierID INT NOT NULL,
    PRIMARY KEY (billID),
    FOREIGN KEY (cashierID) REFERENCES CASHIER (cashierID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PATIENT (
	patientID INT NOT NULL AUTO_INCREMENT,
    diagnosis VARCHAR(20) NOT NULL,
    roomID INT NOT NULL,
    PRIMARY KEY (patientID),
    FOREIGN KEY (roomID) REFERENCES ROOM (roomID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS MEDICINE (
	medicineID INT NOT NULL AUTO_INCREMENT,
    medicineName VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (medicineID)
);

CREATE TABLE IF NOT EXISTS RECORD (
	recordID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    gender CHAR NOT NULL,
    address VARCHAR(30),
    phoneNumber INT,
    admissionDate DATETIME,
    dischargeDate DATETIME,
    isPatient BOOLEAN  ,
    isStaff BOOLEAN ,
    PRIMARY KEY (recordID),
    
);

CREATE TABLE IF NOT EXISTS TREAT (
	patientID INT NOT NULL,
    doctorID INT NOT NULL,
    medicineID INT,
    FOREIGN KEY (patientID) REFERENCES PATIENT (patientID) ON DELETE CASCADE,
    FOREIGN KEY (doctorID) REFERENCES DOCTOR (doctorID) ON DELETE CASCADE,
    FOREIGN KEY (medicineID) REFERENCES MEDICINE (medicineID) ON DELETE CASCADE
);
