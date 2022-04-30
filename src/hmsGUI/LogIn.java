package hmsGUI;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;

public class LogIn {
	public static Connection connection;

	private JFrame frame;
	private JTextField usernameField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton logInbtn;
	private JPasswordField passwordField;

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
		frame.setBounds(100, 100, 333, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		usernameLabel = new JLabel("Enter Username");
		usernameLabel.setBounds(10, 11, 100, 14);
		frame.getContentPane().add(usernameLabel);

		passwordLabel = new JLabel("Enter Password");
		passwordLabel.setBounds(162, 11, 100, 14);
		frame.getContentPane().add(passwordLabel);

		usernameField = new JTextField();
		usernameField.setBounds(10, 36, 96, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 36, 79, 20);
		frame.getContentPane().add(passwordField);

		logInbtn = new JButton("LogIn");
		logInbtn.setBounds(89, 75, 89, 23);
		frame.getContentPane().add(logInbtn);
		logInbtn.addActionListener(l -> {
			Connector connector = new Connector();
			// connector.Connect(usernameField.getText(),
			// String.valueOf(passwordField.getPassword()));
			connector.Connect("root", "okay");
			// connector.Connect("root", "HalfmylifeSQL3!");
			if (connector.connected) {
				LogIn.connection = connector.connection;
				frame.dispose();
				ManipulationOps.createFrame();
			} else {
				ErrorFrame.Create();
			}

		});

	}
}
