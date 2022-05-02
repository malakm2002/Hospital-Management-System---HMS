package hmsGUI.Insertions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class PatientInsertion {
    /**
     * Creates the page allowing pateint patient insertions
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

        JLabel lblDiagnosis = new JLabel("Diagnosis*");
		lblDiagnosis.setBounds(10, 11, 96, 14);
		contentPane.add(lblDiagnosis);

        // input for the diagnosis
		JTextField txtFldDiag = new JTextField();
		txtFldDiag.setBounds(10, 27, 96, 20);
		contentPane.add(txtFldDiag);
		txtFldDiag.setColumns(10);

        JLabel lblroomID = new JLabel("roomID*");
		lblroomID.setBounds(10, 58, 96, 14);
		contentPane.add(lblroomID);

        // input for the room
		JTextField txtFldRoomID = new JTextField();
		txtFldRoomID.setColumns(10);
		txtFldRoomID.setBounds(10, 73, 96, 20);
		contentPane.add(txtFldRoomID);


        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();

                    // executes the insertion
                    ResultSet res = stmt.executeQuery("CALL hms.InsertPatient('" + txtFldDiag.getText() + "',"
                            + Integer.parseInt(txtFldRoomID.getText()) +")");
                    SuccessMessageFrame.create();
                    frame.setVisible(false);
                    System.out.println(this.getClass().toString());
                } catch (Exception e1) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnADD.setBounds(122, 27, 89, 23);
        contentPane.add(btnADD);
    }
}
