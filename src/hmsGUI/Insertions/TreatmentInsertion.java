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

public class TreatmentInsertion {
    /**
     * Creates the page allowing pateint treatment ('treat' table) insertions
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Treatment Insertion");

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
        frame.setBounds(100, 100, 455, 200);
        JLabel label = new JLabel(ManipulationOps.insertionback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);

        JLabel lblPatient = new JLabel("Patient ID*");
        lblPatient.setBounds(10, 11, 96, 14);
        frame.add(lblPatient);

        // input for the patient's ID
        JTextField txtPatient = new JTextField();
        txtPatient.setBounds(10, 27, 96, 20);
        frame.add(txtPatient);
        txtPatient.setColumns(10);

        JLabel lbldoctor = new JLabel("Doctor ID*");
        lbldoctor.setBounds(122, 11, 94, 14);
        frame.add(lbldoctor);

        // input for the patient's doctor (ID)
        JTextField txtDoctor = new JTextField();
        txtDoctor.setColumns(10);
        txtDoctor.setBounds(120, 27, 96, 20);
        frame.add(txtDoctor);

        JLabel lblMed = new JLabel("Medicine ID*");
        lblMed.setHorizontalAlignment(SwingConstants.CENTER);
        lblMed.setBounds(10, 50, 80, 14);
        frame.add(lblMed);

        // input for the patient's medicine (ID)
        JTextField txtMed = new JTextField();
        txtMed.setColumns(10);
        txtMed.setBounds(10, 65, 96, 20);
        frame.add(txtMed);

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
        frame.add(btnADD);
    } 
}
