package hmsGUI.Deletions;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.cj.jdbc.CallableStatement;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;

public class DeleteOther {
    /**
     * Creates the page allowing pateint deletions of patients, rooms, bills, etc.
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Delete Room, Bill, Patient, Medicine");
        
        String[] options = { "Room", "Bill", "Patient", "Medicine" };

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
        frame.setSize(365, 250);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 260);
        JLabel label = new JLabel(ManipulationOps.deletionback);
        label.setBounds(0, 0, 400, 300);
        label.setOpaque(false);
        frame.setContentPane(label);
        


        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(20, 20, 140, 20);
        frame.add(comboBox);

        JLabel labelID = new JLabel("Enter ID:");
        labelID.setBounds(20, 50, 140, 20);
        frame.add(labelID);

        // input for the ID
        JTextField idInput = new JTextField();
        idInput.setBounds(20, 70, 140, 20);
        frame.add(idInput);

        JButton jButton = new JButton("Delete");
        jButton.setBounds(20, 110, 90, 20);
        frame.add(jButton);

        // displays the initial result (of the first element in the list)
        JTextArea jArea = new JTextArea(getTable(comboBox.getSelectedItem().toString()));
        jArea.setLineWrap(true);
        frame.add(jArea);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(idInput.getText(), comboBox.getSelectedItem().toString());

                // displays the selected item
                jArea.setText(getTable(comboBox.getSelectedItem().toString()));
            }
        });

        JScrollPane scrollPane = new JScrollPane(jArea);

        scrollPane.setBounds(180, 20, 390, 150);
        scrollPane.setFont(new Font("Times New Roman", Font.BOLD,12));
        frame.add(scrollPane);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // displays the result
                jArea.setText(getTable(comboBox.getSelectedItem().toString()));
            }
        });

    }

    // deletes the selected record
    static void delete(String ID, String type) {
        try {
            CallableStatement statement;

            // chooses the required stored procedure
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
                default:
                    statement = (CallableStatement) LogIn.connection.prepareCall("{call DeleteRoom(?)}");
                    break;
            }

            statement.setString(1, ID);

            // executes the deletion
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

            // returns all records from the provided input
            ResultSet tableRes = tableStmt.executeQuery("SELECT * FROM " + table);

            // chooses attributes specific to the provided input
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
