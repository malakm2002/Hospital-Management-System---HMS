package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class ManipulationOps {
    public static ImageIcon background = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/background.jpg");
    public static ImageIcon deletionback = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/deletionback.jpg");
    public static ImageIcon insertionback = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/insertionback.jpg");
    public static ImageIcon updateback = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/updateback.jpg");
    public static ImageIcon queryback = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/queryback.jpg");


    /**
     * Creates the page containing all the buttons relating to CRUD operations
     * Through this page, you can navigate to insertions, deletions, updates, and retrievals
     */
    public static void createFrame() {
        // title
        JFrame frame = new JFrame("Hospital Management System - Operations");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 450, 400);

        JLabel label = new JLabel(LogIn.icon);
        label.setBounds(0, 0, 700, 400);
        label.setOpaque(false);
        frame.setContentPane(label);

        // navigate to the page containing all the insert operations
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

        // navigate to the page containing all the delete operations
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

        // navigate to the page containing all the query/retrieval operations
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

        // navigate to the page containing all the update operations
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