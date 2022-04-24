package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.conf.PropertyDefinitions.AuthMech;
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

		JLabel lblPatientIDN = new JLabel("PatientID");
		lblPatientIDN.setBounds(10, 100, 49, 14);
		contentPane.add(lblPatientIDN);

		JLabel lblStaffIDN = new JLabel("Staff ID");
		lblStaffIDN.setBounds(122, 100, 49, 14);
		contentPane.add(lblStaffIDN);

		JTextField textFieldpatientIDN = new JTextField();
		textFieldpatientIDN.setBounds(10, 114, 96, 20);
		contentPane.add(textFieldpatientIDN);
		textFieldpatientIDN.setColumns(10);

		JTextField textFieldStaffIDN = new JTextField();
		textFieldStaffIDN.setColumns(10);
		textFieldStaffIDN.setBounds(120, 114, 96, 20);
		contentPane.add(textFieldStaffIDN);

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
System.out.println(parseDateTime(dateChooser.getDate()).toString());
					Statement stmt = LogIn.connection.createStatement();
				//	ResultSet res = stmt.executeQuery("CALL hms.InsertNurse('" + textFieldJobType.getText() + "',"
					//		+ Integer.parseInt(textFieldSupervisorID.getText()) + ")");
					//ResultSet res1 = stmt.executeQuery(
				//			"SELECT staffID from HMS.STAFF WHERE staffID =(SELECT MAX(staffID) FROM STAFF )");
				//	while (res1.next()) {
				//		staffID += res1.getString("staffID");
					}
					//res = stmt.executeQuery(
					//		"CALL HMS.InsertRecord('" + textFieldFN.getText() + "','" + textFieldLN.getText() + "','");
				 catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnADD.setBounds(250, 150, 89, 23);
		contentPane.add(btnADD);
	}
	public static LocalDateTime parseDateTime(java.util.Date date){
		String[] parts = date.toString().split(" ");
		String[] time = parts[3].split(":");
		return LocalDateTime.of(Integer.parseInt(parts[parts.length-1]), parseMonth(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
		//return null;
	}
	public static Month parseMonth(String month){
	if(month.equalsIgnoreCase("jan")){
		return Month.JANUARY;
	}
	if(month.equalsIgnoreCase("feb")){
		return Month.FEBRUARY;
	}
	if(month.equalsIgnoreCase("mar")){
		return Month.MARCH;
	}
	if(month.equalsIgnoreCase("apr")){
		return Month.APRIL;
	}
	if(month.equalsIgnoreCase("may")){
		return Month.MAY;
	}
	if(month.equalsIgnoreCase("jun")){
		return Month.JUNE;
	}
	if(month.equalsIgnoreCase("jul")){
		return Month.JULY;
	}
	if(month.equalsIgnoreCase("aug")){
		return Month.AUGUST;
	}
	if(month.equalsIgnoreCase("sep")){
		return Month.SEPTEMBER;
	}
	if(month.equalsIgnoreCase("oct")){
		return Month.OCTOBER;
	}
	if(month.equalsIgnoreCase("nov")){
		return Month.NOVEMBER;
	}
	if(month.equalsIgnoreCase("dec")){
		return Month.DECEMBER;
	}
	return null;}
}
