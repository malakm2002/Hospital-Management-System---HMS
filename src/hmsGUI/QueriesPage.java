package hmsGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    /**
     * Creates the page containing all the buttons relating to query/retrieval operations
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Query Operations");

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
        frame.setBounds(100, 100, 400, 400);

        JLabel label = new JLabel(ManipulationOps.background);
        label.setBounds(0, 0, 400, 300);
        label.setOpaque(false);
        frame.setContentPane(label);
        

        // navigates to viewing patients check in on a specific date
        JButton btnPatientOnDay = new JButton("View patient on date");
        btnPatientOnDay.setFont(new Font("arial-bold",Font.BOLD,11));
        btnPatientOnDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientOnDay.create();
            }
        });
        btnPatientOnDay.setContentAreaFilled(false);
        btnPatientOnDay.setBounds(22, 32, 165, 23);
        frame.add(btnPatientOnDay);

        // navigates to doctors of a certain specialty
        JButton btnDoctorsFromSPecialty = new JButton("View specialty doctors");
        btnDoctorsFromSPecialty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorsFromSpecialty.create();
            }
        });
        btnDoctorsFromSPecialty.setFont(new Font("arial-bold",Font.BOLD,11));

        btnDoctorsFromSPecialty.setContentAreaFilled(false);
        btnDoctorsFromSPecialty.setBounds(22, 64, 165, 23);
        frame.add(btnDoctorsFromSPecialty);

        // navigates to the patients of a specific doctor
        JButton btnPatientsFromDoctor = new JButton("View doctor patients");
        btnPatientsFromDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfADoctor.create();
            }
        });
        btnPatientsFromDoctor.setFont(new Font("arial-bold",Font.BOLD,11));

        btnPatientsFromDoctor.setContentAreaFilled(false);
        btnPatientsFromDoctor.setBounds(22, 96, 165, 23);
        frame.add(btnPatientsFromDoctor);

        // navigates to viewing the patients of a specific nurse
        JButton btnPatientsFromNurse = new JButton("View nurse patients");
        btnPatientsFromNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfANurse.create();
            }
        });
        btnPatientsFromNurse.setFont(new Font("arial-bold",Font.BOLD,11));

        btnPatientsFromNurse.setContentAreaFilled(false);
        btnPatientsFromNurse.setBounds(22, 128, 165, 23);
        frame.add(btnPatientsFromNurse);

        // navigates to viewing the medicine of a specific patient
        JButton btnMedsFromPatient = new JButton("View patient medications");
        btnMedsFromPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicationsOfAPatient.create();
            }
        });
        btnMedsFromPatient.setFont(new Font("arial-bold",Font.BOLD,11));

        btnMedsFromPatient.setContentAreaFilled(false);
        btnMedsFromPatient.setBounds(22, 160, 165, 23);
        frame.add(btnMedsFromPatient);

        // navigates to viewing if a certain patient has been previously checked in
        JButton btnPatientRecord = new JButton("Check patient existence");
        btnPatientRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckPatientExistence.create();
            }
        });
        btnPatientRecord.setFont(new Font("arial-bold",Font.BOLD,11));
        btnPatientRecord.setContentAreaFilled(false);
        btnPatientRecord.setBounds(22, 192, 165, 23);
        frame.add(btnPatientRecord);
    }
}
