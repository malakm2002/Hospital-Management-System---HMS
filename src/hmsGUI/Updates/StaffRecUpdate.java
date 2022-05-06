package hmsGUI.Updates;

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

public class StaffRecUpdate {
    /**
     * Creates the page allowing pateint record updates
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Update staff records");

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

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(287, 40, 140, 20);
        frame.add(lblID);

        JTextField txtID = new JTextField();
        txtID.setBounds(305, 41, 96, 20);
        frame.add(txtID);

        JLabel lblFN = new JLabel("First Name*");
        lblFN.setBounds(40, 71, 96, 14);
        frame.add(lblFN);
        
        JLabel lblLN = new JLabel("Last Name*");
        lblLN.setBounds(152, 71, 94, 14);
        frame.add(lblLN);

        // input for the staff's first name
        JTextField textFieldFN = new JTextField();
        textFieldFN.setBounds(40, 87, 96, 20);
        frame.add(textFieldFN);
        textFieldFN.setColumns(10);

        // input for the staff's last name
        JTextField textFieldLN = new JTextField();
        textFieldLN.setColumns(10);
        textFieldLN.setBounds(150, 87, 96, 20);
        frame.add(textFieldLN);

        JLabel lblGender = new JLabel("Sex*");
        lblGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblGender.setBounds(275, 71, 49, 14);
        frame.add(lblGender);

        // check boxes for the staff's sex
        JCheckBox chckbxMale = new JCheckBox("Male");
        chckbxMale.setBounds(320, 67, 54, 23);
        frame.add(chckbxMale);

        JCheckBox chckbxFemale = new JCheckBox("Female");
        chckbxFemale.setBounds(380, 67, 72, 23);
        frame.add(chckbxFemale);

        JLabel lblAddr = new JLabel("Address*");
        lblAddr.setBounds(40, 108, 96, 14);
        frame.add(lblAddr);

        // input for the staff's address
        JTextField textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(40, 133, 96, 20);
        frame.add(textFieldAddress);

        JLabel lblPhone = new JLabel("Phone Number*");
        lblPhone.setBounds(152, 118, 104, 14);
        frame.add(lblPhone);

        // input for the staff's phone number
        JTextField textFieldPhone = new JTextField();
        textFieldPhone.setBounds(150, 133, 96, 20);
        frame.add(textFieldPhone);
        textFieldPhone.setColumns(10);

        JLabel lblstartDate = new JLabel("Start Date*");
        lblstartDate.setBounds(290, 100, 111, 14);
        frame.add(lblstartDate);

        JLabel lblendDate = new JLabel("End Date*");
        lblendDate.setBounds(290, 130, 111, 14);
        frame.add(lblendDate);

        // choices for the staff's first day and last day of work
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(390, 97, 124, 20);
        frame.add(dateChooser);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(390, 135, 124, 20);
        frame.add(dateChooser_1);

        JLabel lblJobType = new JLabel("Job Type");
        lblJobType.setBounds(40, 170, 96, 14);
        frame.add(lblJobType);

        // input for the staff's job type
        JTextField textFieldJobType = new JTextField();
        textFieldJobType.setBounds(40, 185, 96, 20);
        frame.add(textFieldJobType);
        textFieldJobType.setColumns(10);

        JLabel lblSupervisorID = new JLabel("Supervisor ID*");
        lblSupervisorID.setBounds(150, 170, 96, 14);
        frame.add(lblSupervisorID);

        // input for the staff's supervisor
        JTextField textFieldSupervisorID = new JTextField();
        textFieldSupervisorID.setColumns(10);
        textFieldSupervisorID.setBounds(152, 185, 96, 20);
        frame.add(textFieldSupervisorID);

        JButton btnADD = new JButton("Update");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // to contain the SQL query
                    CallableStatement statment;

                    ResultSet res;
                    char gender;

                    // updates the staff's first name if not empty
                    if (!textFieldFN.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE staffInfo SET firstName = \"" + textFieldFN.getText() + "\" "
                                        + "WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's last name if not empty
                    if (!textFieldLN.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE staffInfo SET lastName = \"" + textFieldLN.getText() + "\" "
                                        + "WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's address if not empty
                    if (!textFieldAddress.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE staffInfo SET address = \"" + textFieldAddress.getText() + "\" "
                                        + "WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's phone number
                    if (!textFieldPhone.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE staffInfo SET phoneNumber = " + textFieldPhone.getText()
                                        + " WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's type of job
                    if (!textFieldJobType.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection.prepareCall("UPDATE staffInfo SET jobtype = \""
                                + textFieldJobType.getText() + "\" WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's supervisor
                    if (!textFieldSupervisorID.getText().equalsIgnoreCase("")) {
                        statment = (CallableStatement) LogIn.connection.prepareCall("UPDATE staffInfo SET supervisorID = "
                                + textFieldSupervisorID.getText() + " WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's start date if not empty (null)
                    if (dateChooser.getDate() != null) {
                        System.out.print(dateChooser.getDate());

                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE staffInfo SET startDate = '" + parseDate(dateChooser.getDate())
                                        + "' WHERE staffID = " + txtID.getText());
                        statment.execute();
                    }

                    // updates the staff's end date if not empty (null)
                    if (dateChooser_1.getDate() != null) {
                        System.out.print(dateChooser_1.getDate());
                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE staffInfo SET endDate = '" + parseDate(dateChooser_1.getDate())
                                        + "' WHERE staffID = " + txtID.getText());
                        statment.execute();
                    } 

                    // updates the staff's gender
                    else{
                        genderChecker genderChecker = new genderChecker(chckbxMale, chckbxFemale);
                        gender = genderChecker.getGender();
                        statment = (CallableStatement) LogIn.connection.prepareCall(
                                "UPDATE staffInfo SET gender = '" + gender + "' WHERE staffID = " + txtID.getText());
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
        frame.add(btnADD);
    }

    // parses the date retrieved by SQL into a format recognized by JAVA
    public static String parseDate(java.util.Date date) {
        String[] parts = date.toString().split(" ");
        return parts[5] + "-" + parseMonth(parts[1]) + "-" + parts[2] + " " + parts[3];
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
