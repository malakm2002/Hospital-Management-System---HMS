package hmsGUI.Updates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hmsGUI.LogIn;

public class UpdateNurse {
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

        String[] list = (String[]) getTable().toArray();

        JComboBox<String> comboBox = new JComboBox<>(list);
        comboBox.setBounds(20, 20, 140, 20);
        contentPane.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateNurseScreen.create(comboBox.getSelectedItem().toString().split(",")[0]);
            }
        });

    }

    static List<String> getTable() {
        List<String> result = new ArrayList<>();
        try {
            String tempResult = "";

            Statement tableStmt = LogIn.connection.createStatement();

            ResultSet tableRes = tableStmt
                    .executeQuery("SELECT * FROM STAFFRECORD JOIN NURSE ON STAFFRECORD.staffID = NURSE.nurseID");

            while (tableRes.next()) {
                tempResult += tableRes.getString("staffID") + ", ";
                tempResult += tableRes.getString("firstName") + " " + tableRes.getString("lastName") + ", ";
                tempResult += tableRes.getString("phoneNumber") + "\n ";

                result.add(tempResult);
                tempResult = "";
            }

            tableRes.close();

            tableStmt.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }

        return result;
    }

    class UpdateNurseScreen {
        public static void create(String staffID) {

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

            TreeMap<String, String> infoMap = getNurseInfo(staffID);

            JLabel lblFN = new JLabel("First Name");
            lblFN.setBounds(10, 11, 96, 14);
            contentPane.add(lblFN);

            JTextField textFieldFN = new JTextField(infoMap.get("firstName"));
            textFieldFN.setBounds(10, 27, 96, 20);
            contentPane.add(textFieldFN);
            textFieldFN.setColumns(10);

            JLabel lblLN = new JLabel("Last Name");
            lblLN.setBounds(122, 11, 94, 14);
            contentPane.add(lblLN);

            JTextField textFieldLN = new JTextField(infoMap.get("lastName"));
            textFieldLN.setColumns(10);
            textFieldLN.setBounds(120, 27, 96, 20);
            contentPane.add(textFieldLN);

            JLabel lblGender = new JLabel("Sex");
            lblGender.setHorizontalAlignment(SwingConstants.CENTER);
            lblGender.setBounds(245, 11, 49, 14);
            contentPane.add(lblGender);

            JCheckBox chckbxMale = new JCheckBox("Male");
            chckbxMale.setBounds(290, 7, 54, 23);
            contentPane.add(chckbxMale);

            JCheckBox chckbxFemale = new JCheckBox("Female");
            chckbxFemale.setBounds(350, 7, 72, 23);
            contentPane.add(chckbxFemale);

            if (infoMap.get("gender").compareTo("M") == 0) {
                chckbxMale.setSelected(true);
                chckbxMale.setSelected(false);
            } else {
                chckbxMale.setSelected(false);
                chckbxMale.setSelected(true);
            }

            JLabel lblAddr = new JLabel("Address");
            lblAddr.setBounds(10, 58, 96, 14);
            contentPane.add(lblAddr);

            JTextField textFieldAddress = new JTextField(infoMap.get("address"));
            textFieldAddress.setColumns(10);
            textFieldAddress.setBounds(10, 73, 96, 20);
            contentPane.add(textFieldAddress);

            JLabel lblPhone = new JLabel("Phone Number");
            lblPhone.setBounds(122, 58, 94, 14);
            contentPane.add(lblPhone);

            JTextField textFieldPhone = new JTextField(infoMap.get("phoneNumber"));
            textFieldPhone.setBounds(120, 73, 96, 20);
            contentPane.add(textFieldPhone);
            textFieldPhone.setColumns(10);

            JLabel lblAdmission = new JLabel("Start Date");
            lblAdmission.setBounds(260, 40, 111, 14);
            contentPane.add(lblAdmission);

            JLabel lblDischarge = new JLabel("End Date");
            lblDischarge.setBounds(260, 73, 89, 14);
            contentPane.add(lblDischarge);

            // SET START DATE
            JDateChooser dateChooser = new JDateChooser();
            dateChooser.setBounds(360, 37, 124, 20);
            contentPane.add(dateChooser);

            // SET END DATE
            JDateChooser dateChooser_1 = new JDateChooser();
            dateChooser_1.setBounds(360, 73, 124, 20);
            contentPane.add(dateChooser_1);

            JButton updateButton = new JButton("Update");
            updateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String query = "UPDATE STAFFRECORD SET firstName = '?', lastName = '?', gender = '?', address = '?', phoneNumber = '?', startDate = '', endDate = '' WHERE staffID = ?";

                        PreparedStatement updateStatement = LogIn.connection.prepareStatement(query);

                        updateStatement.setString(1, textFieldFN.getText());
                        updateStatement.setString(2, textFieldLN.getText());
                        updateStatement.setString(3, chckbxMale.isSelected() ? "M" : "F");
                        updateStatement.setString(4, textFieldAddress.getText());

                        // try updateStatement.setInt() if the below statement doesn't work
                        updateStatement.setString(5, textFieldPhone.getText());
                        updateStatement.setString(6, "START DATE");
                        updateStatement.setString(7, "END DATE");

                        updateStatement.executeUpdate();

                        updateStatement.close();

                    } catch (SQLException error) {
                        error.printStackTrace();
                    }

                }
            });
            updateButton.setBounds(250, 150, 89, 23);
            contentPane.add(updateButton);
        }

        static TreeMap<String, String> getNurseInfo(String staffID) {
            TreeMap<String, String> result = new TreeMap<>();
            try {
                Statement tableStmt = LogIn.connection.createStatement();

                ResultSet tableRes = tableStmt
                        .executeQuery("SELECT * FROM STAFFRECORD WHERE STAFFRECORD.staffID = " + staffID);

                while (tableRes.next()) {
                    result.put("recordID", tableRes.getString("recordID"));
                    result.put("firstName", tableRes.getString("firstName"));
                    result.put("lastName", tableRes.getString("lastName"));
                    result.put("gender", tableRes.getString("gender"));
                    result.put("aaddress", tableRes.getString("address"));
                    result.put("phoneNumber", tableRes.getString("phoneNumber"));
                    result.put("startDate", tableRes.getString("startDate"));
                    result.put("endDate", tableRes.getString("endDate"));
                    result.put("staffId", tableRes.getString("staffID"));
                }

                tableRes.close();

                tableStmt.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }

            return result;

        }

        public static String parseDateTime(java.util.Date date) {
            String[] parts = date.toString().split(" ");
            return parts[5] + "-" + parseMonth(parts[1]) + "-" + parts[2] + " " + parts[3];
        }

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
}
