package hmsGUI.Updates;

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

public class patientRecUpdate {
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

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(287, 40, 140, 20);
        contentPane.add(lblID);
        JTextField txtID = new JTextField();
        txtID.setBounds(305, 41, 96, 20);
        contentPane.add(txtID);
        JLabel lblFN = new JLabel("First Name*");
        lblFN.setBounds(40, 71, 96, 14);
        contentPane.add(lblFN);

        JTextField textFieldFN = new JTextField();
        textFieldFN.setBounds(40, 87, 96, 20);
        contentPane.add(textFieldFN);
        textFieldFN.setColumns(10);

        JLabel lblLN = new JLabel("Last Name*");
        lblLN.setBounds(152, 71, 94, 14);
        contentPane.add(lblLN);

        JTextField textFieldLN = new JTextField();
        textFieldLN.setColumns(10);
        textFieldLN.setBounds(150, 87, 96, 20);
        contentPane.add(textFieldLN);

        JLabel lblGender = new JLabel("Sex*");
        lblGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblGender.setBounds(275, 71, 49, 14);
        contentPane.add(lblGender);

        JCheckBox chckbxMale = new JCheckBox("Male");
        chckbxMale.setBounds(320, 67, 54, 23);
        contentPane.add(chckbxMale);

        JCheckBox chckbxFemale = new JCheckBox("Female");
        chckbxFemale.setBounds(380, 67, 72, 23);
        contentPane.add(chckbxFemale);

        JLabel lblAddr = new JLabel("Address*");
        lblAddr.setBounds(40, 108, 96, 14);
        contentPane.add(lblAddr);

        JTextField textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(40, 133, 96, 20);
        contentPane.add(textFieldAddress);

        JLabel lblPhone = new JLabel("Phone Number*");
        lblPhone.setBounds(152, 118, 104, 14);
        contentPane.add(lblPhone);

        JTextField textFieldPhone = new JTextField();
        textFieldPhone.setBounds(150, 133, 96, 20);
        contentPane.add(textFieldPhone);
        textFieldPhone.setColumns(10);

        JLabel lblAddmissionDate = new JLabel("Admission Date*");
        lblAddmissionDate.setBounds(290, 100, 111, 14);
        contentPane.add(lblAddmissionDate);

        JLabel lblDischargeDate = new JLabel("Discharge Date*");
        lblDischargeDate.setBounds(290, 130, 111, 14);
        contentPane.add(lblDischargeDate);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(390, 97, 124, 20);
        contentPane.add(dateChooser);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(390, 135, 124, 20);
        contentPane.add(dateChooser_1);

        JLabel lblDiag = new JLabel("Diagnosis");
        lblDiag.setBounds(40, 170, 96, 14);
        contentPane.add(lblDiag);

        JTextField txtDiag = new JTextField();
        txtDiag.setBounds(40, 185, 96, 20);
        contentPane.add(txtDiag);
        txtDiag.setColumns(10);

        JLabel lblroomID = new JLabel("Room ID*");
        lblroomID.setBounds(150, 170, 96, 14);
        contentPane.add(lblroomID);

        JTextField txtRoomID = new JTextField();
        txtRoomID.setColumns(10);
        txtRoomID.setBounds(152, 185, 96, 20);
        contentPane.add(txtRoomID);

        JButton btnADD = new JButton("Update");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    CallableStatement statment;
                    ResultSet res;
                    char gender;
                    if (!textFieldFN.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE patientInfo SET firstName = \"" + textFieldFN.getText() + "\" "
                                        + "WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (!textFieldLN.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE patientInfo SET lastName = \"" + textFieldLN.getText() + "\" "
                                        + "WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (!textFieldAddress.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE patientInfo SET address = \"" + textFieldAddress.getText() + "\" "
                                        + "WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (!textFieldPhone.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE patientInfo SET phoneNumber = " + textFieldPhone.getText()
                                        + " WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (!txtDiag.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE patientInfo SET diagnosis = \""
                                        + txtDiag.getText() + "\" WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (!txtRoomID.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection.prepareCall("UPDATE patientInfo SET roomID = "
                                + txtRoomID.getText() + " WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (dateChooser.getDate() != null) {

                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE patientInfo SET admissionDate = '" + parseDate(dateChooser.getDate())
                                        + "' WHERE patientID = " + txtID.getText());
                        statment.execute();

                    }
                    if (dateChooser_1.getDate() != null) {
                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE patientInfo SET dischargeDate = '" + parseDate(dateChooser_1.getDate())
                                        + "' WHERE patientID = " + txtID.getText());
                        statment.execute();
                    } else {
                        genderChecker genderChecker = new genderChecker(chckbxMale, chckbxFemale);
                        gender = genderChecker.getGender();
                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE patientInfo SET gender = '" + gender + "' WHERE patientID = "
                                        + txtID.getText());
                        statment.execute();

                    }
                    statment.close();
                    SuccessMessageFrame.create();
                    frame.setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                    FailureMessageFrame.create();

                }

            }
        });
        btnADD.setBounds(280, 180, 89, 23);
        contentPane.add(btnADD);
    }

    public static String parseDate(java.util.Date date) {
        String[] parts = date.toString().split(" ");
        return parts[5] + "-" + parseMonth(parts[1]) + "-" + parts[2] + " " + parts[3];
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
