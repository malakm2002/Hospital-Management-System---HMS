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
    specialty VARCHAR(50) NOT NULL,
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

CREATE TABLE IF NOT EXISTS PatientRecord (
	recordID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    gender CHAR NOT NULL,
    address VARCHAR(30),
    phoneNumber INT,
    admissionDate DATETIME,
    dischargeDate DATETIME,
    patientID INT  ,
    PRIMARY KEY (recordID),
    FOREIGN KEY(patientID) REFERENCES PATIENT(patientID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS StaffRecord (
	recordID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    gender CHAR NOT NULL,
    address VARCHAR(30),
    phoneNumber INT,
    startDate DATETIME,
    endDate DATETIME,
    staffID INT  ,
    PRIMARY KEY (recordID),
    FOREIGN KEY(staffID) REFERENCES STAFF(staffID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS TREAT (
	patientID INT NOT NULL,
    doctorID INT NOT NULL,
    medicineID INT,
    FOREIGN KEY (patientID) REFERENCES PATIENT (patientID) ON DELETE CASCADE,
    FOREIGN KEY (doctorID) REFERENCES DOCTOR (doctorID) ON DELETE CASCADE,
    FOREIGN KEY (medicineID) REFERENCES MEDICINE (medicineID) ON DELETE CASCADE
);

DROP Procedure IF EXISTS InsertNurse;
DELIMITER %%
CREATE PROCEDURE InsertNurse (
	IN jobType VARCHAR(20),
    IN supervisorID INT
)
BEGIN
	INSERT INTO STAFF (jobType, supervisorID) VALUES (jobType, supervisorID);
    INSERT INTO NURSE VALUES (LAST_INSERT_ID());
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertJanitor;
DELIMITER %%
CREATE PROCEDURE InsertJanitor (
	IN jobType VARCHAR(20),
    IN supervisorID INT
)
BEGIN
	INSERT INTO STAFF (jobType, supervisorID) VALUES (jobType, supervisorID);
    INSERT INTO JANITOR VALUES (LAST_INSERT_ID());
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertCashier;
DELIMITER %%
CREATE PROCEDURE InsertCashier (
	IN jobType VARCHAR(20),
    IN supervisorID INT
)
BEGIN
	INSERT INTO STAFF (jobType, supervisorID) VALUES (jobType, supervisorID);
    INSERT INTO CASHIER VALUES (LAST_INSERT_ID());
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertDoctor;
DELIMITER %%
CREATE PROCEDURE InsertDoctor (
	IN jobType VARCHAR(20),
    IN supervisorID INT,
    IN specialty VARCHAR(20)
)
BEGIN
	INSERT INTO STAFF (jobType, supervisorID) VALUES (jobType, supervisorID);
    INSERT INTO DOCTOR VALUES (LAST_INSERT_ID(), specialty);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertRoom;
DELIMITER %%
CREATE PROCEDURE InsertRoom (
	IN roomType VARCHAR(20),
    IN nurseID INT,
    IN janitorID INT
)
BEGIN
	INSERT INTO ROOM VALUES (LAST_INSERT_ID(),roomType,nurseID,janitorID);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertBill;
DELIMITER %%
CREATE PROCEDURE InsertBill (
	IN billStatus VARCHAR(20),
	IN field VARCHAR(20),
    IN charge INT,
    IN cashierID INT
)
BEGIN
	INSERT INTO BILL VALUES (LAST_INSERT_ID(),billStatus,field,charge,cashierID);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertPatient;
DELIMITER %%
CREATE PROCEDURE InsertPatient (
	IN diagnosis VARCHAR(20),
    IN roomID INT
)
BEGIN
	INSERT INTO PATIENT VALUES (LAST_INSERT_ID(),diagnosis,roomID);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertMedicine;
DELIMITER %%
CREATE PROCEDURE InsertMedicine (
	IN medicineName VARCHAR(20),
    IN price INT,
	IN quantity INT
)
BEGIN
	INSERT INTO MEDICINE VALUES (LAST_INSERT_ID(),medicineName,price,quantity);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertStaffRecord;
DELIMITER %%
CREATE PROCEDURE InsertStaffRecord (
	IN firstName VARCHAR(20),
	IN lastName VARCHAR(20),
    IN gender CHAR,
	IN address VARCHAR(30),
    IN phoneNumber INT,
    IN admissionDate DATETIME,
     IN dischargeDate DATETIME,
     IN staffID INT)
BEGIN
	INSERT INTO staffRecord VALUES (LAST_INSERT_ID(),firstName,lastName,gender,address,phoneNumber,admissionDate,dischargeDate,staffID);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertPatientRecord;
DELIMITER %%
CREATE PROCEDURE InsertPatientRecord (
	IN firstName VARCHAR(20),
	IN lastName VARCHAR(20),
    IN gender CHAR,
	IN address VARCHAR(30),
    IN phoneNumber INT,
    IN admissionDate DATETIME,
     IN dischargeDate DATETIME,
     IN patientID INT)
BEGIN
	INSERT INTO staffRecord VALUES (LAST_INSERT_ID(),firstName,lastName,gender,address,phoneNumber,admissionDate,dischargeDate,patientID);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertTreat;
DELIMITER %%
CREATE PROCEDURE InsertTreat (
    IN patientID INT,
	IN doctorID INT,
    	IN medicineID INT

)
BEGIN
	INSERT INTO TREAT VALUES (patientID,doctorID,medicineID);
END %%
DELIMITER ;


DROP Procedure IF EXISTS DeleteNurse;
DELIMITER %%
CREATE PROCEDURE DeleteNurse (
	ID INT
)
BEGIN
    DELETE FROM STAFF WHERE staffID = ID;
    DELETE FROM NURSE WHERE nurseID = ID;
    DELETE FROM staffRecord WHERE staffID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteJanitor;
DELIMITER %%
CREATE PROCEDURE DeleteJanitor (
	ID INT
)
BEGIN
	DELETE FROM JANITOR WHERE janitorID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
   DELETE FROM staffRecord WHERE staffID = ID;

END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteCashier;
DELIMITER %%
CREATE PROCEDURE DeleteCashier (
	ID INT   
)
BEGIN
	DELETE FROM CASHIER WHERE cashierID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
    DELETE FROM staffRecord WHERE staffID=ID;

END %%
DELIMITER ;


DROP Procedure IF EXISTS DeleteDoctor;
DELIMITER %%
CREATE PROCEDURE DeleteDoctor (
	ID INT
)
BEGIN
	DELETE FROM DOCTOR WHERE doctorID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
   DELETE FROM staffRecord WHERE staffID = ID;

END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteRoom;
DELIMITER %%
CREATE PROCEDURE DeleteRoom (
	ID INT
)
BEGIN
	DELETE FROM ROOM WHERE roomID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteBill;
DELIMITER %%
CREATE PROCEDURE DeleteBill (
	ID INT
)
BEGIN
	DELETE FROM BILL WHERE billID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeletePatient;
DELIMITER %%
CREATE PROCEDURE DeletePatient (
	ID INT
)
BEGIN
	DELETE FROM PATIENT WHERE patientID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteMedicine;
DELIMITER %%
CREATE PROCEDURE DeleteMedicine (
	ID INT
)
BEGIN
	DELETE FROM MEDICINE WHERE medicineID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteStaffRecord;
DELIMITER %%
CREATE PROCEDURE DeleteStaffRecord (
	ID INT
)
BEGIN
	DELETE FROM staffRecord WHERE recordID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeletePatientRecord;
DELIMITER %%
CREATE PROCEDURE DeletePatientRecord (
	ID INT
)
BEGIN
	DELETE FROM patientRecord WHERE recordID = ID;
END %%
DELIMITER ;
-- Views
CREATE VIEW staffInfo as select * from staff natural join staffrecord;
CREATE VIEW doctorInfo as select * from staff join doctor on staffID=doctorID;
CREATE VIEW patientInfo as select * from patient natural join patientrecord;
-- Population
 INSERT INTO STAFF VALUES -- supervisors
 	(1, 'Dean', null),
     (2, 'Adminstrator', 1);

CALL InsertNurse('Cardiac nurse', 1); -- 3
CALL InsertNurse('Orthopedic nurse', 1); -- 4
CALL InsertNurse('Optics nurse', 1); -- 5
CALL InsertNurse('Anesthetist nurse', 1); -- 6
CALL InsertNurse('Geriatrics nurse', 1); -- 7
CALL InsertNurse('Pediatrics nurse', 1); -- 8
CALL InsertJanitor('Post-surgery cleaner', 2); -- 9
CALL InsertJanitor('Room cleaner', 2); -- 10
CALL InsertJanitor('Equipment cleaner', 2); -- 11
CALL InsertCashier('Reception cashier 1', 2); -- 12
CALL InsertCashier('Reception cashier 2', 2); -- 13
CALL InsertCashier('Reception cashier 3', 2); -- 14
CALL InsertDoctor('Surgeon', 1, 'Cardiac surgeon'); -- 15
CALL InsertDoctor('Surgeon', 1, 'Neural surgeon'); -- 16
CALL InsertDoctor('Surgeon', 1, 'General surgeon'); -- 17
CALL InsertDoctor('Specialist', 1, 'Geriatric specialist'); -- 18
CALL InsertDoctor('Specialist', 1, 'Pediatric specialist'); -- 19
CALL InsertDoctor('Specialist', 1, 'Orthodontist'); -- 20

-- POPULATE ROOM
INSERT INTO ROOM (roomType, nurseID, janitorID) VALUES
	('Surgery room 1A', 3, 11), -- 1
    ('Surgery room 1B', 3, 11), -- 2
    ('Surgery room 2A', 6, 11), -- 3
    ('Surgery room 2B', 6, 11), -- 4
    ('Care room 1A', 7, 10), -- 5
    ('Care room 1B', 7, 10), -- 6
    ('Care room 2A', 8, 10), -- 7
    ('Care room 2A', 8, 10), -- 8
    ('ICU A', 4, 9), -- 9
    ('ICU B', 5, 9); -- 10

-- POPULATE BILL
INSERT INTO BILL (billStatus, field, charge, cashierID) VALUES
	('Pending', 'Cardiac surgery', 600, 12), -- 1
    ('Pending', 'Optical surgery', 400, 12), -- 2
    ('Pending', 'Neural surgery', 1000, 12), -- 3
    ('Pending', 'Optical surgery', 450, 13), -- 4
    ('Paid', 'Cardiac surgery', 610, 13), -- 5
    ('Paid', 'Check-up', 80, 13), -- 6
    ('Paid', 'PhsyioTherapy', 50, 14), -- 7
    ('Paid', 'Check-up', 30, 14); -- 8

-- POPULATE PATIENT
INSERT INTO PATIENT (diagnosis, roomID) VALUES 
	('Heart failure', 1), -- 1
    ('Car crash', 5), -- 2
    ('Car crash', 6), -- 3
    ('Severe covid', 9), -- 4
    ('Cardiac arrest', 2), -- 5
    ('Cardiac arrest', 10), -- 6
    ('Broken arm', 7), -- 7
    ('Broken leg', 8); -- 8

-- POPULATE MEDICINE
INSERT INTO MEDICINE (medicineName, price, quantity) VALUES
	('Panadol', 5, 40), -- 1
    ('Remebo', 17, 22), -- 2
    ('Mebo', 23, 14), -- 3
    ('Atarax', 30, 9), -- 4
    ('Aspicot', 8, 30), -- 5
    ('Aspirin', 3, 47); -- 6

--- POPULATE PATIENT RECORD
INSERT INTO PatientRecord (firstName, lastName, gender, address, phoneNumber, admissionDate, dischargeDate, patientID) VALUES
	('Charles', 'Dickens', 'M', 'London', 08774655, '2022-04-10 11:23:14', '2022-06-11 11:17:46', 4), -- 1
    ('Tala', 'Mohsen', 'F', 'Ras Beirut', 03445945, '2022-06-12 09:16:17', '2022-08-11 15:54:25', 5), -- 2
    ('Zeina', 'Breish', 'F', 'Achrafieh', 01337465, '2022-02-24 08:11:29', '2022-03-11 18:26:26', 3); -- 3

-- POPULATE STAFF RECORD
INSERT INTO StaffRecord (firstName, lastName, gender, address, phoneNumber, startDate, endDate, staffID) VALUES
    ('Charbel', 'Manara', 'M', 'Aley', 05987758, '2022-04-10 11:23:14', '2022-06-11 11:17:46', 3), -- 1
    ('Jay', 'Z', 'M', 'USA', 01232487, '2022-06-12 09:16:17', '2022-08-11 15:54:25', 2), -- 2
    ('Manar', 'Ghobeiri', 'F', 'Baakline', 25667465, '2022-02-24 08:11:29', '2022-03-11 18:26:26', 1), -- 3
    ('Ali', 'Hamad', 'M', 'Aley', 05987758, '2022-02-24 08:11:29', '2022-03-11 18:26:26', 15); -- 4

-- POPULATE TREAT
INSERT INTO TREAT VALUES 
	(1, 15, 1),
    (2, 16, 2),
    (3, 17, 3),
    (4, 18, 4),
    (5, 19, 5),
    (6, 20, 6);