package hmsGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
   
    public boolean connected = true;
	private final static String sqlUrl = "jdbc:mysql://localhost:3306/hms";
	public Connection connection;
	public void Connect(String dbUserName, String dbPassword) {

        // loading the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loading driver");
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        // connecting to the database
        try {
            connection = DriverManager.getConnection(sqlUrl, dbUserName, dbPassword);
            System.out.println("Connecting...");

        } catch (SQLException error) {
            System.out.print(error.getMessage());
            connected=false;
        }

    }
}
