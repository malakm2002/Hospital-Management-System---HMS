package hmsGUI.Insertions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class StaffInsertion {
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

		JLabel lblFN = new JLabel("First Name");
		lblFN.setBounds(10, 11, 96, 14);
		contentPane.add(lblFN);

		JTextField textFieldFN = new JTextField();
		textFieldFN.setBounds(10, 27, 96, 20);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);

		JLabel lblLN = new JLabel("Last Name");
		lblLN.setBounds(122, 11, 94, 14);
		contentPane.add(lblLN);

		JTextField textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(120, 27, 96, 20);
		contentPane.add(textFieldLN);

		JLabel lblGender = new JLabel("Sex");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(245, 11, 49, 14);
		contentPane.add(lblGender);

		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setBounds(290, 7, 54, 23);
		contentPane.add(chckbxMale);

		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBounds(350, 7, 72, 23);
		contentPane.add(chckbxFemale);

		JLabel lblAddr = new JLabel("Address");
		lblAddr.setBounds(10, 58, 96, 14);
		contentPane.add(lblAddr);

		JTextField textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(10, 73, 96, 20);
		contentPane.add(textFieldAddress);

		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(122, 58, 94, 14);
		contentPane.add(lblPhone);

		JTextField textFieldPhone = new JTextField();
		textFieldPhone.setBounds(120, 73, 96, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblAdmission = new JLabel("Admission Date");
		lblAdmission.setBounds(260, 40, 111, 14);
		contentPane.add(lblAdmission);

		JLabel lblDischarge = new JLabel("Discharge Date");
		lblDischarge.setBounds(260, 73, 89, 14);
		contentPane.add(lblDischarge);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(360, 37, 124, 20);
		contentPane.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(360, 73, 124, 20);
		contentPane.add(dateChooser_1);

		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("ad: " + dateChooser.getDate().toString());
					System.out.println("dis: " + dateChooser_1.getDate().toString());
				} catch (Exception e1) {
					System.out.print("No date added");
				}

			}
		});
		btnOk.setBounds(99, 229, 89, 23);
		contentPane.add(btnOk);
	}
}
