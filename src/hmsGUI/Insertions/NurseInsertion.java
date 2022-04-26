package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hmsGUI.LogIn;

public class NurseInsertion {
	public static void create() {

		JFrame frame = new JFrame("Hospital Management System - Operations");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 260);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFN = new JLabel("First Name*");
		lblFN.setBounds(10, 11, 96, 14);
		contentPane.add(lblFN);

		JTextField textFieldFN = new JTextField();
		textFieldFN.setBounds(10, 27, 96, 20);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);

		JLabel lblLN = new JLabel("Last Name*");
		lblLN.setBounds(122, 11, 94, 14);
		contentPane.add(lblLN);

		JTextField textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(120, 27, 96, 20);
		contentPane.add(textFieldLN);

		JLabel lblGender = new JLabel("Sex*");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(245, 11, 49, 14);
		contentPane.add(lblGender);

		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setBounds(290, 7, 54, 23);
		contentPane.add(chckbxMale);

		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBounds(350, 7, 72, 23);
		contentPane.add(chckbxFemale);

		JLabel lblAddr = new JLabel("Address*");
		lblAddr.setBounds(10, 58, 96, 14);
		contentPane.add(lblAddr);

		JTextField textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(10, 73, 96, 20);
		contentPane.add(textFieldAddress);

		JLabel lblPhone = new JLabel("Phone Number*");
		lblPhone.setBounds(122, 58, 94, 14);
		contentPane.add(lblPhone);

		JTextField textFieldPhone = new JTextField();
		textFieldPhone.setBounds(120, 73, 96, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblAdmission = new JLabel("Admission Date*");
		lblAdmission.setBounds(260, 40, 111, 14);
		contentPane.add(lblAdmission);

		JLabel lblDischarge = new JLabel("Discharge Date");
		lblDischarge.setBounds(260, 73, 89, 14);
		contentPane.add(lblDischarge);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(360, 37, 124, 20);
		contentPane.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(360, 73, 124, 20);
		contentPane.add(dateChooser_1);

		JLabel lblJobType = new JLabel("Job Type");
		lblJobType.setBounds(10, 140, 96, 14);
		contentPane.add(lblJobType);

		JTextField textFieldJobType = new JTextField();
		textFieldJobType.setBounds(10, 155, 96, 20);
		contentPane.add(textFieldJobType);
		textFieldJobType.setColumns(10);

		JLabel lblSupervisorID = new JLabel("Supervisor ID*");
		lblSupervisorID.setBounds(120, 140, 96, 14);
		contentPane.add(lblSupervisorID);

		JTextField textFieldSupervisorID = new JTextField();
		textFieldSupervisorID.setColumns(10);
		textFieldSupervisorID.setBounds(122, 155, 96, 20);
		contentPane.add(textFieldSupervisorID);

		JButton btnADD = new JButton("Add");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String staffID = "";
					char gender;
					if (chckbxMale.isSelected()) {
						gender = 'M';
					} else {
						gender = 'F';
					}
					Statement stmt = LogIn.connection.createStatement();
					ResultSet res = stmt.executeQuery("CALL hms.InsertNurse('" + textFieldJobType.getText() + "',"
							+ Integer.parseInt(textFieldSupervisorID.getText()) + ")");
					ResultSet res1 = stmt.executeQuery(
							"SELECT staffID from HMS.STAFF WHERE staffID =(SELECT MAX(staffID) FROM STAFF )");
					while (res1.next()) {
						staffID += res1.getString("staffID");
					}
					//in the following query: 
					
					res = stmt.executeQuery("CALL HMS.InsertRecord('" + textFieldFN.getText() + "','"
							+ textFieldLN.getText() + "','" + gender + "','" + textFieldAddress.getText() + "',"
							+ textFieldPhone.getText()+",'"+parseDateTime(dateChooser.getDate())+"','"+parseDateTime(dateChooser_1.getDate())+"',"+Types.NULL+","+staffID+")");
							
					System.out.println("CALL HMS.InsertRecord('" + textFieldFN.getText() + "','"
							+ textFieldLN.getText() + "','" + gender + "','" + textFieldAddress.getText() + "',"
							+ textFieldPhone.getText()+",'"+parseDateTime(dateChooser.getDate())+"','"+parseDateTime(dateChooser_1.getDate())+"',"+Types.NULL+","+staffID+")");		
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnADD.setBounds(250, 150, 89, 23);
		contentPane.add(btnADD);
	}

	public static String parseDateTime(java.util.Date date) {
		String[] parts = date.toString().split(" ");
		return parts[5] +"-"+ parseMonth(parts[1]) + "-" + parts[2] +" " + parts[3] ;
	}

	public static String parseMonth(String month) {
		if (month.equalsIgnoreCase("jan")) {
			return "01";
		}
		if (month.equalsIgnoreCase("feb")) {
			return "02";
		}
		if (month.equalsIgnoreCase("mar")) {
			return "03";
		}
		if (month.equalsIgnoreCase("apr")) {
			return "04";
		}
		if (month.equalsIgnoreCase("may")) {
			return "05";
		}
		if (month.equalsIgnoreCase("jun")) {
			return "06";
		}
		if (month.equalsIgnoreCase("jul")) {
			return "07";
		}
		if (month.equalsIgnoreCase("aug")) {
			return "08";
		}
		if (month.equalsIgnoreCase("sep")) {
			return "09";
		}
		if (month.equalsIgnoreCase("oct")) {
			return "10";
		}
		if (month.equalsIgnoreCase("nov")) {
			return "11";
		}
		if (month.equalsIgnoreCase("dec")) {
			return "12";
		}
		return null;
	}
}
