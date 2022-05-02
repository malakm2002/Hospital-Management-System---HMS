package hmsGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Deletions.DeleteOther;
import hmsGUI.Deletions.DeleteStaff;

public class DeletionPage {

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
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 394);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        frame.getContentPane().setLayout(null);

        JButton btnDeleteOtherStaff = new JButton("Delete staff");
        btnDeleteOtherStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStaff.create();
            }
        });
        btnDeleteOtherStaff.setBounds(22, 32, 165, 23);
        contentPane.add(btnDeleteOtherStaff);

        JButton btnDeleteOther = new JButton("Delete other values");
        btnDeleteOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOther.create();
            }
        });
        btnDeleteOther.setBounds(22, 66, 165, 23);
        contentPane.add(btnDeleteOther);
    } 
}
