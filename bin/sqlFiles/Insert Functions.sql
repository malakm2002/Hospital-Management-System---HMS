USE HMS;

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
	INSERT INTO MEDICINE VALUES (LAST_INSERT_ID(),medicineName,price,diagnosis);
END %%
DELIMITER ;

DROP Procedure IF EXISTS InsertRecord;
DELIMITER %%
CREATE PROCEDURE InsertRecord (
	IN firstName VARCHAR(20),
	IN lastName VARCHAR(20),
    IN gender CHAR,
	IN address VARCHAR(30),
    IN phoneNumber INT,
    IN admissionDate DATETIME,
     IN dischargeDate DATETIME,
     IN patientID INT,
     IN staffID INT
)
BEGIN
	INSERT INTO RECORD VALUES (LAST_INSERT_ID(),firstName,lastName,gender,address,phoneNumber,admissionDate,dischargeDate,patientID,staffID);
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
