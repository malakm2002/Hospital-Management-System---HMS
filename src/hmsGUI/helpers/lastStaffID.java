package hmsGUI.helpers;

import java.sql.*;

import hmsGUI.LogIn;

public class lastStaffID {
    private int lastSID;

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
    public int getlastSID(){
        return lastSID;
    }
    
}
