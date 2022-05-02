package hmsGUI.helpers;

import java.sql.*;

import hmsGUI.LogIn;

public class lastStaffID {
    private int lastSID;

    // sets lastSID to the ID of the last inserted staff
    public lastStaffID(){
        try {
            String staffID = "";
            Statement stmt = LogIn.connection.createStatement();
            ResultSet res1 = stmt.executeQuery(
							"SELECT staffID from HMS.STAFF WHERE staffID =(SELECT MAX(staffID) FROM STAFF )");
					while (res1.next()) {
						staffID += res1.getString("staffID");
					}	
                    lastSID = Integer.parseInt(staffID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // returns the last inserted staff ID as an int
    public int getlastSID(){
        return lastSID;
    }
    
}
