use hms;

-- SELECT PATIENTRECORD.patientID FROM PATIENTRECORD WHERE PATIENTRECORD.firstName = 'Charles' AND PATIENTRECORD.lastName = 'Dickens'

SELECT firstName, lastName, phoneNumber, address, admissionDate, dischargeDate FROM PATIENTRECORD WHERE PATIENTRECORD.firstName = 'Charles' AND PATIENTRECORD.lastName = 'Dickens'