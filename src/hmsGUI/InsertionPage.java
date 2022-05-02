package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Insertions.BillInsertion;
import hmsGUI.Insertions.CashierInsertion;
import hmsGUI.Insertions.DoctorInsertion;
import hmsGUI.Insertions.JanitorInsertion;
import hmsGUI.Insertions.MedicineInsertion;
import hmsGUI.Insertions.NurseInsertion;
import hmsGUI.Insertions.PatientInsertion;
import hmsGUI.Insertions.RoomInsertion;
import hmsGUI.Insertions.TreatmentInsertion;

public class InsertionPage {
    /**
     * Creates the page containing all the buttons relating to insertion operations
     */
    public static void create() {
        // title
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

        // navigate to inserting a new nurse
        JButton btnInsertNurse = new JButton("Insert a new Nurse");
        btnInsertNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NurseInsertion.create();
            }
        });
        btnInsertNurse.setBounds(22, 32, 165, 23);
        contentPane.add(btnInsertNurse);

        // navigate to inserting a new janitor
        JButton btnInsertJanitor = new JButton("Insert a new Janitor");
        btnInsertJanitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JanitorInsertion.create();                    
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        btnInsertJanitor.setBounds(22, 66, 165, 23);
        contentPane.add(btnInsertJanitor);

        // navigate to inserting a new doctor
        JButton btnInsertDoctor = new JButton("Insert a new Doctor");
        btnInsertDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorInsertion.create();
            }
        });
        btnInsertDoctor.setBounds(22, 100, 165, 23);
        contentPane.add(btnInsertDoctor);

        // navigate to inserting a new room
        JButton btnInsertRoom = new JButton("Insert a new Room");
        btnInsertRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RoomInsertion.create();
            }
        });
        btnInsertRoom.setBounds(22, 134, 165, 23);
        contentPane.add(btnInsertRoom);

        // navigate to inserting a new bill
        JButton btnInsertBill = new JButton("Insert a new Bill");
        btnInsertBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BillInsertion.create();
            }
        });
        btnInsertBill.setBounds(22, 168, 165, 23);
        contentPane.add(btnInsertBill);

        // navigate to inserting a new patient
        JButton btnInsertPatient = new JButton("Insert a new Patient");
        btnInsertPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientInsertion.create();
            }
        });
        btnInsertPatient.setBounds(22, 202, 165, 23);
        contentPane.add(btnInsertPatient);

        // navigate to inserting a new medicine
        JButton btnInsertMedicine = new JButton("Insert a new Medicine");
        btnInsertMedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicineInsertion.create();
            }
        });
        btnInsertMedicine.setBounds(22, 236, 165, 23);
        contentPane.add(btnInsertMedicine);

        // navigate to inserting a new cashier
        JButton btnInsertRecord = new JButton("Insert a new Cashier");
        btnInsertRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 CashierInsertion.create();
            }
        });
        btnInsertRecord.setBounds(22, 270, 165, 23);
        contentPane.add(btnInsertRecord);

        // navigate to inserting a new treatment ('treat' table)
        JButton btnInsertTreatment = new JButton("Insert a new Treatment");
        btnInsertTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreatmentInsertion.create();
            }
        });
        btnInsertTreatment.setBounds(22, 304, 165, 23);
        contentPane.add(btnInsertTreatment);
    }
}
