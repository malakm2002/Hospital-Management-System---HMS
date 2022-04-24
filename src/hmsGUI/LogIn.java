package hmsGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;

public class LogIn {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton logInbtn;

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

		passwordField = new JTextField();
		passwordField.setBounds(162, 36, 96, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);

		logInbtn = new JButton("LogIn");
		logInbtn.setBounds(89, 75, 89, 23);
		frame.getContentPane().add(logInbtn);
		logInbtn.addActionListener(l -> {
			Connector connector = new Connector();
			connector.Connect(usernameField.getText(), passwordField.getText());
			if(connector.connected){
				frame.dispose();
				ManipulationOps.createFrame();
			}
			else{
				ErrorFrame.Create();
			}
			
		});

	}
}
