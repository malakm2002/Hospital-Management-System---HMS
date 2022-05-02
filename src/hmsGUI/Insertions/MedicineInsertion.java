
package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class MedicineInsertion {
    /**
     * Creates the page allowing pateint medicine insertions
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

        JLabel lblMedName = new JLabel("Medicine Name*");
        lblMedName.setBounds(10, 11, 96, 14);
        contentPane.add(lblMedName);

        // input for the medicine name
        JTextField txtMedName = new JTextField();
        txtMedName.setBounds(10, 27, 96, 20);
        contentPane.add(txtMedName);
        txtMedName.setColumns(10);

        JLabel lblMedPrice = new JLabel("Medicine Price*");
        lblMedPrice.setBounds(122, 11, 94, 14);
        contentPane.add(lblMedPrice);

        // input for the medicine price
        JTextField txtMedPrice = new JTextField();
        txtMedPrice.setColumns(10);
        txtMedPrice.setBounds(120, 27, 96, 20);
        contentPane.add(txtMedPrice);
        
        JLabel lblMedQty = new JLabel("Medicine Quantity*");
        lblMedQty.setHorizontalAlignment(SwingConstants.CENTER);
        lblMedQty.setBounds(260, 11, 55, 14);
        contentPane.add(lblMedQty);

        // input for the medicine quantity
        JTextField txtMedQty = new JTextField();
        txtMedQty.setColumns(10);
        txtMedQty.setBounds(260, 27, 96, 20);
        contentPane.add(txtMedQty);

        JButton btnADD = new JButton("Add");
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = LogIn.connection.createStatement();
                    
                    // executes the insertion
                    ResultSet res = stmt.executeQuery("CALL hms.InsertMedicine('" + txtMedName.getText() + "',"
                            + Integer.parseInt(txtMedPrice.getText()) + ","
                            + Integer.parseInt(txtMedQty.getText()) + ")");

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
