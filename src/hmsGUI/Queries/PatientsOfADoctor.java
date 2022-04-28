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

public class PatientsOfADoctor {
    /* SELECT patientRecord.firstName FROM staffRecord INNER JOIN patientRecord ON staffRecord.staffID = patientRecord.staffID
	WHERE staffRecord.firstName = 'Ali' AND staffRecord.lastName = 'Hamad' */
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

        JLabel lblDoctorFirstName = new JLabel("Doctor First Name:");
        lblDoctorFirstName.setBounds(20, 20, 111, 14);
        contentPane.add(lblDoctorFirstName);

        JTextField input1 = new JTextField();
        input1.setBounds(20, 50, 124, 20);
        contentPane.add(input1);

        JLabel lblDoctorLastName = new JLabel("Doctor Last Name:");
        lblDoctorLastName.setBounds(20, 80, 111, 14);
        contentPane.add(lblDoctorLastName);

        JTextField input2 = new JTextField();
        input2.setBounds(20, 110, 124, 20);
        contentPane.add(input2);


        JButton button = new JButton("Find");
        button.setBounds(20, 140, 100, 30);
        contentPane.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        contentPane.add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input1.getText() == null) {
                    textArea.setText("Please input the doctor's first name");
                }
                if (input2.getText() == null){
                    textArea.setText("Please input the doctor's last name");
                } 
                else {
                    textArea.setText(getPatients(input1.getText(), input2.getText()));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBounds(220, 20, 340, 180);
        contentPane.add(scrollPane);
    }

    static String getPatients(String FirstName, String LastName) {
        String result = "";

        try {
            Statement PatientStmt = LogIn.connection.createStatement();

            ResultSet PatientRes = PatientStmt.executeQuery("SELECT PatientRecord.firstName FROM StaffRecord INNER JOIN PatientRecord ON StaffRecord.staffID = PatientRecord.staffID WHERE StaffRecord.firstName ='" + FirstName +  "'AND StaffRecord.lastName ='" + LastName +"'");

            while (PatientRes.next()) {
                    result += PatientRes.getString("firstName" + "\n");
                
            }

            PatientStmt.close();

            PatientRes.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
            result = e1.getMessage();
        }

        return result;
    }
}
