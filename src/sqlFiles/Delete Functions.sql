DROP Procedure IF EXISTS DeleteNurse;
DELIMITER %%
CREATE PROCEDURE DeleteNurse (
	ID INT, 
    FN VARCHAR(20),
    LN VARCHAR(20)
)
BEGIN
    DELETE FROM STAFF WHERE staffID = ID;
<<<<<<< HEAD
    DELETE FROM staffRecord WHERE isStaff = true AND isPatient=false AND staffID=ID AND firstName = FN AND lastName=LN;

=======
    DELETE FROM NURSE WHERE nurseID = ID;
    DELETE FROM staffRecord WHERE staffID = ID;
>>>>>>> bccdfa0a1639d9ee51542d0a4786b48830e29d92
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteJanitor;
DELIMITER %%
CREATE PROCEDURE DeleteJanitor (
	ID INT, 
    FN VARCHAR(20),
    LN VARCHAR(20)
)
BEGIN
	DELETE FROM JANITOR WHERE janitorID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
<<<<<<< HEAD
    DELETE FROM staffRecord WHERE isStaff = true AND isPatient=false AND staffID=ID AND firstName = FN AND lastName=LN;
=======
   DELETE FROM staffRecord WHERE staffID = ID;
>>>>>>> bccdfa0a1639d9ee51542d0a4786b48830e29d92

END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteCashier;
DELIMITER %%
CREATE PROCEDURE DeleteCashier (
<<<<<<< HEAD
	ID INT, 
    FN VARCHAR(20),
    LN VARCHAR(20)
=======
	ID INT   
>>>>>>> bccdfa0a1639d9ee51542d0a4786b48830e29d92
)
BEGIN
	DELETE FROM CASHIER WHERE cashierID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
<<<<<<< HEAD
    DELETE FROM staffRecord WHERE isStaff = true AND isPatient=false AND staffID=ID AND firstName = FN AND lastName=LN;
=======
    DELETE FROM staffRecord WHERE staffID=ID;
>>>>>>> bccdfa0a1639d9ee51542d0a4786b48830e29d92

END %%
DELIMITER ;


DROP Procedure IF EXISTS DeleteDoctor;
DELIMITER %%
CREATE PROCEDURE DeleteDoctor (
	ID INT, 
    FN VARCHAR(20),
    LN VARCHAR(20)
)
BEGIN
	DELETE FROM DOCTOR WHERE doctorID = ID;
    DELETE FROM STAFF WHERE staffID = ID;
<<<<<<< HEAD
    DELETE FROM staffRecord WHERE isStaff = true AND isPatient=false AND staffID=ID AND firstName = FN AND lastName=LN;
=======
   DELETE FROM staffRecord WHERE staffID = ID;
>>>>>>> bccdfa0a1639d9ee51542d0a4786b48830e29d92

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
    DELETE FROM PATIENTRECORD WHERE patientID = ID;
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

DROP Procedure IF EXISTS DeletePatientRecord;
DELIMITER %%
CREATE PROCEDURE DeletePatientRecord (
	ID INT
)
BEGIN
	DELETE FROM PATIENTRECORD WHERE recordID = ID;
END %%
DELIMITER ;

DROP Procedure IF EXISTS DeleteStaffRecord;
DELIMITER %%
CREATE PROCEDURE DeleteStaffRecord (
	ID INT
)
BEGIN
	DELETE FROM STAFFRECORD WHERE recordID = ID;
END %%
DELIMITER ;
