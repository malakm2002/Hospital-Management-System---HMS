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

public class CheckPatientExistence {
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

        JLabel lblPatientFirstName = new JLabel("Patient's First Name:");
        lblPatientFirstName.setBounds(20, 20, 111, 14);
        contentPane.add(lblPatientFirstName);

        JTextField input1 = new JTextField();
        input1.setBounds(20, 50, 124, 20);
        contentPane.add(input1);

        JLabel lblPatientLastName = new JLabel("Patient's Last Name:");
        lblPatientLastName.setBounds(20, 80, 111, 14);
        contentPane.add(lblPatientLastName);

        JTextField input2 = new JTextField();
        input2.setBounds(20, 110, 124, 20);
        contentPane.add(input2);

        JButton button = new JButton("Find");
        button.setBounds(20, 140, 100, 30);
        contentPane.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        contentPane.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input1.getText() == null) {
                    textArea.setText("Please input the patient's first name");
                }
                if (input2.getText() == null) {
                    textArea.setText("Please input the patient's last name");
                } else {
                    textArea.setText(getMeds(input1.getText(), input2.getText()));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(220, 20, 340, 180);
        contentPane.add(scrollPane);
    }

    static String getMeds(String firstName, String lastName) {
        String result = "";

        try {
            Statement medicineStmt = LogIn.connection.createStatement();

            ResultSet medicineRes = medicineStmt.executeQuery(
                    "SELECT firstName, lastName, phoneNumber, address, admissionDate, dischargeDate FROM PATIENTRECORD WHERE PATIENTRECORD.firstName = '" + firstName + "' AND PATIENTRECORD.lastName = '" + lastName + "'");

            while (medicineRes.next()) {
                result += medicineRes.getString("firstName") + medicineRes.getString("lastName") + ", ";
                result += medicineRes.getString("phoneNumber") + ", ";
                result += medicineRes.getString("address") + "\n";
                result += "    Admission date: " + medicineRes.getString("admissionDate") + "\n";
                result += "    Discharge date: " + medicineRes.getString("dischargeDate") + "\n\n";
            }

            medicineStmt.close();

            medicineRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }
}
