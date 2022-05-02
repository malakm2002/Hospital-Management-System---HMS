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
import hmsGUI.ManipulationOps;

public class DoctorsFromSpecialty {
    /**
     * Creates the page allowing viewing doctors of a specific specialty
     */
    public static void create() {
        // title
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
        JLabel label = new JLabel(ManipulationOps.queryback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        JLabel lblspecialty = new JLabel("Specialty:");
        lblspecialty.setBounds(20, 20, 111, 14);
        frame.add(lblspecialty);

        // input for the specialty
        JTextField input = new JTextField();
        input.setBounds(80, 20, 124, 20);
        frame.add(input);

        JButton button = new JButton("Find");
        button.setBounds(20, 50, 100, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        frame.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText() == null) {
                    textArea.setText("Please input a specialty");
                } else {
                    // displays the results
                    textArea.setText(getDoctors(input.getText()));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(220, 20, 340, 180);
        frame.add(scrollPane);
    }

    static String getDoctors(String specialty) {
        String result = "";

        try {
            Statement doctorStmt = LogIn.connection.createStatement();

            // retrieves the doctors of the provided specialty
            ResultSet doctorRes = doctorStmt.executeQuery("SELECT * FROM STAFFRECORD INNER JOIN DOCTOR ON specialty = '" + specialty + "' WHERE doctorID = staffID");

            // retrieves the results
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
