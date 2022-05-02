package hmsGUI.Updates;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorUpdate {
    /**
     * Creates the page allowing doctor updates
     */
    public static void create() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 250);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        frame.setVisible(true);
        frame.setResizable(false);

        JLabel lblDoctorID = new JLabel("Doctor ID");
        lblDoctorID.setBounds(36, 53, 76, 14);
        frame.add(lblDoctorID);

        // input for the doctor's ID
        JTextField txtDoctID = new JTextField();
        txtDoctID.setBounds(99, 50, 96, 20);
        frame.add(txtDoctID);
        txtDoctID.setColumns(10);

        JLabel lblSpecialty = new JLabel("Specialty");
        lblSpecialty.setBounds(36, 81, 76, 14);
        frame.add(lblSpecialty);

        // input for the doctor's specialty
        JTextField txtSpecialty = new JTextField();
        txtSpecialty.setColumns(10);
        txtSpecialty.setBounds(99, 78, 96, 20);
        frame.add(txtSpecialty);

        // executes the required updates
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtDoctID.getText().equalsIgnoreCase("") && !txtSpecialty.getText().equalsIgnoreCase("")) {
                    try {
                        // creates the SQL query
                        CallableStatement statement = (CallableStatement) LogIn.connection
                                .prepareCall("UPDATE doctorInfo set specialty = \"" + txtSpecialty.getText()
                                        + "\" WHERE staffID = " + txtDoctID.getText());
                        
                        // executes the above query
                        statement.executeUpdate();
                        statement.close();
                        SuccessMessageFrame.create();
                        frame.setVisible(false);
                    } catch (Exception e1) {
                        FailureMessageFrame.create();
                    }
                }
            }
        });
        btnUpdate.setBounds(79, 124, 89, 23);
        frame.add(btnUpdate);
    }
}
