package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;
import hmsGUI.helpers.genderChecker;
import hmsGUI.helpers.lastStaffID;

public class NurseInsertion {
    /**
     * Creates the page allowing pateint nurse insertions
     */
	public static void create() {
        // title
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

        // input for the nurse's first name
		JTextField textFieldFN = new JTextField();
		textFieldFN.setBounds(10, 27, 96, 20);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);

		JLabel lblLN = new JLabel("Last Name*");
		lblLN.setBounds(122, 11, 94, 14);
		contentPane.add(lblLN);

        // input for the nurse's last name
		JTextField textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(120, 27, 96, 20);
		contentPane.add(textFieldLN);

		JLabel lblGender = new JLabel("Sex*");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(245, 11, 49, 14);
		contentPane.add(lblGender);

        // check boxes for the nurse's sex
		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setBounds(290, 7, 54, 23);
		contentPane.add(chckbxMale);

		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBounds(350, 7, 72, 23);
		contentPane.add(chckbxFemale);

		JLabel lblAddr = new JLabel("Address*");
		lblAddr.setBounds(10, 58, 96, 14);
		contentPane.add(lblAddr);

        // input for the nurse's address
		JTextField textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(10, 73, 96, 20);
		contentPane.add(textFieldAddress);

		JLabel lblPhone = new JLabel("Phone Number*");
		lblPhone.setBounds(122, 58, 94, 14);
		contentPane.add(lblPhone);

        // input for the nurse's phone number
		JTextField textFieldPhone = new JTextField();
		textFieldPhone.setBounds(120, 73, 96, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblstartDate = new JLabel("Start Date*");
		lblstartDate.setBounds(260, 40, 111, 14);
		contentPane.add(lblstartDate);

        // choices for the nurse's first day of work
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(360, 37, 124, 20);
		contentPane.add(dateChooser);

		JLabel lblJobType = new JLabel("Job Type");
		lblJobType.setBounds(10, 140, 96, 14);
		contentPane.add(lblJobType);

        // input for the nurse's job type
		JTextField textFieldJobType = new JTextField();
		textFieldJobType.setBounds(10, 155, 96, 20);
		contentPane.add(textFieldJobType);
		textFieldJobType.setColumns(10);

		JLabel lblSupervisorID = new JLabel("Supervisor ID*");
		lblSupervisorID.setBounds(120, 140, 96, 14);
		contentPane.add(lblSupervisorID);

        // input for the nurse's supervisor
		JTextField textFieldSupervisorID = new JTextField();
		textFieldSupervisorID.setColumns(10);
		textFieldSupervisorID.setBounds(122, 155, 96, 20);
		contentPane.add(textFieldSupervisorID);

		JButton btnADD = new JButton("Add");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					genderChecker gChecker = new genderChecker(chckbxMale, chckbxFemale);
					char gender = gChecker.getGender();
					Statement stmt = LogIn.connection.createStatement();

                    // executes the insertion
					ResultSet res = stmt.executeQuery("CALL hms.InsertNurse('" + textFieldJobType.getText() + "',"
							+ Integer.parseInt(textFieldSupervisorID.getText()) + ")");

					lastStaffID staffID = new lastStaffID();	

					res = stmt.executeQuery("CALL HMS.InsertStaffRecord('" + textFieldFN.getText() + "','"
							+ textFieldLN.getText() + "','" + gender + "','" + textFieldAddress.getText() + "',"
							+ textFieldPhone.getText()+",'"+parseDateTime(dateChooser.getDate())+"',"+Types.NULL+","+staffID.getlastSID()+")");
					SuccessMessageFrame.create();
					frame.setVisible(false);
				} catch (Exception e1) {
					FailureMessageFrame.create();
				}
			}
		});
		btnADD.setBounds(250, 150, 89, 23);
		contentPane.add(btnADD);
	}

    // parses the date retrieved by MySQL into a format readable by JAVA
	public static String parseDateTime(java.util.Date date) {
		String[] parts = date.toString().split(" ");
		return parts[5] +"-"+ parseMonth(parts[1]) + "-" + parts[2] +" " + parts[3] ;
	}

    // returns the month as a number
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
