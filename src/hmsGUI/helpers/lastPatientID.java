package hmsGUI.helpers;

import java.sql.*;

import hmsGUI.LogIn;
public class lastPatientID {
    private int lastPID;

    // sets lastPID to the ID of the last inserted staff
    public lastPatientID(){
        try {
            String patientID = "";
            Statement stmt = LogIn.connection.createStatement();
            ResultSet res1 = stmt.executeQuery(
							"SELECT patientID from HMS.patient WHERE patientID =(SELECT MAX(patientID) FROM PATIENT )");
					while (res1.next()) {
						patientID += res1.getString("patientID");
					}	
                    lastPID = Integer.parseInt(patientID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // returns the last inserted staff ID as an int
    public int getlastPID(){
        return lastPID;
    }
    
}
