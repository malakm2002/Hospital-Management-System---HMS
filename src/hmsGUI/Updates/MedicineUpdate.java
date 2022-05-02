package hmsGUI.Updates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class MedicineUpdate {
    /**
     * Creates the page allowing medicine updates
     */
    public static void create() {
        JFrame frame = new JFrame("HMS - Update Medicine");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        frame.setVisible(true);
        frame.setResizable(false);

        JLabel lblMedID = new JLabel("Medicine ID");
        lblMedID.setBounds(33, 40, 80, 14);
        frame.add(lblMedID);

        // input for the medicine's ID
        JTextField txtMedID = new JTextField();
        txtMedID.setBounds(113, 37, 96, 20);
        frame.add(txtMedID);
        txtMedID.setColumns(10);

        JLabel lblMedName = new JLabel("Name");
        lblMedName.setBounds(33, 74, 80, 14);
        frame.add(lblMedName);

        // input for the medicine's name
        JTextField txtMedName = new JTextField();
        txtMedName.setColumns(10);
        txtMedName.setBounds(113, 71, 96, 20);
        frame.add(txtMedName);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(33, 110, 49, 14);
        frame.add(lblPrice);

        // input for the price
        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(113, 107, 96, 20);
        frame.add(txtPrice);
        txtPrice.setColumns(10);

        JLabel lblqty = new JLabel("Quantity");
        lblqty.setBounds(33, 142, 49, 14);
        frame.add(lblqty);

        // input for the quantity
        JTextField txtQty = new JTextField();
        txtQty.setColumns(10);
        txtQty.setBounds(113, 139, 96, 20);
        frame.add(txtQty);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // to contain the SQL query
                    CallableStatement statment;

                    // updates the name if not empty
                    if (!txtMedID.getText().equalsIgnoreCase("") && !txtMedName.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Medicine set medicineName = \"" + txtMedName.getText()
                                + "\" WHERE medicineID = " + txtMedID.getText());
                                statment.execute();
                    }

                    // updates the price if not empty
                    if (!txtMedID.getText().equalsIgnoreCase("") && !txtPrice.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Medicine set price = " + txtPrice.getText()
                        + " WHERE medicineID = " + txtMedID.getText());
                        statment.execute();
                    }

                    // updates the quantity if not empty
                    if(!txtMedID.getText().equalsIgnoreCase("") && !txtQty.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE Medicine set quantity = " + txtQty.getText()
                        + " WHERE medicineID = " + txtMedID.getText());
                        statment.execute();
                    }
                    SuccessMessageFrame.create();
                    frame.setVisible(false);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    FailureMessageFrame.create();
                }
            }
        });
        btnUpdate.setBounds(80, 195, 89, 23);
        frame.add(btnUpdate);
    }
}
