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

public class BillUpdate {
    /**
     * Creates the page allowing bill updates
     */
    public static void create(){
        JFrame frame = new JFrame();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);

        JLabel lblBillID = new JLabel("Bill ID");
        lblBillID.setBounds(33, 40, 49, 14);
        frame.add(lblBillID);

        // input for the bill's ID
        JTextField txtBillID = new JTextField();
        txtBillID.setBounds(123, 37, 96, 20);
        frame.add(txtBillID);
        txtBillID.setColumns(10);

        JLabel lblStatus = new JLabel("Bill Status");
        lblStatus.setBounds(33, 74, 80, 14);
        frame.add(lblStatus);

        // input for the bill's status
        JTextField txtStatus = new JTextField();
        txtStatus.setColumns(10);
        txtStatus.setBounds(123, 71, 96, 20);
        frame.add(txtStatus);

        JLabel lblField = new JLabel("Field");
        lblField.setBounds(33, 110, 49, 14);
        frame.add(lblField);

        // input for the bill's field
        JTextField txtField = new JTextField();
        txtField.setBounds(123, 107, 96, 20);
        frame.add(txtField);
        txtField.setColumns(10);

        JLabel lblCharge = new JLabel("Charge");
        lblCharge.setBounds(33, 142, 49, 14);
        frame.add(lblCharge);

        // input for the bill's charge
        JTextField txtCharge = new JTextField();
        txtCharge.setColumns(10);
        txtCharge.setBounds(123, 139, 96, 20);
        frame.add(txtCharge);

        JLabel lblCashier = new JLabel("Cashier ID");
        lblCashier.setBounds(33, 172, 60, 14);
        frame.add(lblCashier);

        // input for the responsible cashier's ID
        JTextField txtCashier = new JTextField();
        txtCashier.setColumns(10);
        txtCashier.setBounds(123, 172, 96, 20);
        frame.add(txtCashier);

        // button that executes the necessary update
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // to contain the SQL query
                    CallableStatement statment;

                    // updates the status if not empty
                    if (!txtBillID.getText().equalsIgnoreCase("") && !txtStatus.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE bill set billStatus = \"" + txtStatus.getText()
                                + "\" WHERE billID = " + txtBillID.getText());
                                statment.execute();
                    }

                    // updates the field if not empty
                    if (!txtBillID.getText().equalsIgnoreCase("") && !txtField.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE bill set field = \"" + txtField.getText()
                        + "\" WHERE billID = " + txtBillID.getText());
                        statment.execute();
                    }

                    // updates the charge if not empty
                    if(!txtBillID.getText().equalsIgnoreCase("") && !txtCharge.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE bill set charge = " + txtCharge.getText()
                        + " WHERE billID = " + txtBillID.getText());
                        statment.execute();
                    }

                    // updates the cashier's ID if not empty
                    if(!txtBillID.getText().equalsIgnoreCase("") && !txtCashier.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE bill set cashierID = " + txtCashier.getText()
                        + " WHERE billID = " + txtBillID.getText());
                        statment.execute();
                    }
                    SuccessMessageFrame.create();
                    frame.setVisible(false);

                } catch (Exception exception) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnUpdate.setBounds(80, 220, 95, 23);
        frame.add(btnUpdate);
    }
    
}
