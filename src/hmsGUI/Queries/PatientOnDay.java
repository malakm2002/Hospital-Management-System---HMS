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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;

public class PatientOnDay {
    /**
     * Creates the page allowing viewing the patients checked in on a specific date
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Patients on Date");

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
        JLabel lblAdmission = new JLabel("Admission Date");
        lblAdmission.setBounds(20, 20, 111, 14);
        frame.add(lblAdmission);

        // input for the admission date
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(120, 20, 124, 20);
        frame.add(dateChooser);

        JButton button = new JButton("Find");
        button.setBounds(20, 50, 100, 30);
        frame.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        frame.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    textArea.setText("Please choose a date");
                } else {
                    // displays the results
                    textArea.setText(getPatients(parseDate(dateChooser.getDate())));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(260, 20, 300, 180);
        frame.add(scrollPane);
    }

    static String getPatients(String date) {
        String result = "";

        try {
            Statement staffStmt = LogIn.connection.createStatement();

            // returns a list of patients
            ResultSet staffRes = staffStmt.executeQuery("SELECT * FROM PATIENTRECORD");

            String temp;
            while (staffRes.next()) {
                temp = staffRes.getString("admissionDate");
                String[] tempList = temp.split(" ");
                // compares the admission date of the patient and selects only thos that match the chosen date
                if (tempList[0].compareTo(date) == 0) {
                    result += staffRes.getString("recordID") + ", ";
                    result += staffRes.getString("firstName") + " " + staffRes.getString("lastName") + ", ";
                    result += staffRes.getString("gender") + ", ";
                    result += staffRes.getString("address") + ", ";
                    result += staffRes.getString("phoneNumber") + ", ";
                    result += "discharge date: " + staffRes.getString("dischargeDate") + "\n";
                }
            }

            staffStmt.close();

            staffRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }

    // parses the date retrieved by MySQL ainto a format readable by JAVA
    public static String parseDate(java.util.Date date) {
        String[] parts = date.toString().split(" ");
        return parts[5] + "-" + parseMonth(parts[1]) + "-" + parts[2];
    }

    // returns the month as a number
    public static String parseMonth(String month) {
        if (month.equalsIgnoreCase("jan")) {
            return "01";
        }
        if (month.equalsIgnoreCase("feb")) {
            return "02";
        }
        if (month.equalsIgnoreCase("mar")) {
            return "03";
        }
        if (month.equalsIgnoreCase("apr")) {
            return "04";
        }
        if (month.equalsIgnoreCase("may")) {
            return "05";
        }
        if (month.equalsIgnoreCase("jun")) {
            return "06";
        }
        if (month.equalsIgnoreCase("jul")) {
            return "07";
        }
        if (month.equalsIgnoreCase("aug")) {
            return "08";
        }
        if (month.equalsIgnoreCase("sep")) {
            return "09";
        }
        if (month.equalsIgnoreCase("oct")) {
            return "10";
        }
        if (month.equalsIgnoreCase("nov")) {
            return "11";
        }
        if (month.equalsIgnoreCase("dec")) {
            return "12";
        }
        return null;
    }
}
