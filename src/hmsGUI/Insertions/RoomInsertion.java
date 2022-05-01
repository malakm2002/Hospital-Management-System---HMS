package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class RoomInsertion {
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
        frame.setBounds(100, 100, 600, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRoomType = new JLabel("Room Type*");
        lblRoomType.setBounds(10, 11, 96, 14);
        contentPane.add(lblRoomType);

        JTextField txtFldRoomType = new JTextField();
        txtFldRoomType.setBounds(10, 27, 96, 20);
        contentPane.add(txtFldRoomType);
        txtFldRoomType.setColumns(10);

        JLabel lblNurseID = new JLabel("Nurse ID*");
        lblNurseID.setBounds(122, 11, 94, 14);
        contentPane.add(lblNurseID);

        JTextField textFieldNurseID = new JTextField();
        textFieldNurseID.setColumns(10);
        textFieldNurseID.setBounds(120, 27, 96, 20);
        contentPane.add(textFieldNurseID);

        JLabel lbljanitorID = new JLabel("JanitorID*");
        lbljanitorID.setHorizontalAlignment(SwingConstants.CENTER);
        lbljanitorID.setBounds(260, 11, 55, 14);
        contentPane.add(lbljanitorID);

        JTextField textFieldJanitorID = new JTextField();
        textFieldJanitorID.setColumns(10);
        textFieldJanitorID.setBounds(260, 27, 96, 20);
        contentPane.add(textFieldJanitorID);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();
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
        contentPane.add(btnADD);
    }
}
