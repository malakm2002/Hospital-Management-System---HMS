package hmsGUI.Deletions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;

public class DeleteStaff {
    public static void create() {
        String[] options = { "Nurse", "Janitor", "Cashier", "Doctor" };

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
        frame.setBounds(100, 100, 600, 260);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(20, 20, 140, 20);

        JLabel label = new JLabel("Enter ID:");
        label.setBounds(20, 50, 140, 20);

        JTextField idInput = new JTextField();
        idInput.setBounds(20, 70, 140, 20);

        JButton jButton = new JButton("Delete");
        jButton.setBounds(20, 110, 90, 20);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(idInput.getText(), comboBox.getSelectedItem().toString());
            }
        });

        JTextArea jTextArea = new JTextArea(getStaffTable(comboBox.getSelectedItem().toString()));
        jTextArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(jTextArea);

        scrollPane.setBounds(180, 20, 250, 150);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText(getStaffTable(comboBox.getSelectedItem().toString()));
            }
        });

        contentPane.add(jButton);
        contentPane.add(comboBox);
        contentPane.add(label);
        contentPane.add(idInput);
        contentPane.add(scrollPane);

        frame.setLayout(null);
        frame.setSize(465, 250);
        frame.setVisible(true);

    }

    static void delete(String ID, String type) {
        try {
            CallableStatement statement;
            switch (type) {
                case "Nurse":
                    statement = LogIn.connection.prepareCall("{call DeleteNurse(?)}");
                    break;
                case "Janitor":
                    statement = LogIn.connection.prepareCall("{call DeleteJanitor(?)}");
                    break;
                case "Cashier":
                    statement = LogIn.connection.prepareCall("{call DeleteCashier(?)}");
                    break;
                case "Doctor":
                    statement = LogIn.connection.prepareCall("{call DeleteDoctor(?)}");
                    break;
                default:
                    statement = LogIn.connection.prepareCall("{call DeleteNurse(?)}");
                    break;
            }

            
            statement.setString(1, ID);

            statement.execute();
            statement.close();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    static String getStaffTable(String table) {
        String result = "";
        String accessID = "nurseID";

        try {
            switch (table) {
                case "Nurse":
                    accessID = "nurseID";
                    break;
                case "Janitor":
                    accessID = "janitorID";
                    break;
                case "Cashier":
                    accessID = "cashierID";
                    break;
                case "Doctor":
                    accessID = "doctorID";
                    break;
            }

            Statement tableStmt = LogIn.connection.createStatement();
            Statement staffStmt = LogIn.connection.createStatement();
            Statement recordStmt = LogIn.connection.createStatement();

            ResultSet tableRes = tableStmt.executeQuery("SELECT * FROM " + table);
            ResultSet staffRes = staffStmt.executeQuery("SELECT * FROM STAFF");
            ResultSet recordRes = recordStmt.executeQuery("SELECT * FROM RECORD");

            TreeMap<String, String> staffMap = new TreeMap<>();
            while (staffRes.next()) {
                staffMap.put(staffRes.getString("staffID"), staffRes.getString("jobType"));
            }

            TreeMap<String, String> recordMap = new TreeMap<>();
            while (recordRes.next()) {
                recordMap.put(recordRes.getString("staffID"),
                        recordRes.getString("firstName") + " " + recordRes.getString("lastName"));
            }

            Map<String, List<String>> tableMap = new TreeMap<>();
            String temp;

            while (tableRes.next()) {
                ArrayList<String> tempList = new ArrayList<>();

                temp = tableRes.getString(accessID);
                tempList.add(temp);

                tempList.add(staffMap.get(temp));

                tempList.add(recordMap.get(temp));
                tableMap.put(temp, tempList);
            }

            for (Map.Entry<String, List<String>> entry : tableMap.entrySet()) {
                for (String i : entry.getValue())
                    result += i + ", ";

                result += "\n";
            }

            tableStmt.close();
            staffStmt.close();

            tableRes.close();
            staffRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }

}
