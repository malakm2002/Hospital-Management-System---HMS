USE HMS;

-- POPULATE STAFF
-- INSERT INTO STAFF VALUES -- supervisors
-- 	(1, 'Dean', null),
--     (2, 'Adminstrator', 1);

CALL InsertNurse('Cardiac nurse', 1);
CALL InsertNurse('Anesthetist nurse', 1);
CALL InsertJanitor('Post-surgery cleaner', 2);
CALL InsertCashier('Reception cashier', 2);
CALL InsertDoctor('Surgeon', 1, 'Cardiac surgeon');
CALL InsertDoctor('Specialist', 1, 'Pediatric specialist');

-- POPULATE ROOM
INSERT INTO ROOM (roomType, nurseID, janitorID) VALUES
	('Surgery room', 3, 5),
    ('ICU', 4, 5);

-- POPULATE BILL
INSERT INTO BILL (billStatus, field, charge, cashierID) VALUES
	('Pending', 'Surgery', 200, 6),
    ('Paid', 'Check-up', 30, 6);

-- POPULATE PATIENT
INSERT INTO PATIENT (diagnosis, roomID) VALUES 
	('Heart failure', 1),
    ('Broken leg', 2);

-- POPULATE MEDICINE
INSERT INTO MEDICINE (medicineName, price, quantity) VALUES
	('Mebo', 9, 30),
    ('Aspirin', 3, 50);

-- POPULATE RECORD
INSERT INTO RECORD (firstName, lastName, gender, address, phoneNumber, admissionDate, dischargeDate, patientID, staffID) VALUES
	('Mahmoud', 'Bdeir', 'M', 'MiAmI', 08774655, '2022-04-10 12:00:00', '2022-04-11 11:34:29', 2, 1),
    ('Manar', 'Ghobeiri', 'F', 'Beirut', 03994857, '2021-09-30 06:23:55', '2021-10-4 12:44:19', 1, 8);

-- POPULATE TREAT
INSERT INTO TREAT VALUES 
	(1, 8, 1),
    (2, 7, 2);
