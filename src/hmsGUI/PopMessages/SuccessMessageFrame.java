package hmsGUI.PopMessages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessMessageFrame {
    /**
     * Creates a window that displays an error if an operation (insertion, deletion, update, or query/retrieval) succeeds
    */
    public static void create(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 312, 210);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
        frame.setVisible(true);
		
		JLabel lblAddedSuccesfully = new JLabel("Operation is done Successfully !");
		lblAddedSuccesfully.setBounds(42, 60, 170, 19);
		contentPane.add(lblAddedSuccesfully);
		
		JButton lblOK = new JButton("Ok");
		lblOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
			}
		});
		lblOK.setBounds(164, 90, 89, 23);
		contentPane.add(lblOK);
    }
    
}
