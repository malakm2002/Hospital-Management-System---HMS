package hmsGUI.Insertions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;
public class BillInsertion {
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

        JLabel lblBillStatus = new JLabel("Bill Status*");
		lblBillStatus.setBounds(10, 11, 96, 14);
		contentPane.add(lblBillStatus);

		JTextField txtFldstatus = new JTextField();
		txtFldstatus.setBounds(10, 27, 96, 20);
		contentPane.add(txtFldstatus);
		txtFldstatus.setColumns(10);

		JLabel lblField = new JLabel("Field*");
		lblField.setBounds(122, 11, 94, 14);
		contentPane.add(lblField);

		JTextField txtField = new JTextField();
		txtField.setColumns(10);
		txtField.setBounds(120, 27, 96, 20);
		contentPane.add(txtField);

        JLabel lblCharge = new JLabel("Charge*");
		lblCharge.setBounds(10, 58, 96, 14);
		contentPane.add(lblCharge);

		JTextField txtfieldCharge = new JTextField();
		txtfieldCharge.setColumns(10);
		txtfieldCharge.setBounds(10, 73, 96, 20);
		contentPane.add(txtfieldCharge);

		JLabel lblCashier = new JLabel("Cashier ID*");
		lblCashier.setBounds(122, 58, 94, 14);
		contentPane.add(lblCashier);

		JTextField txtFieldCashier = new JTextField();
		txtFieldCashier.setBounds(120, 73, 96, 20);
		contentPane.add(txtFieldCashier);
		txtFieldCashier.setColumns(10);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();
                    ResultSet res = stmt.executeQuery("CALL hms.InsertBill('" + txtFldstatus.getText() + "','"
                            + txtField.getText() + "',"
                            + Integer.parseInt(txtfieldCharge.getText()) +","+Integer.parseInt(txtFieldCashier.getText())+")");
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
