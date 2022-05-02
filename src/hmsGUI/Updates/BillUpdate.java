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
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;
public class BillUpdate {
    public static void create(){
        JFrame frame = new JFrame();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        frame.setVisible(true);

        JLabel lblBillID = new JLabel("Bill ID");
        lblBillID.setBounds(33, 40, 49, 14);
        contentPane.add(lblBillID);

        JTextField txtBillID = new JTextField();
        txtBillID.setBounds(123, 37, 96, 20);
        contentPane.add(txtBillID);
        txtBillID.setColumns(10);

        JLabel lblStatus = new JLabel("Bill Status");
        lblStatus.setBounds(33, 74, 80, 14);
        contentPane.add(lblStatus);

        JTextField txtStatus = new JTextField();
        txtStatus.setColumns(10);
        txtStatus.setBounds(123, 71, 96, 20);
        contentPane.add(txtStatus);

        JLabel lblField = new JLabel("Field");
        lblField.setBounds(33, 110, 49, 14);
        contentPane.add(lblField);

        JTextField txtField = new JTextField();
        txtField.setBounds(123, 107, 96, 20);
        contentPane.add(txtField);
        txtField.setColumns(10);

        JLabel lblCharge = new JLabel("Charge");
        lblCharge.setBounds(33, 142, 49, 14);
        contentPane.add(lblCharge);

        JTextField txtCharge = new JTextField();
        txtCharge.setColumns(10);
        txtCharge.setBounds(123, 139, 96, 20);
        contentPane.add(txtCharge);

        JLabel lblCashier = new JLabel("Cashier ID");
        lblCashier.setBounds(33, 172, 60, 14);
        contentPane.add(lblCashier);

        JTextField txtCashier = new JTextField();
        txtCashier.setColumns(10);
        txtCashier.setBounds(123, 172, 96, 20);
        contentPane.add(txtCashier);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    CallableStatement statment;

                    if (!txtBillID.getText().equalsIgnoreCase("") && !txtStatus.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE bill set billStatus = \"" + txtStatus.getText()
                                + "\" WHERE billID = " + txtBillID.getText());
                                statment.execute();
                    }
                    if (!txtBillID.getText().equalsIgnoreCase("") && !txtField.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE bill set field = \"" + txtField.getText()
                        + "\" WHERE billID = " + txtBillID.getText());
                        statment.execute();
                    }
                    if(!txtBillID.getText().equalsIgnoreCase("") && !txtCharge.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE bill set charge = " + txtCharge.getText()
                        + " WHERE billID = " + txtBillID.getText());
                        statment.execute();
                    }
                    if(!txtBillID.getText().equalsIgnoreCase("") && !txtCashier.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE bill set charge = " + txtCharge.getText()
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
        contentPane.add(btnUpdate);
    }
    
}
