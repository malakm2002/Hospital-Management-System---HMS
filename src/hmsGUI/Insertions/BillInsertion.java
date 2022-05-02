package hmsGUI.Insertions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class BillInsertion {
    /**
     * Creates the page allowing pateint bill insertions
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Bill Insertion");

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
        frame.setBounds(100, 100, 400, 200);
        
        JLabel label = new JLabel(ManipulationOps.insertionback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);

        JLabel lblBillStatus = new JLabel("Bill Status*");
		lblBillStatus.setBounds(10, 11, 96, 14);
		frame.add(lblBillStatus);

        // input for the bill's status
		JTextField txtFldstatus = new JTextField();
		txtFldstatus.setBounds(10, 27, 96, 20);
		frame.add(txtFldstatus);
		txtFldstatus.setColumns(10);

		JLabel lblField = new JLabel("Field*");
		lblField.setBounds(122, 11, 94, 14);
		frame.add(lblField);

        // input for the bill's field
		JTextField txtField = new JTextField();
		txtField.setColumns(10);
		txtField.setBounds(120, 27, 96, 20);
		frame.add(txtField);

        JLabel lblCharge = new JLabel("Charge*");
		lblCharge.setBounds(10, 58, 96, 14);
		frame.add(lblCharge);

        // input for the bill's charge
		JTextField txtfieldCharge = new JTextField();
		txtfieldCharge.setColumns(10);
		txtfieldCharge.setBounds(10, 73, 96, 20);
		frame.add(txtfieldCharge);

		JLabel lblCashier = new JLabel("Cashier ID*");
		lblCashier.setBounds(122, 58, 94, 14);
		frame.add(lblCashier);

        // input for the responsible cashier's ID
		JTextField txtFieldCashier = new JTextField();
		txtFieldCashier.setBounds(120, 73, 96, 20);
		frame.add(txtFieldCashier);
		txtFieldCashier.setColumns(10);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();

                    // executes the insert statement
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
        btnADD.setBounds(220, 110, 89, 23);
        frame.add(btnADD);
    }
}
