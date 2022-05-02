package hmsGUI.Updates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.LogIn;
import hmsGUI.ManipulationOps;
import hmsGUI.PopMessages.FailureMessageFrame;
import hmsGUI.PopMessages.SuccessMessageFrame;

public class RoomUpdate {
    /**
     * Creates the page allowing room updates
     */
    public static void create() {
        JFrame frame = new JFrame();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);
        JLabel label = new JLabel(ManipulationOps.updateback);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);
        frame.setVisible(true);
        frame.setResizable(false);

        JLabel lblRoomID = new JLabel("RoomID");
        lblRoomID.setBounds(33, 40, 49, 14);
        frame.add(lblRoomID);

        // input for the room's ID
        JTextField txtRoomID = new JTextField();
        txtRoomID.setBounds(113, 37, 96, 20);
        frame.add(txtRoomID);
        txtRoomID.setColumns(10);

        JLabel lblRoomType = new JLabel("Room Type");
        lblRoomType.setBounds(33, 74, 80, 14);
        frame.add(lblRoomType);

        // input for the room's type
        JTextField txtRoomType = new JTextField();
        txtRoomType.setColumns(10);
        txtRoomType.setBounds(113, 71, 96, 20);
        frame.add(txtRoomType);

        JLabel lblNurse = new JLabel("Nurse ID");
        lblNurse.setBounds(33, 110, 49, 14);
        frame.add(lblNurse);

        // input for the responsible nurse's ID
        JTextField txtNurse = new JTextField();
        txtNurse.setBounds(113, 107, 96, 20);
        frame.add(txtNurse);
        txtNurse.setColumns(10);

        JLabel lblJanitor = new JLabel("Janitor ID");
        lblJanitor.setBounds(33, 142, 49, 14);
        frame.add(lblJanitor);

        // input for the responsible janitor's ID
        JTextField txtJanitor = new JTextField();
        txtJanitor.setColumns(10);
        txtJanitor.setBounds(113, 139, 96, 20);
        frame.add(txtJanitor);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // to contain the SQL query
                    CallableStatement statment;

                    // updates the room's type if not empty
                    if (!txtRoomID.getText().equalsIgnoreCase("") && !txtRoomType.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Room set roomType = \"" + txtRoomType.getText()
                                + "\" WHERE roomID = " + txtRoomID.getText());
                                statment.execute();
                    }

                    // updates the nurse's ID if not empty
                    if (!txtRoomID.getText().equalsIgnoreCase("") && !txtNurse.getText().equalsIgnoreCase("")) {
                        statment = LogIn.connection.prepareCall("UPDATE Room set nurseID = " + txtNurse.getText()
                        + " WHERE roomID = " + txtRoomID.getText());
                        statment.execute();
                    }

                    // updates the janitor's ID if not empty
                    if(!txtRoomID.getText().equalsIgnoreCase("") && !txtJanitor.getText().equalsIgnoreCase("")){
                        statment = LogIn.connection.prepareCall("UPDATE Room set janitorID = " + txtJanitor.getText()
                        + " WHERE roomID = " + txtRoomID.getText());
                        statment.execute();
                    }
                    SuccessMessageFrame.create();
                    frame.setVisible(false);

                } catch (Exception exception) {
                    FailureMessageFrame.create();
                }
            }
        });
        btnUpdate.setBounds(80, 195, 89, 23);
        frame.add(btnUpdate);
    }
}
