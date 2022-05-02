package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Deletions.DeleteOther;
import hmsGUI.Deletions.DeleteStaff;
import hmsGUI.Insertions.BillInsertion;
import hmsGUI.Insertions.CashierInsertion;
import hmsGUI.Insertions.DoctorInsertion;
import hmsGUI.Insertions.JanitorInsertion;
import hmsGUI.Insertions.MedicineInsertion;
import hmsGUI.Insertions.NurseInsertion;
import hmsGUI.Insertions.PatientInsertion;
import hmsGUI.Insertions.RoomInsertion;
import hmsGUI.Insertions.TreatmentInsertion;
import hmsGUI.Queries.CheckPatientExistence;
import hmsGUI.Queries.DoctorsFromSpecialty;
import hmsGUI.Queries.MedicationsOfAPatient;
import hmsGUI.Queries.PatientOnDay;
import hmsGUI.Queries.PatientsOfADoctor;
import hmsGUI.Queries.PatientsOfANurse;
import hmsGUI.Updates.BillUpdate;
import hmsGUI.Updates.DoctorUpdate;
import hmsGUI.Updates.RoomUpdate;
import hmsGUI.Updates.StaffRecUpdate;
import hmsGUI.Updates.patientRecUpdate;

public class ManipulationOps {
    public static void createFrame() {
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

        JButton btnInsertNurse = new JButton("Insert a new Nurse");
        btnInsertNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NurseInsertion.create();
            }
        });
        btnInsertNurse.setBounds(22, 32, 165, 23);
        contentPane.add(btnInsertNurse);

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

        JButton btnInsertDoctor = new JButton("Insert a new Doctor");
        btnInsertDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorInsertion.create();

            }
        });
        btnInsertDoctor.setBounds(22, 100, 165, 23);
        contentPane.add(btnInsertDoctor);

        JButton btnInsertRoom = new JButton("Insert a new Room");
        btnInsertRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RoomInsertion.create();
            }
        });
        btnInsertRoom.setBounds(22, 134, 165, 23);
        contentPane.add(btnInsertRoom);

        JButton btnInsertBill = new JButton("Insert a new Bill");
        btnInsertBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BillInsertion.create();
            }
        });
        btnInsertBill.setBounds(22, 168, 165, 23);
        contentPane.add(btnInsertBill);

        JButton btnInsertPatient = new JButton("Insert a new Patient");
        btnInsertPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientInsertion.create();
            }
        });
        btnInsertPatient.setBounds(22, 202, 165, 23);
        contentPane.add(btnInsertPatient);

        JButton btnInsertMedicine = new JButton("Insert a new Medicine");
        btnInsertMedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicineInsertion.create();
            }
        });
        btnInsertMedicine.setBounds(22, 236, 165, 23);
        contentPane.add(btnInsertMedicine);

        JButton btnInsertRecord = new JButton("Insert a new Cashier");
        btnInsertRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 CashierInsertion.create();

            }
        });
        btnInsertRecord.setBounds(22, 270, 165, 23);
        contentPane.add(btnInsertRecord);

        JButton btnInsertTreatment = new JButton("Insert a new Treatment");
        btnInsertTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreatmentInsertion.create();
            }
        });
        btnInsertTreatment.setBounds(22, 304, 165, 23);
        contentPane.add(btnInsertTreatment);

        JButton btnDeleteOtherStaff = new JButton("Delete staff");
        btnDeleteOtherStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStaff.create();
            }
        });
        btnDeleteOtherStaff.setBounds(222, 32, 165, 23);
        contentPane.add(btnDeleteOtherStaff);

        JButton btnDeleteOther = new JButton("Delete other values");
        btnDeleteOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOther.create();
            }
        });
        btnDeleteOther.setBounds(222, 66, 165, 23);
        contentPane.add(btnDeleteOther);

        JButton btnPatientOnDay = new JButton("View patient on date");
        btnPatientOnDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientOnDay.create();
            }
        });
        btnPatientOnDay.setBounds(222, 100, 165, 23);
        contentPane.add(btnPatientOnDay);

        JButton btnDoctorsFromSPecialty = new JButton("View specialty doctors");
        btnDoctorsFromSPecialty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorsFromSpecialty.create();
            }
        });
        btnDoctorsFromSPecialty.setBounds(222, 134, 165, 23);
        contentPane.add(btnDoctorsFromSPecialty);

        JButton btnPatientsFromDoctor = new JButton("View doctor patients");
        btnPatientsFromDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfADoctor.create();
            }
        });
        btnPatientsFromDoctor.setBounds(222, 168, 165, 23);
        contentPane.add(btnPatientsFromDoctor);

        JButton btnPatientsFromNurse = new JButton("View nurse patients");
        btnPatientsFromNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsOfANurse.create();
            }
        });
        btnPatientsFromNurse.setBounds(222, 202, 165, 23);
        contentPane.add(btnPatientsFromNurse);

        JButton btnMedsFromPatient = new JButton("View patient medications");
        btnMedsFromPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicationsOfAPatient.create();
            }
        });
        btnMedsFromPatient.setBounds(222, 236, 165, 23);
        contentPane.add(btnMedsFromPatient);

        JButton btnPatientRecord = new JButton("Check patient existence");
        btnPatientRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckPatientExistence.create();
            }
        });
        btnPatientRecord.setBounds(222, 270, 165, 23);
        contentPane.add(btnPatientRecord);

        JButton btnUpdateNurse = new JButton("Update Staff Records");
        btnUpdateNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffRecUpdate.create();
            }
        });
        btnUpdateNurse.setBounds(222, 304, 165, 23);
        contentPane.add(btnUpdateNurse);

        JButton btnUpdatedocInfo = new JButton("Update Doctor Info");
        btnUpdatedocInfo.setBounds(420, 32, 165, 23);
        contentPane.add(btnUpdatedocInfo);
        btnUpdatedocInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorUpdate.create();
            }
        });
        JButton btnUpdatePatientInfo = new JButton("Update Patient Info");
        btnUpdatePatientInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientRecUpdate.create();
            }
        });
        btnUpdatePatientInfo.setBounds(420, 66, 165, 23);
        contentPane.add(btnUpdatePatientInfo);
        
        JButton btnUpdateRoom = new JButton("Update Room Info");
        btnUpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomUpdate.create();
            }
        });
        btnUpdateRoom.setBounds(420, 100, 165, 23);
        contentPane.add(btnUpdateRoom);

        JButton btnUpdateBill = new JButton("Update Bill Info");
        btnUpdateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillUpdate.create();
            }
        });
        btnUpdateBill.setBounds(420, 134, 165, 23);
        contentPane.add(btnUpdateBill);
        
        
    }
}
