package hmsGUI.Updates;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TableView;

public class UpdateStaff {
    public static TreeMap<String, List<String>> tables = new TreeMap<>();

    public static void create() {
        tables.put("Nurse", List.of("firstName", "lastName", "gender", "address", "phoneNumber", "startDate", "endDate",
                "jobType", "supervisorID"));
        tables.put("Janitor", List.of("firstName", "lastName", "gender", "address", "phoneNumber", "startDate",
                "endDate", "jobType", "supervisorID"));
        tables.put("Cashier", List.of("firstName", "lastName", "gender", "address", "phoneNumber", "startDate",
                "endDate", "jobType", "supervisorID"));
        tables.put("Doctor", List.of("firstName", "lastName", "gender", "address", "phoneNumber", "startDate",
                "endDate", "jobType", "supervisorID", "specialty"));
        tables.put("Room", List.of("roomType", "nurseID", "janitorID"));
        tables.put("Bill", List.of("billStatus", "field", "charge", "cashierID"));
        tables.put("Patient", List.of("firstName", "lastName", "gender", "address", "phoneNumber", "admissionDate",
                "dischargeDate", "diagnosis", "roomID"));
        tables.put("Medicine", List.of("medicineName", "price", "quantity"));
        String[] options = { "Nurse", "Janitor", "Cashier", "Doctor","Room","Bill","Patient","Medicine"};

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> tablesCols = new JComboBox<>(options);
        tablesCols.setBounds(20, 20, 140, 20);
        contentPane.add(tablesCols);
        
        String[] fields = getFields(tablesCols.getSelectedItem().toString());
        JComboBox<String> fieldscombox = new JComboBox<>(fields);
        fieldscombox.setBounds(20, 50, 140, 20);
        contentPane.add(fieldscombox);

        JButton updatebtn = new JButton("Update");
        updatebtn.setBounds(120, 120, 89, 23);
        contentPane.add(updatebtn);
        updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println(tablesCols.getSelectedItem().toString());
            }
        });

    }

    public static String[] getFields(String table) {
        String[] fields = new String[15];
        int j = 0;
        for (var i : tables.entrySet()) {
            if (table.equalsIgnoreCase(i.getKey())) {
                for (var field : i.getValue()) {
                    fields[j] = field;
                    j++;
                }
            }
        }
        return fields;
    }
}
