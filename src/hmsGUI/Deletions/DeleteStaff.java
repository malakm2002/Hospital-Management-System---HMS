package hmsGUI.Deletions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hmsGUI.Connector;
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

        JTextArea tAreaCurrentTable = new JTextArea(getStaffTable(comboBox.getSelectedItem().toString()));
        tAreaCurrentTable.setLineWrap(true);
        contentPane.add(tAreaCurrentTable);

        JScrollPane scrollPane = new JScrollPane(tAreaCurrentTable);

        scrollPane.setBounds(180, 20, 150, 150);
        contentPane.add(scrollPane);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tAreaCurrentTable.setText(getStaffTable(comboBox.getSelectedItem().toString()));
            }
        });


    }

    public static String getStaffTable(String table) {
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

            ResultSet tableRes = tableStmt.executeQuery("SELECT * FROM " + table);
            ResultSet staffRes = staffStmt.executeQuery("SELECT * FROM STAFF");

            TreeMap<String, String> staffMap = new TreeMap<>();
            while (staffRes.next()) {
                staffMap.put(staffRes.getString("staffID"), staffRes.getString("jobType"));
            }

            Map<String, String> tableMap = new TreeMap<>();
            String temp;
            while (tableRes.next()) {
                temp = tableRes.getString(accessID);
                tableMap.put(temp, staffMap.get(temp));
            }
            for (Map.Entry<String, String> entry : tableMap.entrySet()) {
                result += entry.getKey() + ", " + entry.getValue() + "\n";
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
