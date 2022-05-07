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
import hmsGUI.helpers.lastPatientID;
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
        frame.setBounds(100, 100, 600, 260);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);


        JLabel lblFN = new JLabel("First Name*");
        lblFN.setBounds(40, 71, 96, 14);
        frame.add(lblFN);

        JLabel lblLN = new JLabel("Last Name*");
        lblLN.setBounds(152, 71, 94, 14);
        frame.add(lblLN);

        // input for the patient's first name
        JTextField textFieldFN = new JTextField();
        textFieldFN.setBounds(40, 87, 96, 20);
        frame.add(textFieldFN);
        textFieldFN.setColumns(10);

        // input for the patient's last name
        JTextField textFieldLN = new JTextField();
        textFieldLN.setColumns(10);
        textFieldLN.setBounds(150, 87, 96, 20);
        frame.add(textFieldLN);

        JLabel lblGender = new JLabel("Sex*");
        lblGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblGender.setBounds(275, 71, 49, 14);
        frame.add(lblGender);

        // check boxes for the patient's sex
        JCheckBox chckbxMale = new JCheckBox("Male");
        chckbxMale.setContentAreaFilled(false);
        chckbxMale.setBounds(320, 67, 54, 23);
        frame.add(chckbxMale);

        JCheckBox chckbxFemale = new JCheckBox("Female");
        chckbxFemale.setBounds(380, 67, 72, 23);
        chckbxFemale.setContentAreaFilled(false);
        frame.add(chckbxFemale);

        JLabel lblAddr = new JLabel("Address*");
        lblAddr.setBounds(40, 108, 96, 14);
        frame.add(lblAddr);

        // input for the patients address
        JTextField textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(40, 133, 96, 20);
        frame.add(textFieldAddress);

        JLabel lblPhone = new JLabel("Phone Number*");
        lblPhone.setBounds(152, 118, 104, 14);
        frame.add(lblPhone);

        // input for the patient's phone number
        JTextField textFieldPhone = new JTextField();
        textFieldPhone.setBounds(150, 133, 96, 20);
        frame.add(textFieldPhone);
        textFieldPhone.setColumns(10);

        JLabel lblAddmissionDate = new JLabel("Admission Date*");
        lblAddmissionDate.setBounds(290, 100, 111, 14);
        frame.add(lblAddmissionDate);

        JLabel lblDischargeDate = new JLabel("Discharge Date*");
        lblDischargeDate.setBounds(290, 130, 111, 14);
        frame.add(lblDischargeDate);

        // choices for the admission and discharge dates
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(390, 97, 124, 20);
        frame.add(dateChooser);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(390, 135, 124, 20);
        frame.add(dateChooser_1);

        JLabel lblDiag = new JLabel("Diagnosis");
        lblDiag.setBounds(40, 170, 96, 14);
        frame.add(lblDiag);

        // input for the patient's diagnosis
        JTextField txtDiag = new JTextField();
        txtDiag.setBounds(40, 185, 96, 20);
        frame.add(txtDiag);
        txtDiag.setColumns(10);

        JLabel lblroomID = new JLabel("Room ID*");
        lblroomID.setBounds(150, 170, 96, 14);
        frame.add(lblroomID);

        // input for the patient's room ID
        JTextField txtRoomID = new JTextField();
        txtRoomID.setColumns(10);
        txtRoomID.setBounds(152, 185, 96, 20);
        frame.add(txtRoomID);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();
                    genderChecker gChecker = new genderChecker(chckbxMale, chckbxFemale);
                    lastPatientID lastPatientID = new lastPatientID();
                    // executes the insertion
                    ResultSet res = stmt.executeQuery("CALL hms.InsertPatient('" + txtDiag.getText() + "',"
                            + Integer.parseInt(txtRoomID.getText()) + ")");

                    res = stmt.executeQuery("CALL hms.InsertPatientRecord('" + textFieldFN.getText() + "','"
                            + textFieldFN.getText() + "','" + gChecker.getGender() + "','" + textFieldAddress.getText()
                            + "'," + textFieldPhone.getText() + ",'" + parseDateTime(dateChooser.getDate()) + "','"
                            + parseDateTime(dateChooser_1.getDate()) + "'," + lastPatientID.getlastPID() + ")");

                    SuccessMessageFrame.create();
                    frame.setVisible(false);
                    System.out.println(this.getClass().toString());
                } catch (Exception e1) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnADD.setBounds(290, 155, 89, 23);
        frame.add(btnADD);
    }

    // parses the date retrieved the date by MySQL into a format readable by JAVA
    public static String parseDateTime(java.util.Date date) {
        String[] parts = date.toString().split(" ");
        return parts[5] + "-" + parseMonth(parts[1]) + "-" + parts[2] + " " + parts[3];
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
