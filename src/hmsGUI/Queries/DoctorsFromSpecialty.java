package hmsGUI.Queries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;

public class DoctorsFromSpecialty {
    public static void create() {
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

        JLabel lblspecialty = new JLabel("Specialty:");
        lblspecialty.setBounds(20, 20, 111, 14);
        contentPane.add(lblspecialty);

        JTextField input = new JTextField();
        input.setBounds(80, 20, 124, 20);
        contentPane.add(input);

        JButton button = new JButton("Find");
        button.setBounds(20, 50, 100, 30);
        contentPane.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        contentPane.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText() == null) {
                    textArea.setText("Please input a specialty");
                } else {
                    textArea.setText(getDoctors(input.getText()));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(220, 20, 340, 180);
        contentPane.add(scrollPane);
    }

    static String getDoctors(String specialty) {
        String result = "";

        try {
            Statement doctorStmt = LogIn.connection.createStatement();

            ResultSet doctorRes = doctorStmt.executeQuery("SELECT * FROM STAFFRECORD INNER JOIN DOCTOR ON specialty = '" + specialty + "' WHERE doctorID = staffID");

            while (doctorRes.next()) {
                    result += doctorRes.getString("firstName") + " " + doctorRes.getString("lastName") + ", ";
                    result += doctorRes.getString("gender") + ", ";
                    result += doctorRes.getString("address") + ", ";
                    result += doctorRes.getString("phoneNumber") + "\n";
                
            }

            doctorStmt.close();

            doctorRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }
}
