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

public class RoomInsertion {
    /**
     * Creates the page allowing pateint room insertions
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Room Insertion");

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

        JLabel lblRoomType = new JLabel("Room Type*");
        lblRoomType.setBounds(10, 11, 96, 14);
        frame.add(lblRoomType);

        // input for the room's type
        JTextField txtFldRoomType = new JTextField();
        txtFldRoomType.setBounds(10, 27, 96, 20);
        frame.add(txtFldRoomType);
        txtFldRoomType.setColumns(10);

        JLabel lblNurseID = new JLabel("Nurse ID*");
        lblNurseID.setBounds(122, 11, 94, 14);
        frame.add(lblNurseID);

        // input for the nurse's ID
        JTextField textFieldNurseID = new JTextField();
        textFieldNurseID.setColumns(10);
        textFieldNurseID.setBounds(120, 27, 96, 20);
        frame.add(textFieldNurseID);

        JLabel lbljanitorID = new JLabel("JanitorID*");
        lbljanitorID.setHorizontalAlignment(SwingConstants.CENTER);
        lbljanitorID.setBounds(10, 50, 55, 14);
        frame.add(lbljanitorID);

        // input for the janitor's ID
        JTextField textFieldJanitorID = new JTextField();
        textFieldJanitorID.setColumns(10);
        textFieldJanitorID.setBounds(10, 65, 96, 20);
        frame.add(textFieldJanitorID);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();

                    // executes the isnertion
                    ResultSet res = stmt.executeQuery("CALL hms.InsertRoom('" + txtFldRoomType.getText() + "',"
                            + Integer.parseInt(textFieldNurseID.getText()) + ","
                            + Integer.parseInt(textFieldJanitorID.getText()) + ")");
                    SuccessMessageFrame.create();
                    frame.setVisible(false);

                } catch (Exception e1) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnADD.setBounds(250, 60, 89, 23);
        frame.add(btnADD);
    }
}
