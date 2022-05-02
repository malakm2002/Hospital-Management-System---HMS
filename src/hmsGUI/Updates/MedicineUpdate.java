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
public class MedicineUpdate {
    public static void create() {
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

        JLabel lblMedID = new JLabel("Medicine ID");
        lblMedID.setBounds(33, 40, 80, 14);
        contentPane.add(lblMedID);

        JTextField txtMedID = new JTextField();
        txtMedID.setBounds(113, 37, 96, 20);
        contentPane.add(txtMedID);
        txtMedID.setColumns(10);

        JLabel lblMedName = new JLabel("Name");
        lblMedName.setBounds(33, 74, 80, 14);
        contentPane.add(lblMedName);

        JTextField txtMedName = new JTextField();
        txtMedName.setColumns(10);
        txtMedName.setBounds(113, 71, 96, 20);
        contentPane.add(txtMedName);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(33, 110, 49, 14);
        contentPane.add(lblPrice);

        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(113, 107, 96, 20);
        contentPane.add(txtPrice);
        txtPrice.setColumns(10);

        JLabel lblqty = new JLabel("Quantity");
        lblqty.setBounds(33, 142, 49, 14);
        contentPane.add(lblqty);

        JTextField txtQty = new JTextField();
        txtQty.setColumns(10);
        txtQty.setBounds(113, 139, 96, 20);
        contentPane.add(txtQty);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    CallableStatement statment;

                    if (!txtMedID.getText().equalsIgnoreCase("") && !txtMedName.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Medicine set medicineName = \"" + txtMedName.getText()
                                + "\" WHERE medicineID = " + txtMedID.getText());
                                statment.execute();
                    }
                    if (!txtMedID.getText().equalsIgnoreCase("") && !txtPrice.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Medicine set price = " + txtPrice.getText()
                        + " WHERE medicineID = " + txtMedID.getText());
                        statment.execute();
                    }
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
        contentPane.add(btnUpdate);
    }
}
