package hmsGUI.Updates;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;

public class TreatUpdate {
    /**
     * Creates the page allowing pateint record updates
     */
    public static void create() {
        JFrame frame = new JFrame("HMS - update treatment");
        frame.setBounds(100, 100, 450, 300);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        frame.setVisible(true);
        frame.setResizable(false);

        JLabel lblPatient = new JLabel("Patient ID");
        lblPatient.setBounds(40, 43, 73, 14);
        frame.add(lblPatient);

        JLabel lblDoctor = new JLabel("Doctor ID");
        lblDoctor.setBounds(40, 68, 73, 14);
        frame.add(lblDoctor);

        JLabel lblMed = new JLabel("Medicine ID");
        lblMed.setBounds(40, 96, 73, 14);
        frame.add(lblMed);

        // input for the patient's ID
        JTextField txtPatient = new JTextField();
        txtPatient.setBounds(102, 40, 96, 20);
        frame.add(txtPatient);
        txtPatient.setColumns(10);

        // input for the patient's doctor (ID)
        JTextField txtDoc = new JTextField();
        txtDoc.setColumns(10);
        txtDoc.setBounds(102, 65, 96, 20);
        frame.add(txtDoc);

        // input for the patient's medicine (ID)
        JTextField txtMed = new JTextField();
        txtMed.setColumns(10);
        txtMed.setBounds(102, 93, 96, 20);
        frame.add(txtMed);

        JButton btnUpd = new JButton("Update");
        btnUpd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // to contain the SQL query
                    CallableStatement statement;

                    // updates the patient's doctor if not empty
                    if (!txtPatient.getText().equalsIgnoreCase("") && !txtDoc.getText().equalsIgnoreCase("")) {
                        statement = LogIn.connection.prepareCall("Update treat set doctorID = " + txtDoc.getText()
                                + "where patientID = " + txtPatient.getText());
                        statement.execute();
                    } 
                 
                    // updates the patient's medicine if not empty
                    else{
                        if (!txtPatient.getText().equalsIgnoreCase("") && !txtMed.getText().equalsIgnoreCase("")) {
                            statement = LogIn.connection.prepareCall("Update treat set medicineID = " + txtMed.getText()
                                    + "where patientID = " + txtPatient.getText());
                            statement.execute();

                        }
                    }
                    SuccessMessageFrame.create();
                    frame.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FailureMessageFrame.create();
                }
            }
        });
        btnUpd.setBounds(73, 141, 89, 23);
        frame.add(btnUpd);
    }
}
