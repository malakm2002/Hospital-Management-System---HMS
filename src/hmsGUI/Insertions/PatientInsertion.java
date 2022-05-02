package hmsGUI.Insertions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

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

        JLabel lblDiagnosis = new JLabel("Diagnosis*");
		lblDiagnosis.setBounds(10, 11, 96, 14);
		frame.add(lblDiagnosis);

        // input for the diagnosis
		JTextField txtFldDiag = new JTextField();
		txtFldDiag.setBounds(10, 27, 96, 20);
		frame.add(txtFldDiag);
		txtFldDiag.setColumns(10);

        JLabel lblroomID = new JLabel("roomID*");
		lblroomID.setBounds(10, 58, 96, 14);
		frame.add(lblroomID);

        // input for the room
		JTextField txtFldRoomID = new JTextField();
		txtFldRoomID.setColumns(10);
		txtFldRoomID.setBounds(10, 73, 96, 20);
		frame.add(txtFldRoomID);


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
        frame.add(btnADD);
    }
}
