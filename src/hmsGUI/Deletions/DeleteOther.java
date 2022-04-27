package hmsGUI.Deletions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import hmsGUI.LogIn;

public class DeleteOther {
    public static void create() {
        String[] options = { "Room", "Bill", "Patient", "Medicine", "Record" };

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
        frame.setSize(365, 250);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 260);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(20, 20, 140, 20);
        contentPane.add(comboBox);

        JLabel label = new JLabel("Enter ID:");
        label.setBounds(20, 50, 140, 20);
        contentPane.add(label);

        JTextField idInput = new JTextField();
        idInput.setBounds(20, 70, 140, 20);
        contentPane.add(idInput);

        JButton jButton = new JButton("Delete");
        jButton.setBounds(20, 110, 90, 20);
        contentPane.add(jButton);

        JTextArea jArea = new JTextArea(getTable(comboBox.getSelectedItem().toString()));
        jArea.setLineWrap(true);
        contentPane.add(jArea);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(idInput.getText(), comboBox.getSelectedItem().toString());
                jArea.setText(getTable(comboBox.getSelectedItem().toString()));
            }
        });

        JScrollPane scrollPane = new JScrollPane(jArea);

        scrollPane.setBounds(180, 20, 390, 150);
        contentPane.add(scrollPane);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jArea.setText(getTable(comboBox.getSelectedItem().toString()));
            }
        });

    }

    static void delete(String ID, String type) {
        try {
            CallableStatement statement;
            switch (type) {
                case "Room":
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteRoom(?)}");
                    break;
                case "Bill":
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteBill(?)}");
                    break;
                case "Patient":
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeletePatient(?)}");
                    break;
                case "Medicine":
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteMedicine(?)}");
                    break;
                case "Record":
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteRecord(?)}");
                    break;
                default:
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteRoom(?)}");
                    break;
            }

            statement.setString(1, ID);

            statement.execute();
            statement.close();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    static String getTable(String table) {
        String result = "";

        try {

            Statement tableStmt = LogIn.connection.createStatement();

            ResultSet tableRes = tableStmt.executeQuery("SELECT * FROM " + table);

            switch (table) {
                case "Room":
                    while (tableRes.next()) {
                        result += tableRes.getString("roomID") + ", ";
                        result += tableRes.getString("roomType") + ", ";
                        result += "nurse: " + tableRes.getString("nurseID") + ", ";
                        result += "janitor: " + tableRes.getString("janitorID") + "\n";
                    }
                    break;
                case "Bill":
                    while (tableRes.next()) {
                        result += tableRes.getString("billID") + ", ";
                        result += tableRes.getString("billStatus") + ", ";
                        result += "$" + tableRes.getString("charge") + ", ";
                        result += "field: " + tableRes.getString("field") + ", ";
                        result += "cashier: " + tableRes.getString("cashierID") + "\n";
                    }
                    break;
                case "Patient":
                    while (tableRes.next()) {
                        result += tableRes.getString("patientID") + ", ";
                        result += tableRes.getString("diagnosis") + ", ";
                        result += "room: " + tableRes.getString("roomID") + "\n";
                    }
                    break;
                case "Medicine":
                    while (tableRes.next()) {
                        result += tableRes.getString("medicineID") + ", ";
                        result += tableRes.getString("medicineName") + ", ";
                        result += tableRes.getString("quantity") + ", ";
                        result += "$" + tableRes.getString("price") + "\n";
                    }
                    break;
                case "Record":
                    while (tableRes.next()) {
                        result += tableRes.getString("recordID") + ", ";
                        result += tableRes.getString("firstName") + " " + tableRes.getString("lastName") + ", ";
                        result += tableRes.getString("gender") + ", ";
                        result += tableRes.getString("address") + ", ";
                        result += tableRes.getString("phoneNumber") + ", ";
                        result += tableRes.getString("admissionDate") + ", ";
                        result += tableRes.getString("dischargeDate") + ", ";
                        result += "patient: " + tableRes.getString("patientID") + ", ";
                        result += "staff: " + tableRes.getString("staffID") + "\n";
                    }
                    break;
            }

            tableRes.close();

            tableStmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }
}
