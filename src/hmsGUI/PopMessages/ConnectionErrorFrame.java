package hmsGUI.PopMessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ConnectionErrorFrame {
    /**
     * Creates a window that displays an error if log in fails
    */
    public static void Create() {
        // title
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
        frame.setResizable(true);
        // JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setBounds(40, 50, 400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblErrorMessage = new JLabel("Access Denied! Log In Again");
            lblErrorMessage.setBounds(43, 55, 180, 14);
            contentPane.add(lblErrorMessage);
            
            JButton lblOk = new JButton("OK");
            lblOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                frame.dispose();
                }
            });
            lblOk.setBounds(209, 94, 89, 23);
            contentPane.add(lblOk);
        }
    }
