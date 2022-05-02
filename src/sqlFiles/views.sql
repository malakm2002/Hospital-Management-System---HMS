-- combines STAFF (job type and supervisor) with personal information from STAFFRECORD
CREATE VIEW staffInfo AS SELECT * FROM staff NATURAL JOIN staffrecord;

-- selects only the doctors among the STAFF
CREATE VIEW doctorInfo AS SELECT * FROM staff JOIN doctor ON staffID=doctorID;

-- combines PATIENT (diagnosis and room) with personal information from PATIENTRECORD
CREATE VIEW patientInfo AS SELECT * FROM patient NATURAL JOIN patientrecord;
