package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
        frame.setBounds(100, 100, 700, 394);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        frame.getContentPane().setLayout(null);

        JButton btnInsertionPage = new JButton("Insertions");
        btnInsertionPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertionPage.create();

            }
        });
        btnInsertionPage.setBounds(22, 32, 165, 23);
        contentPane.add(btnInsertionPage);

        JButton btnDeletionPage = new JButton("Deletions");
        btnDeletionPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletionPage.create();
            }
        });
        btnDeletionPage.setBounds(22, 64, 165, 23);
        contentPane.add(btnDeletionPage);

        JButton btnQueriesPage = new JButton("Queries");
        btnQueriesPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueriesPage.create();
            }
        });
        btnQueriesPage.setBounds(22, 96, 165, 23);
        contentPane.add(btnQueriesPage);

        JButton btnUpdatePage = new JButton("Updates");
        btnUpdatePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePage.create();
            }
        });
        btnUpdatePage.setBounds(22, 128, 165, 23);
        contentPane.add(btnUpdatePage);
    }
}
