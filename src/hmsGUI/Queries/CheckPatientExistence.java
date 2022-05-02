package hmsGUI.Queries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;

public class CheckPatientExistence {
    /**
     * Creates the page allowing checking for the existence of a petient
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
        JLabel label = new JLabel(ManipulationOps.queryback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        JLabel lblPatientFirstName = new JLabel("Patient's First Name:");
        lblPatientFirstName.setBounds(20, 20, 111, 14);
        frame.add(lblPatientFirstName);

        // input for the patient's first name
        JTextField input1 = new JTextField();
        input1.setBounds(20, 50, 124, 20);
        frame.add(input1);

        JLabel lblPatientLastName = new JLabel("Patient's Last Name:");
        lblPatientLastName.setBounds(20, 80, 111, 14);
        frame.add(lblPatientLastName);

        // input for the patient's last name
        JTextField input2 = new JTextField();
        input2.setBounds(20, 110, 124, 20);
        frame.add(input2);

        JButton button = new JButton("Find");
        button.setBounds(20, 140, 100, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        frame.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input1.getText() == null) {
                    textArea.setText("Please input the patient's first name");
                }
                if (input2.getText() == null) {
                    textArea.setText("Please input the patient's last name");
                } else {
                    // displays the results
                    textArea.setText(getPatient(input1.getText(), input2.getText()));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(220, 20, 340, 180);
        frame.add(scrollPane);
    }

    static String getPatient(String firstName, String lastName) {
        String result = "";

        try {
            Statement patientStmt = LogIn.connection.createStatement();

            // retrieves infotmation about a specific patient
            ResultSet patientRes = patientStmt.executeQuery(
                    "SELECT firstName, lastName, phoneNumber, address, admissionDate, dischargeDate FROM PATIENTRECORD WHERE PATIENTRECORD.firstName = '" + firstName + "' AND PATIENTRECORD.lastName = '" + lastName + "'");

            // displays the information retrieved above 
            while (patientRes.next()) {
                result += patientRes.getString("firstName") + patientRes.getString("lastName") + ", ";
                result += patientRes.getString("phoneNumber") + ", ";
                result += patientRes.getString("address") + "\n";
                result += "    Admission date: " + patientRes.getString("admissionDate") + "\n";
                result += "    Discharge date: " + patientRes.getString("dischargeDate") + "\n\n";
            }

            patientStmt.close();

            patientRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }
}
