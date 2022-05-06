package hmsGUI.Insertions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;
import hmsGUI.helpers.genderChecker;
import hmsGUI.helpers.lastStaffID;

public class PatientInsertion {
    /**
     * Creates the page allowing pateint patient insertions
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Patient Insertion");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 200);
        JLabel label = new JLabel(ManipulationOps.insertionback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        JLabel lblFN = new JLabel("First Name*");
		lblFN.setBounds(10, 11, 96, 14);
		frame.add(lblFN);

        // input for the cashier's first name
		JTextField textFieldFN = new JTextField();
		textFieldFN.setBounds(10, 27, 96, 20);
		frame.add(textFieldFN);
		textFieldFN.setColumns(10);

		JLabel lblLN = new JLabel("Last Name*");
		lblLN.setBounds(122, 11, 94, 14);
		frame.add(lblLN);

        // input for the cashier's last name
		JTextField textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(120, 27, 96, 20);
		frame.add(textFieldLN);

		JLabel lblGender = new JLabel("Sex*");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(245, 11, 49, 14);
		frame.add(lblGender);

        // check boxes for the cashier's sex
		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setBounds(290, 7, 54, 23);
		chckbxMale.setContentAreaFilled(false);
		frame.add(chckbxMale);

		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBounds(350, 7, 72, 23);
		chckbxFemale.setContentAreaFilled(false);
		frame.add(chckbxFemale);

		JLabel lblAddr = new JLabel("Address*");
		lblAddr.setBounds(10, 58, 96, 14);
		frame.add(lblAddr);

        // input for the cashier's address
		JTextField textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(10, 73, 96, 20);
		frame.add(textFieldAddress);

		JLabel lblPhone = new JLabel("Phone Number*");
		lblPhone.setBounds(122, 58, 94, 14);
		frame.add(lblPhone);

        // input for the cashier's phone number
		JTextField textFieldPhone = new JTextField();
		textFieldPhone.setBounds(120, 73, 96, 20);
		frame.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblAdmission = new JLabel("Admission Date*");
		lblAdmission.setBounds(260, 40, 111, 14);
		frame.add(lblAdmission);
		
        // choices for the patient check in date
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(320, 57, 124, 20);
		frame.add(dateChooser);

        JLabel lblDischarge = new JLabel("Discharge Date*");
		lblDischarge.setBounds(260, 60, 111, 14);
		frame.add(lblDischarge);
		
        // choices for the patient's check out date
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(320, 57, 124, 20);
		frame.add(dateChooser_1);

		JLabel lblroomID = new JLabel("Room ID");
		lblroomID.setBounds(10, 100, 96, 14);
		frame.add(lblroomID);

        // input for the cashier's job type
		JTextField txtFldRoomID = new JTextField();
		txtFldRoomID.setBounds(10, 115, 96, 20);
		frame.add(txtFldRoomID);
		txtFldRoomID.setColumns(10);

		JLabel lblDiagnosis = new JLabel("DiagnosisD*");
		lblDiagnosis.setBounds(120, 100, 96, 14);
		frame.add(lblDiagnosis);

        // input for the cashier's supervisor
		JTextField txtFldDiag = new JTextField();
		txtFldDiag.setColumns(10);
		txtFldDiag.setBounds(122, 115, 96, 20);
		frame.add(txtFldDiag);


        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();
                    genderChecker gChecker = new genderChecker(chckbxMale, chckbxFemale);
                     
                    // executes the insertion
                    ResultSet res = stmt.executeQuery("CALL hms.InsertPatient('" + txtFldDiag.getText() + "',"
                            + Integer.parseInt(txtFldRoomID.getText()) +")");
                            res = stmt.executeQuery("CALL hms.InsertPatientRecord('"+textFieldFN.getText()+"','"+ textFieldFN.getText()+"','"+ gChecker.getGender()+"','"+ textFieldAddress.getText()+"'," + textFieldPhone.getText() + ",'"+parseDateTime(dateChooser.getDate())+"','"+parseDateTime(dateChooser_1.getDate())+ "'");

                    SuccessMessageFrame.create();
                    frame.setVisible(false);
                    System.out.println(this.getClass().toString());
                } catch (Exception e1) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnADD.setBounds(122, 27, 89, 23);
        frame.add(btnADD);
    }
     // parses the date retrieved the date by MySQL into a format readable by JAVA
	public static String parseDateTime(java.util.Date date) {
		String[] parts = date.toString().split(" ");
		return parts[5] +"-"+ parseMonth(parts[1]) + "-" + parts[2] +" " + parts[3] ;
	}

    // parses the month into a number
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
