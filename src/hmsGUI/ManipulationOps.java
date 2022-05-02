package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ManipulationOps {
    public static void createFrame() {
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
        frame.setBounds(100, 100, 450, 394);
        JLabel label = new JLabel(LogIn.icon);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.getContentPane().setLayout(null);
        frame.setContentPane(label);

        
        JButton btnInsertionPage = new JButton("Insert");
        btnInsertionPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertionPage.create();

            }
        });
        btnInsertionPage.setContentAreaFilled(false);
        btnInsertionPage.setBorderPainted(true);
        btnInsertionPage.setBounds(60, 20, 130, 23);
        frame.getContentPane().add(btnInsertionPage);

        JButton btnDeletionPage = new JButton("Delete");
        btnDeletionPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletionPage.create();
            }
        });
        btnDeletionPage.setContentAreaFilled(false);
        btnDeletionPage.setBorderPainted(true);
        btnDeletionPage.setBounds(13, 65, 130, 23);
        frame.getContentPane().add(btnDeletionPage);

        JButton btnQueriesPage = new JButton("Query");
        btnQueriesPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueriesPage.create();
            }
        });
        btnQueriesPage.setBounds(230, 13, 130, 23);
        btnQueriesPage.setContentAreaFilled(false);
        btnQueriesPage.setBorderPainted(true);
        frame.getContentPane().add(btnQueriesPage);

        JButton btnUpdatePage = new JButton("Update");
        btnUpdatePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePage.create();
            }
        });
        btnUpdatePage.setBounds(285, 68, 130, 23);
        frame.getContentPane().add(btnUpdatePage);
        btnUpdatePage.setContentAreaFilled(false);
        btnUpdatePage.setBorderPainted(true);
    }
}