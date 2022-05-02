package hmsGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hmsGUI.PopMessages.ConnectionErrorFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LogIn {
	public static Connection connection;

	private JFrame frame;
	private JTextField usernameField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton logInbtn;
	private JPasswordField passwordField;
public static ImageIcon icon = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/hospital.jpg");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
	}

	public LogIn() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		ImageIcon icon = new ImageIcon("C:/Users/Malak/Desktop/AUB/Spring 2022/CMPS 277/projectDemo/HMS/src/hospital.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, 400, 400);
		contentPane.add(label);
		
		JLabel label1 = new JLabel();
		label1.setBounds(0, 400, 645, 100);label1.setOpaque(true);
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(420, 200, 100, 14);
		contentPane.add(usernameLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(420, 240, 100, 14);
		contentPane.add(passwordLabel);

		usernameField = new JTextField();
		usernameField.setBounds(500, 200, 170, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(500, 240, 170, 20);
		contentPane.add(passwordField);

		logInbtn = new JButton("LogIn");
		logInbtn.setBounds(480, 300, 100, 23);
		contentPane.add(logInbtn);
		logInbtn.addActionListener(l -> {
			Connector connector = new Connector();
			// connector.Connect(usernameField.getText(),
			// String.valueOf(passwordField.getPassword()));
			connector.Connect("root", "m@L@K2002");
			// connector.Connect("root", "HalfmylifeSQL3!");
			// connector.Connect("root", "Ivyleague123");
			if (connector.connected) {
				LogIn.connection = connector.connection;
				frame.dispose();
				ManipulationOps.createFrame();
			} else {
				ConnectionErrorFrame.Create();
			}

		});

	}
}
