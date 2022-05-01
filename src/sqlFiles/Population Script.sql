USE HMS;

-- POPULATE STAFF
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

-- POPULATE PATIENT RECORD
INSERT INTO PatientRecord (firstName, lastName, gender, address, phoneNumber, admissionDate, dischargeDate, patientID) VALUES
	('Charles', 'Dickens', 'M', 'London', 08774655, '2022-04-10 11:23:14', '2022-06-11 11:17:46', 4), -- 1
    ('Tala', 'Mohsen', 'F', 'Ras Beirut', 03445945, '2022-06-12 09:16:17', '2022-08-11 15:54:25', 5), -- 2
    ('Zeina', 'Breish', 'F', 'Achrafieh', 01337465, '2022-02-24 08:11:29', '2022-03-11 18:26:26', 3); -- 3

-- POPULATE STAFF RECORD
INSERT INTO StaffRecord (firstName, lastName, gender, address, phoneNumber, startDate, endDate, staffID) VALUES
    ('Charbel', 'Manara', 'M', 'Aley', 05987758, '2022-04-10 11:23:14', '2022-06-11 11:17:46', 2), -- 1
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
