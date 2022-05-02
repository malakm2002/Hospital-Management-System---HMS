package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Queries.CheckPatientExistence;
import hmsGUI.Queries.DoctorsFromSpecialty;
import hmsGUI.Queries.MedicationsOfAPatient;
import hmsGUI.Queries.PatientOnDay;
import hmsGUI.Queries.PatientsOfADoctor;
import hmsGUI.Queries.PatientsOfANurse;



public class QueriesPage {

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

        JButton btnPatientOnDay = new JButton("View patient on date");
        btnPatientOnDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientOnDay.create();
            }
        });
        btnPatientOnDay.setBounds(22, 32, 165, 23);
        contentPane.add(btnPatientOnDay);

        JButton btnDoctorsFromSPecialty = new JButton("View specialty doctors");
        btnDoctorsFromSPecialty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorsFromSpecialty.create();
            }
        });
        btnDoctorsFromSPecialty.setBounds(22, 64, 165, 23);
        contentPane.add(btnDoctorsFromSPecialty);

        JButton btnPatientsFromDoctor = new JButton("View doctor patients");
        btnPatientsFromDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfADoctor.create();
            }
        });
        btnPatientsFromDoctor.setBounds(22, 96, 165, 23);
        contentPane.add(btnPatientsFromDoctor);

        JButton btnPatientsFromNurse = new JButton("View nurse patients");
        btnPatientsFromNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfANurse.create();
            }
        });
        btnPatientsFromNurse.setBounds(22, 128, 165, 23);
        contentPane.add(btnPatientsFromNurse);

        JButton btnMedsFromPatient = new JButton("View patient medications");
        btnMedsFromPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicationsOfAPatient.create();
            }
        });
        btnMedsFromPatient.setBounds(22, 160, 165, 23);
        contentPane.add(btnMedsFromPatient);

        JButton btnPatientRecord = new JButton("Check patient existence");
        btnPatientRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckPatientExistence.create();
            }
        });
        btnPatientRecord.setBounds(22, 192, 165, 23);
        contentPane.add(btnPatientRecord);

    }
}
