package hmsGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

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
        JFrame frame = new JFrame("HMS - Insertion Operations");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 450, 400);
        frame.getContentPane().setBackground(Color.white);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel(ManipulationOps.background);
        label.setBounds(0, 0, 400, 300);
        label.setOpaque(false);
        frame.setContentPane(label);
        

        // navigate to inserting a new nurse
        JButton btnInsertNurse = new JButton("Insert a new Nurse");
        btnInsertNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NurseInsertion.create();
            }
        });
        btnInsertNurse.setBounds(22, 32, 165, 23);
        btnInsertNurse.setContentAreaFilled(false);
        frame.add(btnInsertNurse);

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
        btnInsertJanitor.setContentAreaFilled(false);
        btnInsertJanitor.setBounds(22, 66, 165, 23);
        frame.add(btnInsertJanitor);

        // navigate to inserting a new doctor
        JButton btnInsertDoctor = new JButton("Insert a new Doctor");
        btnInsertDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorInsertion.create();
            }
        });
        btnInsertDoctor.setContentAreaFilled(false);
        btnInsertDoctor.setBounds(22, 100, 165, 23);
        frame.add(btnInsertDoctor);

        // navigate to inserting a new room
        JButton btnInsertRoom = new JButton("Insert a new Room");
        btnInsertRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RoomInsertion.create();
            }
        });
        btnInsertRoom.setContentAreaFilled(false);
        btnInsertRoom.setBounds(22, 134, 165, 23);
        frame.add(btnInsertRoom);

        // navigate to inserting a new bill
        JButton btnInsertBill = new JButton("Insert a new Bill");
        btnInsertBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BillInsertion.create();
            }
        });
        btnInsertBill.setContentAreaFilled(false);
        btnInsertBill.setBounds(22, 168, 165, 23);
        frame.add(btnInsertBill);

        // navigate to inserting a new patient
        JButton btnInsertPatient = new JButton("Insert a new Patient");
        btnInsertPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientInsertion.create();
            }
        });
        btnInsertPatient.setContentAreaFilled(false);
        btnInsertPatient.setBounds(22, 202, 165, 23);
        frame.add(btnInsertPatient);

        // navigate to inserting a new medicine
        JButton btnInsertMedicine = new JButton("Insert a new Medicine");
        btnInsertMedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicineInsertion.create();
            }
        });
        btnInsertMedicine.setContentAreaFilled(false);
        btnInsertMedicine.setBounds(22, 236, 165, 23);
        frame.add(btnInsertMedicine);

        // navigate to inserting a new cashier
        JButton btnInsertCashier = new JButton("Insert a new Cashier");
        btnInsertCashier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 CashierInsertion.create();
            }
        });
        btnInsertCashier.setContentAreaFilled(false);
        btnInsertCashier.setBounds(22, 270, 165, 23);
        frame.add(btnInsertCashier);

        // navigate to inserting a new treatment ('treat' table)
        JButton btnInsertTreatment = new JButton("Insert a new Treatment");
        btnInsertTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreatmentInsertion.create();
            }
        });
        btnInsertTreatment.setContentAreaFilled(false);
        btnInsertTreatment.setBounds(22, 304, 165, 23);
        frame.add(btnInsertTreatment);

    }
}
