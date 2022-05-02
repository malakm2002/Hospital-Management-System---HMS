CREATE VIEW staffInfo as select * from staff natural join staffrecord;
CREATE VIEW doctorInfo as select * from staff join doctor on staffID=doctorID;
CREATE VIEW patientInfo as select * from patient natural join patientrecord;
