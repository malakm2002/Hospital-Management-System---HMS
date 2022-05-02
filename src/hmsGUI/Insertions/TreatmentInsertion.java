package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class TreatmentInsertion {
    /**
     * Creates the page allowing pateint treatment ('treat' table) insertions
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
        frame.setBounds(100, 100, 600, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPatient = new JLabel("Patient ID*");
        lblPatient.setBounds(10, 11, 96, 14);
        contentPane.add(lblPatient);

        // input for the patient's ID
        JTextField txtPatient = new JTextField();
        txtPatient.setBounds(10, 27, 96, 20);
        contentPane.add(txtPatient);
        txtPatient.setColumns(10);

        JLabel lbldoctor = new JLabel("Doctor ID*");
        lbldoctor.setBounds(122, 11, 94, 14);
        contentPane.add(lbldoctor);

        // input for the patient's doctor (ID)
        JTextField txtDoctor = new JTextField();
        txtDoctor.setColumns(10);
        txtDoctor.setBounds(120, 27, 96, 20);
        contentPane.add(txtDoctor);

        JLabel lblMed = new JLabel("Medicine ID*");
        lblMed.setHorizontalAlignment(SwingConstants.CENTER);
        lblMed.setBounds(260, 11, 80, 14);
        contentPane.add(lblMed);

        // input for the patient's medicine (ID)
        JTextField txtMed = new JTextField();
        txtMed.setColumns(10);
        txtMed.setBounds(260, 27, 96, 20);
        contentPane.add(txtMed);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();

                    // executes the treatment
                    ResultSet res = stmt.executeQuery("CALL hms.InsertTreat(" + txtPatient.getText() + ","
                            + txtDoctor.getText() + ","
                            + txtMed.getText() + ")");
                    SuccessMessageFrame.create();
                    frame.setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    FailureMessageFrame.create();
                }
            }
        });
        btnADD.setBounds(250, 60, 89, 23);
        contentPane.add(btnADD);
    } 
}
