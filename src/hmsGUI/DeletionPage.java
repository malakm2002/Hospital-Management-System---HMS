package hmsGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import hmsGUI.Deletions.DeleteOther;
import hmsGUI.Deletions.DeleteStaff;

public class DeletionPage {
    /**
     * Creates the page containing all the buttons relating to delete operations
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Deletion Operations");
        
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
        frame.setBounds(100, 100, 450, 400);

        frame.getContentPane().setLayout(null);

        //set background image
        JLabel label = new JLabel(ManipulationOps.background);
        label.setBounds(0, 0, 400, 300);
        label.setOpaque(false);
        frame.setContentPane(label);
        
        // navigate to deleting a staff member
        JButton btnDeleteOtherStaff = new JButton("Delete staff");
        btnDeleteOtherStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStaff.create();
            }
        });
        btnDeleteOtherStaff.setContentAreaFilled(false);
        btnDeleteOtherStaff.setBounds(22, 32, 165, 23);
        frame.add(btnDeleteOtherStaff);

        // navigate to deleting other values (patients, rooms, bills, etc.)
        JButton btnDeleteOther = new JButton("Delete other values");
        btnDeleteOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOther.create();
            }
        });
        btnDeleteOther.setContentAreaFilled(false);
        btnDeleteOther.setBounds(22, 66, 165, 23);
        frame.add(btnDeleteOther);
    } 
}
